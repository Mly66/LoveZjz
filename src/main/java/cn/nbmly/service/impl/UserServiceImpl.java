package cn.nbmly.service.impl;

import cn.nbmly.dao.UserMapper;
import cn.nbmly.pojo.dto.UserLoginDTO;
import cn.nbmly.pojo.dto.UserRegisterDTO;
import cn.nbmly.pojo.dto.UserUpdateDTO;
import cn.nbmly.service.UserService;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import cn.nbmly.exception.BusinessException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.nbmly.pojo.domain.UserDO;
import java.util.Map;
import cn.nbmly.constant.ResultCodeConstant;
import java.util.Date;

/**
 * UserServiceImpl
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean userRegister(UserRegisterDTO userRegisterDTO) {
        QueryWrapper<UserDO> usernameWrapper = Wrappers.query();
        usernameWrapper.eq("username", userRegisterDTO.getUsername());
        UserDO existingUserByUsername = userMapper.selectOne(usernameWrapper);
        if (existingUserByUsername != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> emailWrapper = Wrappers.query();
        emailWrapper.eq("email", userRegisterDTO.getEmail());
        UserDO existingUserByEmail = userMapper.selectOne(emailWrapper);
        if (existingUserByEmail != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> phoneNumberWrapper = Wrappers.query();
        phoneNumberWrapper.eq("phone_number", userRegisterDTO.getPhoneNumber());
        UserDO existingUserByPhoneNumber = userMapper.selectOne(phoneNumberWrapper);
        if (existingUserByPhoneNumber != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = new UserDO();
        userDO.setUsername(userRegisterDTO.getUsername());
        userDO.setPasswordHash(userRegisterDTO.getPasswordHash());
        userDO.setEmail(userRegisterDTO.getEmail());
        userDO.setPhoneNumber(userRegisterDTO.getPhoneNumber());
        userDO.setCreateTime(new Date());
        int result = userMapper.insert(userDO);
        return result > 0;
    }

    @Override
    public String userLogin(UserLoginDTO userLoginDTO) {
        QueryWrapper<UserDO> usernameWrapper = Wrappers.query();
        usernameWrapper.eq("username", userLoginDTO.getUsername());
        UserDO userDO = userMapper.selectOne(usernameWrapper);
        if (userDO == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        if (!userDO.getPasswordHash().equals(userLoginDTO.getPasswordHash())) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        String token = "generated_token";
        return token;
    }

    @Override
    public Boolean updateUser(UserUpdateDTO userUpdateDTO) {
        UserDO existingUser = userMapper.selectById(userUpdateDTO.getUserId());
        if (existingUser == null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> usernameWrapper = Wrappers.query();
        usernameWrapper.eq("username", userUpdateDTO.getUsername()).ne("user_id", userUpdateDTO.getUserId());
        UserDO existingUserByUsername = userMapper.selectOne(usernameWrapper);
        if (existingUserByUsername != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> emailWrapper = Wrappers.query();
        emailWrapper.eq("email", userUpdateDTO.getEmail()).ne("user_id", userUpdateDTO.getUserId());
        UserDO existingUserByEmail = userMapper.selectOne(emailWrapper);
        if (existingUserByEmail != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        QueryWrapper<UserDO> phoneNumberWrapper = Wrappers.query();
        phoneNumberWrapper.eq("phone_number", userUpdateDTO.getPhoneNumber()).ne("user_id", userUpdateDTO.getUserId());
        UserDO existingUserByPhoneNumber = userMapper.selectOne(phoneNumberWrapper);
        if (existingUserByPhoneNumber != null) {
            throw new BusinessException(ResultCodeConstant.CODE_000001, ResultCodeConstant.CODE_000001_MSG);
        }
        UserDO userDO = new UserDO();
        userDO.setUserId(userUpdateDTO.getUserId());
        userDO.setUsername(userUpdateDTO.getUsername());
        userDO.setEmail(userUpdateDTO.getEmail());
        userDO.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        userDO.setUpdateTime(new Date());
        int result = userMapper.updateById(userDO);
        return result > 0;
    }
}
