package com.ypp.tunte;

import com.ypp.tunte.fegin.UserServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceFeginTest {

    @Autowired
    private UserServiceClient userServiceClient;

    @Test
    public void findByUserNameTest(){

       String str= userServiceClient.getByUserName("admin");
        System.out.println(str);

    }

}
