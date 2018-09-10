package com.ypp.tunte.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
