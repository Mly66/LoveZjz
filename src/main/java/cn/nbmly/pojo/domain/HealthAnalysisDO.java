package cn.nbmly.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 健康分析实体
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("health_analysis")
public class HealthAnalysisDO {

    /**
     * 分析id: 分析ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "分析id: 分析ID")
    private Integer analysisId;

    /**
     * 用户id: 用户ID
     */
    @Schema(description = "用户id: 用户ID")
    private Integer userId;

    /**
     * 周期长度: 周期长度
     */
    @Schema(description = "周期长度: 周期长度")
    private Integer cycleLength;

    /**
     * 分析日期: 分析日期
     */
    @Schema(description = "分析日期: 分析日期")
    private Date analysisDate;

    /**
     * 健康建议: 健康建议
     */
    @Schema(description = "健康建议: 健康建议")
    private String healthSuggestion;

    /**
     * 创建人: 创建人
     */
    @Schema(description = "创建人: 创建人")
    private Integer createBy;

    /**
     * 创建时间: 创建时间
     */
    @Schema(description = "创建时间: 创建时间")
    private Date createTime;

    /**
     * 修改人: 修改人
     */
    @Schema(description = "修改人: 修改人")
    private Integer updateBy;

    /**
     * 修改时间: 修改时间
     */
    @Schema(description = "修改时间: 修改时间")
    private Date updateTime;
}
