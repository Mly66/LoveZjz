package cn.nbmly.pojo.dto;

import lombok.Data;
import cn.nbmly.pojo.query.QueryGroup;
import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户登录信息
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class UserLoginDTO {

    /**
     * 用户名：必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "用户名不能为空")
    @Schema(description = "用户名：必填")
    private String username;

    /**
     * 密码哈希：必填
     */
    @NotBlank(groups = { QueryGroup.class }, message = "密码哈希不能为空")
    @Schema(description = "密码哈希：必填")
    private String passwordHash;
}
