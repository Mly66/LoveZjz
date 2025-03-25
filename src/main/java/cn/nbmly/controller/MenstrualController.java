package cn.nbmly.controller;

import cn.nbmly.constant.ResultCodeConstant;
import cn.nbmly.pojo.domain.MenstrualPredictionDO;
import cn.nbmly.pojo.domain.MenstrualRecordDO;
import cn.nbmly.pojo.dto.CreateGroup;
import cn.nbmly.pojo.dto.DeleteGroup;
import cn.nbmly.pojo.dto.MenstrualPredictionDTO;
import cn.nbmly.pojo.dto.MenstrualRecordDTO;
import cn.nbmly.pojo.dto.RestResult;
import cn.nbmly.pojo.dto.UpdateGroup;
import cn.nbmly.pojo.query.MenstrualPredictionQuery;
import cn.nbmly.pojo.query.MenstrualRecordQuery;
import cn.nbmly.pojo.query.QueryGroup;
import cn.nbmly.pojo.vo.PageResult;
import cn.nbmly.service.MenstrualService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生理期记录与预测
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Tag(name = "生理期记录与预测")
@RequestMapping("menstrual")
@RestController
public class MenstrualController {

    @Autowired
    private MenstrualService menstrualService;

    /**
     * 记录生理期:保存生理期记录到数据库
     *
     * @param menstrualRecordDTO 生理期记录入参实体类
     * @return
     */
    @RequestMapping(value = "/record", method = RequestMethod.POST)
    @Operation(summary = "记录生理期:保存生理期记录到数据库")
    @ResponseBody
    public RestResult<Boolean> recordMenstrualPeriod(@RequestBody @Validated(CreateGroup.class) MenstrualRecordDTO menstrualRecordDTO) {
        Boolean result = menstrualService.recordMenstrualPeriod(menstrualRecordDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询生理期记录:查询该用户的生理期记录
     *
     * @param menstrualRecordQuery 生理期记录查询入参实体类
     * @return
     */
    @RequestMapping(value = "/records", method = RequestMethod.GET)
    @Operation(summary = "查询生理期记录:查询该用户的生理期记录")
    public RestResult<PageResult<MenstrualRecordDO>> queryMenstrualRecords(@Validated(QueryGroup.class) MenstrualRecordQuery menstrualRecordQuery) {
        PageResult<MenstrualRecordDO> result = menstrualService.queryMenstrualRecords(menstrualRecordQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 更新生理期记录:更新生理期记录到数据库
     *
     * @param menstrualRecordDTO 生理期记录入参实体类
     * @return
     */
    @RequestMapping(value = "/record", method = RequestMethod.PUT)
    @Operation(summary = "更新生理期记录:更新生理期记录到数据库")
    @ResponseBody
    public RestResult<Boolean> updateMenstrualRecord(@RequestBody @Validated(UpdateGroup.class) MenstrualRecordDTO menstrualRecordDTO) {
        Boolean result = menstrualService.updateMenstrualRecord(menstrualRecordDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除生理期记录:删除生理期记录
     *
     * @param menstrualRecordDTO 生理期记录入参实体类
     * @return
     */
    @RequestMapping(value = "/record", method = RequestMethod.DELETE)
    @Operation(summary = "删除生理期记录:删除生理期记录")
    @ResponseBody
    public RestResult<Boolean> deleteMenstrualRecord(@RequestBody @Validated(DeleteGroup.class) MenstrualRecordDTO menstrualRecordDTO) {
        Boolean result = menstrualService.deleteMenstrualRecord(menstrualRecordDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 预测未来生理期:保存预测结果到数据库
     *
     * @param menstrualPredictionDTO 生理期预测入参实体类
     * @return
     */
    @RequestMapping(value = "/predict", method = RequestMethod.POST)
    @Operation(summary = "预测未来生理期:保存预测结果到数据库")
    @ResponseBody
    public RestResult<Boolean> predictMenstrualPeriod(@RequestBody @Validated(CreateGroup.class) MenstrualPredictionDTO menstrualPredictionDTO) {
        Boolean result = menstrualService.predictMenstrualPeriod(menstrualPredictionDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 查询生理期预测结果:查询该用户的生理期预测结果
     *
     * @param menstrualPredictionQuery 生理期预测查询入参实体类
     * @return
     */
    @RequestMapping(value = "/predictions", method = RequestMethod.GET)
    @Operation(summary = "查询生理期预测结果:查询该用户的生理期预测结果")
    public RestResult<PageResult<MenstrualPredictionDO>> queryMenstrualPredictions(@Validated(QueryGroup.class) MenstrualPredictionQuery menstrualPredictionQuery) {
        PageResult<MenstrualPredictionDO> result = menstrualService.queryMenstrualPredictions(menstrualPredictionQuery);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
