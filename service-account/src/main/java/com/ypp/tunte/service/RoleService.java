package com.ypp.tunte.service;

import com.ypp.tunte.domain.Role;
import javassist.NotFoundException;

import java.util.List;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
public interface RoleService {

    /**
     * 创建角色
     * @param roleName
     */
    void createRole(String roleName);

    /**
     * 创建角色
     * @param role
     */
    void createRole(Role role);

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(Long id);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 获取角色
     * @param id
     * @return
     * @throws NotFoundException
     */
    Role getById(Long id) throws NotFoundException;

    /**
     * 所有角色
     * @return
     */
    List<Role> listAllRole();


}
