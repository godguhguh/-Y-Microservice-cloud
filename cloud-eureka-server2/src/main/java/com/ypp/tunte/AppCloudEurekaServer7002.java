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
public class AppCloudEurekaServer7002
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppCloudEurekaServer7002.class, args);
    }
}
