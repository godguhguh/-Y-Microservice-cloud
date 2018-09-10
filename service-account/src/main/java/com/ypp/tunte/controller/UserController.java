package com.ypp.tunte.controller;


import com.ypp.tunte.domain.User;
import com.ypp.tunte.pojo.ResponseResult;
import com.ypp.tunte.service.RoleService;
import com.ypp.tunte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        userService. correlationRoles(id,role);

        return  ResponseResult.success();
    }


    @GetMapping("/permission")
    public ResponseResult userRole(){

        ( userService.findPermissions("admin")).stream().forEach(System.out::println);
        return ResponseResult.success();
    }


}
