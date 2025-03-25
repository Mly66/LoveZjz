package cn.nbmly.service;

import cn.nbmly.pojo.domain.HealthAnalysisDO;
import cn.nbmly.pojo.dto.AnalysisDTO;
import cn.nbmly.pojo.query.HealthAnalysisQuery;
import java.lang.Boolean;
import java.lang.String;

/**
 * 数据分析与健康建议
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
public interface HealthAnalysisService {

    /**
     * 分析生理期周期: 根据用户id获取生理期记录并计算周期长度，然后将周期长度保存到health_analysis表
     *
     * @param analysisDTO 分析DTO
     * @return
     */
    Boolean analyzeMenstrualCycle(AnalysisDTO analysisDTO);

    /**
     * 获取健康建议: 根据用户id获取最新的健康建议
     *
     * @param query 健康分析查询
     * @return
     */
    String getHealthSuggestion(HealthAnalysisQuery query);

    /**
     * 更新健康建议: 根据分析id更新健康建议
     *
     * @param analysisDTO 分析DTO
     * @return
     */
    Boolean updateHealthSuggestion(AnalysisDTO analysisDTO);

    /**
     * 获取生理期记录分析: 根据用户id获取最新的生理期周期分析记录
     *
     * @param query 健康分析查询
     * @return  健康分析实体
     */
    HealthAnalysisDO getMenstrualAnalysis(HealthAnalysisQuery query);
}
