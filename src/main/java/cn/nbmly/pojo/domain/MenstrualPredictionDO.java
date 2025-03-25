package cn.nbmly.pojo.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 生理期预测
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
@TableName("menstrual_predictions")
public class MenstrualPredictionDO {

    /**
     * 预测ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "预测ID")
    private Integer predictionId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 预测生理期开始日期
     */
    @Schema(description = "预测生理期开始日期")
    private Date predictedStartDate;

    /**
     * 预测生理期结束日期
     */
    @Schema(description = "预测生理期结束日期")
    private Date predictedEndDate;

    /**
     * 预测日期
     */
    @Schema(description = "预测日期")
    private Date predictionDate;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Integer updateBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}
