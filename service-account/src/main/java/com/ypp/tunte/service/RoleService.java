package com.ypp.tunte.service;


import com.ypp.tunte.common.domain.user.Role;
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

    /**
     *
     * @param ids
     * @return
     */
    List<Role> listByIds(List<Long> ids);


    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
