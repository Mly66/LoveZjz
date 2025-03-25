package cn.nbmly.pojo.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 更新用户信息
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
public class UserUpdateDTO {

    /**
     * 用户ID：必填
     */
    @NotNull(groups = { UpdateGroup.class }, message = "用户ID不能为空")
    @Schema(description = "用户ID：必填")
    private Integer userId;

    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;

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
