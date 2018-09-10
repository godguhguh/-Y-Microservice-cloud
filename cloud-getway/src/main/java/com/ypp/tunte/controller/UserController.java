package com.ypp.tunte.controller;

import com.ypp.tunte.fegin.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserServiceClient userServiceClient;

    @GetMapping("/{userName}")
    public  String findByUserName(@PathVariable("userName") String userName){
        return userServiceClient.getByUserName(userName);

    }

}
