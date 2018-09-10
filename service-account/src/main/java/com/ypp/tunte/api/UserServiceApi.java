package com.ypp.tunte.api;

import com.ypp.tunte.domain.User;
import com.ypp.tunte.pojo.ResponseResult;
import com.ypp.tunte.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
@RestController
@RequestMapping("/api/user/")
public class UserServiceApi {

    @Autowired
    private UserService userService;

    @GetMapping("/getByUserName")
    public ResponseResult getUserByUserName(@RequestParam String userName){
        try {
          User user=  userService.getUserByUserName(userName);
          return ResponseResult.success(user);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return ResponseResult.error(e.getMessage());
        }
    }

}
