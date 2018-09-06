package com.ypp.tunte.controller;

import com.ypp.tunte.controller.pojo.ResponseResult;
import com.ypp.tunte.domain.Permission;
import com.ypp.tunte.domain.Role;
import com.ypp.tunte.domain.User;
import com.ypp.tunte.service.RoleService;
import com.ypp.tunte.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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


    @Autowired
    private RoleService roleService;


    @PostMapping("/create")
    public ResponseResult createUser(){



        User user =new User("admin","123456");


        User user1=new User("Tom","123456");


        User user2=new User("Alex","123456");


        userService.createUser(user);
        userService.createUser(user1);
        userService.createUser(user2);

        return  ResponseResult.success();
    }

    @PostMapping("/grant/{id}")
    public ResponseResult grant(@PathVariable("id") Long id,Long... role){

        List<Role> roles=roleService.listByIds(Arrays.asList(role));
        try {
            User user=userService.getUserById(id);
            user.setRoles(new HashSet<>(roles));
            userService.updateUser(user);
        } catch (NotFoundException e) {
            e.printStackTrace();
            ResponseResult.error(e.getMessage());
        }

        return  ResponseResult.success();
    }



}
