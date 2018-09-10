package com.ypp.tunte.controller;



import com.ypp.tunte.common.domain.user.Permission;
import com.ypp.tunte.common.pojo.ResponseResult;
import com.ypp.tunte.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/create")
    public ResponseResult create(){
        Permission permission=new Permission("创建用户");
        Permission permission2=new Permission("删除用户");
        Permission permission3=new Permission("更新用户");
        Permission permission4=new Permission("查询用户");
        permissionService.createPermission(permission);
        permissionService.createPermission(permission2);
        permissionService.createPermission(permission3);
        permissionService.createPermission(permission4);
        return ResponseResult.success();
    }

}
