package com.ypp.tunte.security.realm;

import com.ypp.tunte.fegin.UserServiceClient;
import com.ypp.tunte.utils.JWTUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/7 0007
 */
@Component
public class MyRealm  extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
