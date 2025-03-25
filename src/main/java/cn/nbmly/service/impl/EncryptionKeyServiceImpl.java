package cn.nbmly.service.impl;

import cn.nbmly.dao.DataEncryptionKeyMapper;
import cn.nbmly.pojo.dto.DeleteEncryptionKeyDTO;
import cn.nbmly.pojo.dto.GenerateEncryptionKeyDTO;
import cn.nbmly.pojo.dto.UpdateEncryptionKeyDTO;
import cn.nbmly.service.EncryptionKeyService;
import java.lang.Boolean;
import java.lang.Override;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.nbmly.exception.BusinessException;
import java.util.Random;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Map;
import cn.nbmly.pojo.domain.DataEncryptionKeyDO;
import cn.nbmly.constant.ResultCodeConstant;
import org.apache.commons.lang3.RandomStringUtils;
import lombok.Data;
import java.util.Date;

/**
 * 数据安全保护控制器的实现
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Service
public class EncryptionKeyServiceImpl implements EncryptionKeyService {

    @Autowired
    private DataEncryptionKeyMapper dataEncryptionKeyMapper;

    @Override
    public Boolean generateEncryptionKey(GenerateEncryptionKeyDTO generateEncryptionKeyDTO) {
        QueryWrapper<DataEncryptionKeyDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", generateEncryptionKeyDTO.getUserId());
        DataEncryptionKeyDO existingKey = dataEncryptionKeyMapper.selectOne(queryWrapper);
        if (existingKey != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        DataEncryptionKeyDO newKey = new DataEncryptionKeyDO();
        newKey.setUserId(generateEncryptionKeyDTO.getUserId());
        newKey.setEncryptionKey(RandomStringUtils.randomAlphanumeric(255));
        newKey.setCreateBy(1);
        newKey.setCreateTime(new Date());
        dataEncryptionKeyMapper.insert(newKey);
        return true;
    }

    @Override
    public Boolean updateEncryptionKey(UpdateEncryptionKeyDTO updateEncryptionKeyDTO) {
        QueryWrapper<DataEncryptionKeyDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", updateEncryptionKeyDTO.getUserId());
        DataEncryptionKeyDO existingKey = dataEncryptionKeyMapper.selectOne(queryWrapper);
        if (existingKey == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        existingKey.setEncryptionKey(updateEncryptionKeyDTO.getNewEncryptionKey());
        existingKey.setUpdateBy(1);
        existingKey.setUpdateTime(new Date());
        dataEncryptionKeyMapper.updateById(existingKey);
        return true;
    }

    @Override
    public Boolean deleteEncryptionKey(DeleteEncryptionKeyDTO deleteEncryptionKeyDTO) {
        QueryWrapper<DataEncryptionKeyDO> queryWrapper = Wrappers.query();
        queryWrapper.eq("user_id", deleteEncryptionKeyDTO.getUserId());
        DataEncryptionKeyDO existingKey = dataEncryptionKeyMapper.selectOne(queryWrapper);
        if (existingKey == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        dataEncryptionKeyMapper.deleteById(existingKey.getKeyId());
        return true;
    }
}
