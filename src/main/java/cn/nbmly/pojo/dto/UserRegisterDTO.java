package cn.nbmly.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户注册信息
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class UserRegisterDTO {

    /**
     * 用户名：必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "用户名不能为空")
    @Schema(description = "用户名：必填")
    private String username;

    /**
     * 密码哈希：必填
     */
    @NotBlank(groups = { CreateGroup.class }, message = "密码哈希不能为空")
    @Schema(description = "密码哈希：必填")
    private String passwordHash;

    /**
     * 电子邮件
     */
    @Schema(description = "电子邮件")
    private String email;

    /**
     * 手机号码
     */
    @Schema(description = "手机号码")
    private String phoneNumber;
}
