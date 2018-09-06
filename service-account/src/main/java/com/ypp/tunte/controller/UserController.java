package com.ypp.tunte.controller;

import com.ypp.tunte.controller.pojo.ResponseResult;
import com.ypp.tunte.domain.Permission;
import com.ypp.tunte.domain.Role;
import com.ypp.tunte.domain.User;
import com.ypp.tunte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @PostMapping("/create")
    public ResponseResult createUser(){

        Permission permission=new Permission("创建用户");
        Permission permission2=new Permission("删除用户");
        Permission permission3=new Permission("更新用户");
        Permission permission4=new Permission("查询用户");

        Role role=new Role("admin","管理员");
        role.addPermission(permission);
        role.addPermission(permission2);
        role.addPermission(permission3);
        role.addPermission(permission4);


        Role role2=new Role("platinum","用户用户");
       role2.addPermission(permission2);
       role2.addPermission(permission3);
       role2.addPermission(permission4);

        Role role3=new Role("averageUser","普通用户");
        role3.addPermission(permission3);
        role3.addPermission(permission4);

        User user =new User("admin","123456");
        user.addRole(role);

        User user1=new User("Tom","123456");
        user1.addRole(role2);

        User user2=new User("Alex","123456");
        user2.addRole(role3);

        userService.createUser(user);
        userService.createUser(user1);
        userService.createUser(user2);

        return  ResponseResult.success();
    }




}
