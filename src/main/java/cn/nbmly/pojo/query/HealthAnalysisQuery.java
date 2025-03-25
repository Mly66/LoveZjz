package cn.nbmly.pojo.query;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 健康分析查询
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class HealthAnalysisQuery {

    /**
     * 用户id: 用户id，必填
     */
    @NotNull(groups = { QueryGroup.class }, message = "用户id不能为空")
    @Schema(description = "用户id: 用户id，必填")
    private Integer userId;
}
