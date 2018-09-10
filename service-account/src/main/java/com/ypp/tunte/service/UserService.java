package com.ypp.tunte.service;

import com.google.common.collect.Lists;
import com.ypp.tunte.domain.User;
import javassist.NotFoundException;

import java.util.List;
import java.util.Set;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
public interface UserService {

    /**
     * 创建新用户
     * @param user
     */
    void createUser(User user);

    /**
     * 修改用户密码
     * @param userId
     * @param newPassword
     */
    void changePassword(Long userId, String newPassword);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    void correlationRoles(Long userId, Long... roleIds);

    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    void uncorrelationRoles(Long userId, Long... roleIds);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    void updateUser(User user);

    /**
     * 获取用户
     * @param id
     * @return
     */
    User getUserById(Long id) throws NotFoundException;

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    User getUserByUserName(String userName) throws NotFoundException;

    /**
     * 所有用户
     * @return
     */
    List<User> listAllUser();
}
