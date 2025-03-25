package cn.nbmly.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 生成加密密钥的入参对象
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class GenerateEncryptionKeyDTO {

    /**
     * 用户id，必填
     */
    @NotNull(groups = { CreateGroup.class }, message = "用户id不能为空")
    @Schema(description = "用户id，必填")
    private Integer userId;
}
