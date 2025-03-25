package cn.nbmly.pojo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import cn.nbmly.pojo.query.QueryGroup;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 生理期记录入参实体类
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class MenstrualRecordDTO {

    /**
     * 记录ID:记录id，必填
     */
    @NotNull(groups = { UpdateGroup.class, DeleteGroup.class }, message = "记录ID不能为空")
    @Schema(description = "记录ID:记录id，必填")
    private Integer recordId;

    /**
     * 用户ID:用户id，必填
     */
    @NotNull(groups = { CreateGroup.class, QueryGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID:用户id，必填")
    private Integer userId;

    /**
     * 生理期开始日期:生理期开始日期，必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "开始日期不能为空")
    @Schema(description = "生理期开始日期:生理期开始日期，必填")
    private Date startDate;

    /**
     * 生理期结束日期:生理期结束日期，必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "结束日期不能为空")
    @Schema(description = "生理期结束日期:生理期结束日期，必填")
    private Date endDate;
}
