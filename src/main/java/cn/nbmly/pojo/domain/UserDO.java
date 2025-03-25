package cn.nbmly.pojo.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 用户实体对象
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_management")
public class UserDO {

    /**
     * 用户ID：用户ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "用户ID：用户ID")
    private Integer userId;

    /**
     * 用户名：用户名
     */
    @Schema(description = "用户名：用户名")
    private String username;

    /**
     * 密码哈希：密码哈希
     */
    @Schema(description = "密码哈希：密码哈希")
    private String passwordHash;

    /**
     * 电子邮件：电子邮件
     */
    @Schema(description = "电子邮件：电子邮件")
    private String email;

    /**
     * 手机号码：手机号码
     */
    @Schema(description = "手机号码：手机号码")
    private String phoneNumber;

    /**
     * 创建人：创建人
     */
    @Schema(description = "创建人：创建人")
    private Integer createBy;

    /**
     * 创建时间：创建时间
     */
    @Schema(description = "创建时间：创建时间")
    private Date createTime;

    /**
     * 修改人：修改人
     */
    @Schema(description = "修改人：修改人")
    private Integer updateBy;

    /**
     * 修改时间：修改时间
     */
    @Schema(description = "修改时间：修改时间")
    private Date updateTime;
}
