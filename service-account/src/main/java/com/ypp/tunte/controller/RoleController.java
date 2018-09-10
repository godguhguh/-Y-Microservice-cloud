package com.ypp.tunte.controller;


import com.ypp.tunte.domain.Permission;
import com.ypp.tunte.domain.Role;
import com.ypp.tunte.pojo.ResponseResult;
import com.ypp.tunte.service.PermissionService;
import com.ypp.tunte.service.RoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/create")
    public ResponseResult create(){
        Role role=new Role("admin","管理员");
        Role role2=new Role("platinum","白金用户");
        Role role3=new Role("average","普通用户");
        roleService.createRole(role);
        roleService.createRole(role2);
        roleService.createRole(role3);
       return ResponseResult.success();
    }

    @PostMapping("/grant/{id}")
    public ResponseResult grantPermission(@PathVariable("id") Long id,Long... permission){

        List<Permission> permissionList= permissionService.listPermissionByIds(Arrays.asList(permission));
        try {
            Role role=roleService.getById(id);
            role.setPermissions(new HashSet<>(permissionList));
            roleService.updateRole(role);
        } catch (NotFoundException e) {
            ResponseResult.error(e.getMessage());
        }



        return ResponseResult.success();
    }

}
