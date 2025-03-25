package cn.nbmly.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 分析DTO
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class AnalysisDTO {

    /**
     * 用户id: 用户id，必填
     */
    @NotNull(groups = { CreateGroup.class, UpdateGroup.class }, message = "用户id不能为空")
    @Schema(description = "用户id: 用户id，必填")
    private Integer userId;

    /**
     * 分析id: 分析id，必填
     */
    @NotNull(groups = { UpdateGroup.class }, message = "分析id不能为空")
    @Positive(groups = { UpdateGroup.class }, message = "分析id必须是正整数")
    @Schema(description = "分析id: 分析id，必填")
    private Integer analysisId;

    /**
     * 健康建议: 健康建议，必填
     */
    @NotBlank(groups = { UpdateGroup.class }, message = "健康建议不能为空")
    @Schema(description = "健康建议: 健康建议，必填")
    private String healthSuggestion;
}
