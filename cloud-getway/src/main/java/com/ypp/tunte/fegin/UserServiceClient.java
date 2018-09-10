package com.ypp.tunte.fegin;

import com.ypp.tunte.common.constant.CommonConstant;
import com.ypp.tunte.common.domain.user.User;
import com.ypp.tunte.common.pojo.ResponseResult;
import com.ypp.tunte.fegin.fallback.UserServiceClientFallBack;
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
    ResponseResult<User> getByUserName(@RequestParam("userName") String userName);

}
