package com.ypp.tunte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/4 0004
 */
@SpringBootApplication
@EnableEurekaServer
public class AppCloudEurekaServer7001 {

    public static void main(String[] args) {
        SpringApplication.run(AppCloudEurekaServer7001.class, args);
    }

}
