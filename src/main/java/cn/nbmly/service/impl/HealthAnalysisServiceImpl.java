package cn.nbmly.service.impl;

import cn.nbmly.dao.HealthAnalysisMapper;
import cn.nbmly.dao.MenstrualRecordsMapper;
import cn.nbmly.pojo.domain.HealthAnalysisDO;
import cn.nbmly.pojo.dto.AnalysisDTO;
import cn.nbmly.pojo.query.HealthAnalysisQuery;
import cn.nbmly.service.HealthAnalysisService;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.Date;
import cn.nbmly.pojo.domain.MenstrualRecordsDO;

/**
 * 数据分析与健康建议的实现
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Service
public class HealthAnalysisServiceImpl implements HealthAnalysisService {

    @Autowired
    private MenstrualRecordsMapper menstrualRecordsMapper;

    @Autowired
    private HealthAnalysisMapper healthAnalysisMapper;

    @Override
    public Boolean analyzeMenstrualCycle(AnalysisDTO analysisDTO) {
        QueryWrapper<MenstrualRecordsDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", analysisDTO.getUserId()).orderByDesc("start_date");
        // 只取最近两条记录以计算周期
        IPage<MenstrualRecordsDO> page = new Page<>(1, 2);
        IPage<MenstrualRecordsDO> recordsPage = menstrualRecordsMapper.selectPage(page, queryWrapper);
        List<MenstrualRecordsDO> records = recordsPage.getRecords();
        if (records == null || records.size() < 2) {
            // 不够记录无法计算周期
            return false;
        }
        MenstrualRecordsDO record1 = records.get(0);
        MenstrualRecordsDO record2 = records.get(1);
        int cycleLength = (int) ((record1.getStartDate().getTime() - record2.getStartDate().getTime()) / (24 * 60 * 60 * 1000));
        HealthAnalysisDO healthAnalysisDO = new HealthAnalysisDO();
        healthAnalysisDO.setUserId(analysisDTO.getUserId());
        healthAnalysisDO.setCycleLength(cycleLength);
        healthAnalysisDO.setAnalysisDate(new Date());
        healthAnalysisDO.setHealthSuggestion("健康建议待定");
        healthAnalysisDO.setCreateBy(analysisDTO.getUserId());
        healthAnalysisDO.setUpdateBy(analysisDTO.getUserId());
        int result = healthAnalysisMapper.insert(healthAnalysisDO);
        return result > 0;
    }

    @Override
    public String getHealthSuggestion(HealthAnalysisQuery query) {
        QueryWrapper<HealthAnalysisDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", query.getUserId()).orderByDesc("analysis_date").last("LIMIT 1");
        HealthAnalysisDO healthAnalysisDO = healthAnalysisMapper.selectOne(queryWrapper);
        String healthSuggestion = healthAnalysisDO != null ? healthAnalysisDO.getHealthSuggestion() : "暂无健康建议";
        return healthSuggestion;
    }

    @Override
    public Boolean updateHealthSuggestion(AnalysisDTO analysisDTO) {
        HealthAnalysisDO healthAnalysisDO = new HealthAnalysisDO();
        healthAnalysisDO.setAnalysisId(analysisDTO.getAnalysisId());
        healthAnalysisDO.setHealthSuggestion(analysisDTO.getHealthSuggestion());
        healthAnalysisDO.setUpdateBy(analysisDTO.getUserId());
        int result = healthAnalysisMapper.updateById(healthAnalysisDO);
        return result > 0;
    }

    @Override
    public HealthAnalysisDO getMenstrualAnalysis(HealthAnalysisQuery query) {
        QueryWrapper<HealthAnalysisDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", query.getUserId()).orderByDesc("analysis_date").last("LIMIT 1");
        HealthAnalysisDO healthAnalysisDO = healthAnalysisMapper.selectOne(queryWrapper);
        return healthAnalysisDO;
    }
}
