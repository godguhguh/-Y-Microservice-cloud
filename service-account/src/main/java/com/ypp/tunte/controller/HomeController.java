package com.ypp.tunte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/5 0005
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "hello ,welcome to account service";
    }

}
