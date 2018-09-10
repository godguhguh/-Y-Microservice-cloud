package com.ypp.tunte.fegin;

import com.ypp.tunte.constant.CommonConstant;
import com.ypp.tunte.fegin.fallback.UserServiceClientFallBack;
import com.ypp.tunte.pojo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
@FeignClient(name = CommonConstant.SERVICE_NAME_ACCOUNT,fallback = UserServiceClientFallBack.class)
public interface UserServiceClient {


    @GetMapping("/api/user/getByUserName")
    String getByUserName(@RequestParam("userName") String userName);

}
