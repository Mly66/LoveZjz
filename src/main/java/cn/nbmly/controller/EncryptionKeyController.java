package cn.nbmly.controller;

import cn.nbmly.constant.ResultCodeConstant;
import cn.nbmly.pojo.dto.CreateGroup;
import cn.nbmly.pojo.dto.DeleteEncryptionKeyDTO;
import cn.nbmly.pojo.dto.DeleteGroup;
import cn.nbmly.pojo.dto.GenerateEncryptionKeyDTO;
import cn.nbmly.pojo.dto.RestResult;
import cn.nbmly.pojo.dto.UpdateEncryptionKeyDTO;
import cn.nbmly.pojo.dto.UpdateGroup;
import cn.nbmly.service.EncryptionKeyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据安全保护控制器
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Tag(name = "数据安全保护控制器")
@RequestMapping("encryption-key")
@RestController
public class EncryptionKeyController {

    @Autowired
    private EncryptionKeyService encryptionKeyService;

    /**
     * 生成加密密钥
     *
     * @param generateEncryptionKeyDTO 生成加密密钥的入参对象
     * @return
     */
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @Operation(summary = "生成加密密钥")
    @ResponseBody
    public RestResult<Boolean> generateEncryptionKey(@RequestBody @Validated(CreateGroup.class) GenerateEncryptionKeyDTO generateEncryptionKeyDTO) {
        Boolean result = encryptionKeyService.generateEncryptionKey(generateEncryptionKeyDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 更新加密密钥
     *
     * @param updateEncryptionKeyDTO 更新加密密钥的入参对象
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "更新加密密钥")
    @ResponseBody
    public RestResult<Boolean> updateEncryptionKey(@RequestBody @Validated(UpdateGroup.class) UpdateEncryptionKeyDTO updateEncryptionKeyDTO) {
        Boolean result = encryptionKeyService.updateEncryptionKey(updateEncryptionKeyDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * 删除加密密钥
     *
     * @param deleteEncryptionKeyDTO 删除加密密钥的入参对象
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Operation(summary = "删除加密密钥")
    @ResponseBody
    public RestResult<Boolean> deleteEncryptionKey(@RequestBody @Validated(DeleteGroup.class) DeleteEncryptionKeyDTO deleteEncryptionKeyDTO) {
        Boolean result = encryptionKeyService.deleteEncryptionKey(deleteEncryptionKeyDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
