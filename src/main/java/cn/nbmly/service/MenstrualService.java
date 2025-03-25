package cn.nbmly.service;

import cn.nbmly.pojo.domain.MenstrualPredictionDO;
import cn.nbmly.pojo.domain.MenstrualRecordDO;
import cn.nbmly.pojo.dto.MenstrualPredictionDTO;
import cn.nbmly.pojo.dto.MenstrualRecordDTO;
import cn.nbmly.pojo.query.MenstrualPredictionQuery;
import cn.nbmly.pojo.query.MenstrualRecordQuery;
import cn.nbmly.pojo.vo.PageResult;
import java.lang.Boolean;

/**
 * 生理期记录与预测
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
public interface MenstrualService {

    /**
     * 记录生理期:保存生理期记录到数据库
     *
     * @param menstrualRecordDTO 生理期记录入参实体类
     * @return
     */
    Boolean recordMenstrualPeriod(MenstrualRecordDTO menstrualRecordDTO);

    /**
     * 查询生理期记录:查询该用户的生理期记录
     *
     * @param menstrualRecordQuery 生理期记录查询入参实体类
     * @return
     */
    PageResult<MenstrualRecordDO> queryMenstrualRecords(MenstrualRecordQuery menstrualRecordQuery);

    /**
     * 更新生理期记录:更新生理期记录到数据库
     *
     * @param menstrualRecordDTO 生理期记录入参实体类
     * @return
     */
    Boolean updateMenstrualRecord(MenstrualRecordDTO menstrualRecordDTO);

    /**
     * 删除生理期记录:删除生理期记录
     *
     * @param menstrualRecordDTO 生理期记录入参实体类
     * @return
     */
    Boolean deleteMenstrualRecord(MenstrualRecordDTO menstrualRecordDTO);

    /**
     * 预测未来生理期:保存预测结果到数据库
     *
     * @param menstrualPredictionDTO 生理期预测入参实体类
     * @return
     */
    Boolean predictMenstrualPeriod(MenstrualPredictionDTO menstrualPredictionDTO);

    /**
     * 查询生理期预测结果:查询该用户的生理期预测结果
     *
     * @param menstrualPredictionQuery 生理期预测查询入参实体类
     * @return
     */
    PageResult<MenstrualPredictionDO> queryMenstrualPredictions(MenstrualPredictionQuery menstrualPredictionQuery);
}
