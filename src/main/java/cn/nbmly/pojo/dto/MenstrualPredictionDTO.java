package cn.nbmly.pojo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 生理期预测入参实体类
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class MenstrualPredictionDTO {

    /**
     * 用户ID:用户id，必填
     */
    @NotNull(groups = CreateGroup.class, message = "用户ID不能为空")
    @Schema(description = "用户ID:用户id，必填")
    private Integer userId;
}
