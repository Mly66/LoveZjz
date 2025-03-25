package cn.nbmly.controller;

import cn.nbmly.constant.ResultCodeConstant;
import cn.nbmly.pojo.domain.HealthAnalysisDO;
import cn.nbmly.pojo.dto.AnalysisDTO;
import cn.nbmly.pojo.dto.CreateGroup;
import cn.nbmly.pojo.dto.RestResult;
import cn.nbmly.pojo.dto.UpdateGroup;
import cn.nbmly.pojo.query.HealthAnalysisQuery;
import cn.nbmly.pojo.query.QueryGroup;
import cn.nbmly.service.HealthAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据分析与健康建议
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Tag(name = "数据分析与健康建议")
@RequestMapping("health-analysis")
@RestController
public class HealthAnalysisController {

    @Autowired
    private HealthAnalysisService healthAnalysisService;

    /**
     * 分析生理期周期: 根据用户id获取生理期记录并计算周期长度，然后将周期长度保存到health_analysis表
     *
     * @param analysisDTO 分析DTO
     * @return
     */
    @RequestMapping(value = "/analyze-menstrual-cycle", method = RequestMethod.POST)
    @Operation(summary = "分析生理期周期: 根据用户id获取生理期记录并计算周期长度，然后将周期长度保存到health_analysis表")
    @ResponseBody
    public RestResult<Boolean> analyzeMenstrualCycle(@RequestBody @Validated(CreateGroup.class) AnalysisDTO analysisDTO) {
        Boolean result = healthAnalysisService.analyzeMenstrualCycle(analysisDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取健康建议: 根据用户id获取最新的健康建议
     *
     * @param query 健康分析查询
     * @return
     */
    @RequestMapping(value = "/get-health-suggestion", method = RequestMethod.GET)
    @Operation(summary = "获取健康建议: 根据用户id获取最新的健康建议")
    public RestResult<String> getHealthSuggestion(@Validated(QueryGroup.class) HealthAnalysisQuery query) {
        String result = healthAnalysisService.getHealthSuggestion(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 更新健康建议: 根据分析id更新健康建议
     *
     * @param analysisDTO 分析DTO
     * @return
     */
    @RequestMapping(value = "/update-health-suggestion", method = RequestMethod.PUT)
    @Operation(summary = "更新健康建议: 根据分析id更新健康建议")
    public RestResult<Boolean> updateHealthSuggestion(@Validated(UpdateGroup.class) AnalysisDTO analysisDTO) {
        Boolean result = healthAnalysisService.updateHealthSuggestion(analysisDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 获取生理期记录分析: 根据用户id获取最新的生理期周期分析记录
     *
     * @param query 健康分析查询
     * @return
     */
    @RequestMapping(value = "/get-menstrual-analysis", method = RequestMethod.GET)
    @Operation(summary = "获取生理期记录分析: 根据用户id获取最新的生理期周期分析记录")
    public RestResult<HealthAnalysisDO> getMenstrualAnalysis(@Validated(QueryGroup.class) HealthAnalysisQuery query) {
        HealthAnalysisDO result = healthAnalysisService.getMenstrualAnalysis(query);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
