package cn.nbmly.service;

import cn.nbmly.pojo.dto.UserLoginDTO;
import cn.nbmly.pojo.dto.UserRegisterDTO;
import cn.nbmly.pojo.dto.UserUpdateDTO;
import java.lang.Boolean;
import java.lang.String;

/**
 * UserService
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
public interface UserService {

    /**
     * register
     *
     * @param userRegisterDTO 用户注册信息
     * @return
     */
    Boolean userRegister(UserRegisterDTO userRegisterDTO);

    /**
     * login
     *
     * @param userLoginDTO 用户登录信息
     * @return
     */
    String userLogin(UserLoginDTO userLoginDTO);

    /**
     * update
     *
     * @param userUpdateDTO 更新用户信息
     * @return
     */
    Boolean updateUser(UserUpdateDTO userUpdateDTO);
}
