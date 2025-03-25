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
 * 数据加密密钥实体对象
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("data_encryption_keys")
public class DataEncryptionKeyDO {

    /**
     * 密钥ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "密钥ID")
    private Integer keyId;

    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    private Integer userId;

    /**
     * 加密密钥
     */
    @Schema(description = "加密密钥")
    private String encryptionKey;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    private Integer createBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Integer updateBy;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}
