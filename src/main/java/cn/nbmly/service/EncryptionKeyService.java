package cn.nbmly.service;

import cn.nbmly.pojo.dto.DeleteEncryptionKeyDTO;
import cn.nbmly.pojo.dto.GenerateEncryptionKeyDTO;
import cn.nbmly.pojo.dto.UpdateEncryptionKeyDTO;
import java.lang.Boolean;

/**
 * 数据安全保护控制器
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
public interface EncryptionKeyService {

    /**
     * 生成加密密钥
     *
     * @param generateEncryptionKeyDTO 生成加密密钥的入参对象
     * @return
     */
    Boolean generateEncryptionKey(GenerateEncryptionKeyDTO generateEncryptionKeyDTO);

    /**
     * 更新加密密钥
     *
     * @param updateEncryptionKeyDTO 更新加密密钥的入参对象
     * @return
     */
    Boolean updateEncryptionKey(UpdateEncryptionKeyDTO updateEncryptionKeyDTO);

    /**
     * 删除加密密钥
     *
     * @param deleteEncryptionKeyDTO 删除加密密钥的入参对象
     * @return
     */
    Boolean deleteEncryptionKey(DeleteEncryptionKeyDTO deleteEncryptionKeyDTO);
}
