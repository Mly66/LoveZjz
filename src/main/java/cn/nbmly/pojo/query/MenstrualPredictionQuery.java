package cn.nbmly.pojo.query;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 生理期预测查询入参实体类
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class MenstrualPredictionQuery {

    /**
     * 用户ID:用户id，必填
     */
    @NotNull(groups = QueryGroup.class, message = "用户ID不能为空")
    @Schema(description = "用户ID:用户id，必填")
    private Integer userId;

    /**
     * 页码:分页查询的页码，必填
     */
    @NotNull(groups = QueryGroup.class, message = "页码不能为空")
    @Schema(description = "页码:分页查询的页码，必填")
    private Integer pageIndex;

    /**
     * 每页数量:分页查询的每页数量，必填
     */
    @NotNull(groups = QueryGroup.class, message = "每页数量不能为空")
    @Schema(description = "每页数量:分页查询的每页数量，必填")
    private Integer pageSize;
}
