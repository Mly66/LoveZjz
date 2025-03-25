package cn.nbmly.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新加密密钥的入参对象
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class UpdateEncryptionKeyDTO {

    /**
     * 用户id，必填
     */
    @NotNull(groups = { UpdateGroup.class }, message = "用户id不能为空")
    @Schema(description = "用户id，必填")
    private Integer userId;

    /**
     * 新加密密钥，必填
     */
    @NotBlank(groups = { UpdateGroup.class }, message = "新加密密钥不能为空")
    @Schema(description = "新加密密钥，必填")
    private String newEncryptionKey;
}
