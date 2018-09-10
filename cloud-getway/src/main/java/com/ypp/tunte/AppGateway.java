package com.ypp.tunte;

import org.apache.shiro.spring.boot.autoconfigure.ShiroBeanAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AppGateway
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppGateway.class, args);
    }
}
