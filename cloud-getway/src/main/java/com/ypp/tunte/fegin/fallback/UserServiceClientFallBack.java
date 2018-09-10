package com.ypp.tunte.fegin.fallback;

import com.alibaba.fastjson.JSON;
import com.ypp.tunte.fegin.UserServiceClient;
import com.ypp.tunte.pojo.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
@Component
public class UserServiceClientFallBack implements UserServiceClient{

    private static final String FEGIN_REQUEST_FAIL_MSG="fegin请求失败";

    @Override
    public String getByUserName(String userName) {
        return JSON.toJSONString(ResponseResult.error(FEGIN_REQUEST_FAIL_MSG));
    }
}
