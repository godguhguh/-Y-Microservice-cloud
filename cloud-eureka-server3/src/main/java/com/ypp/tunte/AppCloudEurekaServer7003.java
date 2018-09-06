package com.ypp.tunte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class AppCloudEurekaServer7003
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppCloudEurekaServer7003.class, args);
    }
}
