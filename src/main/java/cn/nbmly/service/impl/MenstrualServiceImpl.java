package cn.nbmly.service.impl;

import cn.nbmly.dao.MenstrualPredictionMapper;
import cn.nbmly.dao.MenstrualRecordMapper;
import cn.nbmly.dao.UserMapper;
import cn.nbmly.pojo.domain.MenstrualPredictionDO;
import cn.nbmly.pojo.domain.MenstrualRecordDO;
import cn.nbmly.pojo.dto.MenstrualPredictionDTO;
import cn.nbmly.pojo.dto.MenstrualRecordDTO;
import cn.nbmly.pojo.query.MenstrualPredictionQuery;
import cn.nbmly.pojo.query.MenstrualRecordQuery;
import cn.nbmly.pojo.vo.PageResult;
import cn.nbmly.service.MenstrualService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.nbmly.exception.BusinessException;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.nbmly.pojo.domain.UserDO;
import java.util.Map;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.nbmly.constant.ResultCodeConstant;
import java.util.Calendar;
import java.util.Date;

/**
 * 生理期记录与预测的实现
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Service
public class MenstrualServiceImpl implements MenstrualService {

    @Autowired
    private MenstrualRecordMapper menstrualRecordMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenstrualPredictionMapper menstrualPredictionMapper;

    @Override
    public Boolean recordMenstrualPeriod(MenstrualRecordDTO menstrualRecordDTO) {
        // 验证用户信息是否存在
        UserDO userDO = userMapper.selectById(menstrualRecordDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 验证startDate是否早于或等于endDate
        if (menstrualRecordDTO.getStartDate().after(menstrualRecordDTO.getEndDate())) {
            throw new BusinessException(ResultCodeConstant.CODE_000002, ResultCodeConstant.CODE_000002_MSG);
        }
        // 保存生理期记录到数据库
        MenstrualRecordDO menstrualRecordDO = new MenstrualRecordDO();
        menstrualRecordDO.setUserId(menstrualRecordDTO.getUserId());
        menstrualRecordDO.setStartDate(menstrualRecordDTO.getStartDate());
        menstrualRecordDO.setEndDate(menstrualRecordDTO.getEndDate());
        menstrualRecordMapper.insert(menstrualRecordDO);
        return true;
    }

    @Override
    public PageResult<MenstrualRecordDO> queryMenstrualRecords(MenstrualRecordQuery menstrualRecordQuery) {
        // 验证用户信息是否存在
        UserDO userDO = userMapper.selectById(menstrualRecordQuery.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 查询该用户的生理期记录
        IPage<MenstrualRecordDO> page = new Page<>(menstrualRecordQuery.getPageIndex(),
                menstrualRecordQuery.getPageSize());
        QueryWrapper<MenstrualRecordDO> queryWrapper = Wrappers.<MenstrualRecordDO>query().eq("user_id",
                menstrualRecordQuery.getUserId());
        IPage<MenstrualRecordDO> menstrualRecordsPage = menstrualRecordMapper.selectPage(page, queryWrapper);
        PageResult<MenstrualRecordDO> pageResult = new PageResult<>(
                menstrualRecordsPage.getTotal(),
                menstrualRecordsPage.getCurrent(),
                menstrualRecordsPage.getSize(),
                menstrualRecordsPage.getRecords());
        return pageResult;
    }

    @Override
    public Boolean updateMenstrualRecord(MenstrualRecordDTO menstrualRecordDTO) {
        // 验证记录信息是否存在
        MenstrualRecordDO menstrualRecordDO = menstrualRecordMapper.selectById(menstrualRecordDTO.getRecordId());
        if (menstrualRecordDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000003, ResultCodeConstant.CODE_000003_MSG);
        }
        // 验证startDate是否早于或等于endDate
        if (menstrualRecordDTO.getStartDate().after(menstrualRecordDTO.getEndDate())) {
            throw new BusinessException(ResultCodeConstant.CODE_000002, ResultCodeConstant.CODE_000002_MSG);
        }
        // 更新生理期记录到数据库
        menstrualRecordDO.setStartDate(menstrualRecordDTO.getStartDate());
        menstrualRecordDO.setEndDate(menstrualRecordDTO.getEndDate());
        menstrualRecordMapper.updateById(menstrualRecordDO);
        return true;
    }

    @Override
    public Boolean deleteMenstrualRecord(MenstrualRecordDTO menstrualRecordDTO) {
        // 验证记录信息是否存在
        MenstrualRecordDO menstrualRecordDO = menstrualRecordMapper.selectById(menstrualRecordDTO.getRecordId());
        if (menstrualRecordDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000003, ResultCodeConstant.CODE_000003_MSG);
        }
        // 删除生理期记录
        menstrualRecordMapper.deleteById(menstrualRecordDTO.getRecordId());
        return true;
    }

    @Override
    public Boolean predictMenstrualPeriod(MenstrualPredictionDTO menstrualPredictionDTO) {
        // 验证用户信息是否存在
        UserDO userDO = userMapper.selectById(menstrualPredictionDTO.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 查询该用户的生理期记录进行预测
        List<MenstrualRecordDO> menstrualRecords = menstrualRecordMapper
                .selectList(Wrappers.<MenstrualRecordDO>query().eq("user_id", menstrualPredictionDTO.getUserId()));
        if (menstrualRecords.isEmpty()) {
            throw new BusinessException(ResultCodeConstant.CODE_000004, ResultCodeConstant.CODE_000004_MSG);
        }
        // 预测逻辑假设为：未来生理期开始日期为上一个周期结束日期后28天
        MenstrualRecordDO lastRecord = menstrualRecords.get(menstrualRecords.size() - 1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastRecord.getEndDate());
        calendar.add(Calendar.DAY_OF_MONTH, 28);
        Date predictedStartDate = calendar.getTime();
        // 假设周期为28天
        calendar.add(Calendar.DAY_OF_MONTH, 28);
        Date predictedEndDate = calendar.getTime();
        // 保存预测结果到数据库
        MenstrualPredictionDO menstrualPredictionDO = new MenstrualPredictionDO();
        menstrualPredictionDO.setUserId(menstrualPredictionDTO.getUserId());
        menstrualPredictionDO.setPredictedStartDate(predictedStartDate);
        menstrualPredictionDO.setPredictedEndDate(predictedEndDate);
        menstrualPredictionMapper.insert(menstrualPredictionDO);
        return true;
    }

    @Override
    public PageResult<MenstrualPredictionDO> queryMenstrualPredictions(
            MenstrualPredictionQuery menstrualPredictionQuery) {
        // 验证用户信息是否存在
        UserDO userDO = userMapper.selectById(menstrualPredictionQuery.getUserId());
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        // 查询该用户的生理期预测结果
        IPage<MenstrualPredictionDO> page = new Page<>(menstrualPredictionQuery.getPageIndex(),
                menstrualPredictionQuery.getPageSize());
        QueryWrapper<MenstrualPredictionDO> queryWrapper = Wrappers.<MenstrualPredictionDO>query().eq("user_id",
                menstrualPredictionQuery.getUserId());
        IPage<MenstrualPredictionDO> menstrualPredictionsPage = menstrualPredictionMapper.selectPage(page,
                queryWrapper);
        PageResult<MenstrualPredictionDO> pageResult = new PageResult<>(
                menstrualPredictionsPage.getTotal(),
                menstrualPredictionsPage.getCurrent(),
                menstrualPredictionsPage.getSize(),
                menstrualPredictionsPage.getRecords());
        return pageResult;
    }
}
