package com.ypp.tunte.service;

import com.ypp.tunte.domain.Permission;
import javassist.NotFoundException;

import java.util.List;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
public interface PermissionService {

    /**
     * 创建权限
     * @param permissionName
     */
    void createPermission(String permissionName);

    /**
     * 创建权限
     * @param permission
     */
    void createPermission(Permission permission);

    /**
     * 删除权限
     * @param id
     */
    void deletePermission(Long id);

    /**
     * 更新权限
     * @param permission
     */
    void updatePermission(Permission permission);

    /**
     * 获取权限
     * @param id
     * @return
     */
    Permission getById(Long id) throws NotFoundException;

    /**
     * 获取所有权限
     * @return
     */
    List<Permission> listAllPermission();

    /**
     *
     * @param permissionIds
     * @return
     */
    List<Permission> listPermissionByIds(List<Long> permissionIds);

}
