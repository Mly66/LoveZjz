package cn.nbmly.controller;

import cn.nbmly.constant.ResultCodeConstant;
import cn.nbmly.pojo.dto.CreateGroup;
import cn.nbmly.pojo.dto.RestResult;
import cn.nbmly.pojo.dto.UpdateGroup;
import cn.nbmly.pojo.dto.UserLoginDTO;
import cn.nbmly.pojo.dto.UserRegisterDTO;
import cn.nbmly.pojo.dto.UserUpdateDTO;
import cn.nbmly.pojo.query.QueryGroup;
import cn.nbmly.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.lang.Boolean;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author Mly
 * @date 2025-03-25 11:12:57
 */
@Tag(name = "UserController")
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * register
     *
     * @param userRegisterDTO 用户注册信息
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Operation(summary = "register")
    @ResponseBody
    public RestResult<Boolean> userRegister(@RequestBody @Validated(CreateGroup.class) UserRegisterDTO userRegisterDTO) {
        Boolean result = userService.userRegister(userRegisterDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * login
     *
     * @param userLoginDTO 用户登录信息
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "login")
    @ResponseBody
    public RestResult<String> userLogin(@RequestBody @Validated(QueryGroup.class) UserLoginDTO userLoginDTO) {
        String result = userService.userLogin(userLoginDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }

    /**
     * update
     *
     * @param userUpdateDTO 更新用户信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Operation(summary = "update")
    @ResponseBody
    public RestResult<Boolean> updateUser(@RequestBody @Validated(UpdateGroup.class) UserUpdateDTO userUpdateDTO) {
        Boolean result = userService.updateUser(userUpdateDTO);
        return new RestResult<>(ResultCodeConstant.CODE_000000, ResultCodeConstant.CODE_000000_MSG, result);
    }
}
