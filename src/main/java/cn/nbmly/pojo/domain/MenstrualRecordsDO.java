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
 * 生理期记录实体
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("menstrual_records")
public class MenstrualRecordsDO {

    /**
     * 记录id: 记录ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "记录id: 记录ID")
    private Integer recordId;

    /**
     * 用户id: 用户ID
     */
    @Schema(description = "用户id: 用户ID")
    private Integer userId;

    /**
     * 生理期开始日期: 生理期开始日期
     */
    @Schema(description = "生理期开始日期: 生理期开始日期")
    private Date startDate;

    /**
     * 生理期结束日期: 生理期结束日期
     */
    @Schema(description = "生理期结束日期: 生理期结束日期")
    private Date endDate;

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
