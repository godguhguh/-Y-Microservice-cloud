package com.ypp.tunte.service.impl;

import com.google.common.collect.Sets;

import com.ypp.tunte.common.annotation.CommonDataGenMethodAnnotation;
import com.ypp.tunte.common.domain.user.Permission;
import com.ypp.tunte.common.domain.user.Role;
import com.ypp.tunte.common.domain.user.User;
import com.ypp.tunte.repository.UserRepository;
import com.ypp.tunte.service.RoleService;
import com.ypp.tunte.service.UserService;
import com.ypp.tunte.utils.PasswordHelper;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

import java.util.stream.Collectors;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    private PasswordHelper passwordHelper = new PasswordHelper();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    @CommonDataGenMethodAnnotation
    public void createUser(User user) {
        passwordHelper.encryptPassword(user);
        userRepository.save(user);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        try {
            User user=getUserById(userId);
            user.setPassword(newPassword);
            passwordHelper.encryptPassword(user);
            userRepository.save(user);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {
        try {
            User user=getUserById(userId);
            List<Role> roles=  roleService.listByIds(Arrays.asList(roleIds));
            if(!CollectionUtils.isEmpty(roles)){
                if(CollectionUtils.isEmpty(user.getRoles())) {
                    user.setRoles(new HashSet<>(roles));
                }else {
                    user.getRoles().addAll(roles) ;
                }
            }

            this.updateUser(user);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        try {
            User user=getUserById(userId);
            Set<Role> roles= user.getRoles();
            List<Role> removeRoles=  roleService.listByIds(Arrays.asList(roleIds));
            roles.removeAll(removeRoles);
            user.setRoles(roles);
            this.updateUser(user);
            logger.debug("用户的角色有"+roles.size());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> findRoles(String username) {
        try {
            User user=this.getUserByUserName(username);
            if(!CollectionUtils.isEmpty(user.getRoles())){
                return user.getRoles().stream().map(r->r.getRoleName()).collect(Collectors.toSet());
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_SET;
    }

    @Override
    public Set<String> findPermissions(String username) {
        Set<String> result= Sets.newHashSet();
        try {
            User user=this.getUserByUserName(username);
            if(!CollectionUtils.isEmpty(user.getRoles())){
                user.getRoles().forEach(r->{
                    if(!CollectionUtils.isEmpty(r.getPermissions())){
                        result.addAll(r.getPermissions().stream().map(Permission::getPermissionName).collect(Collectors.toSet()));
                    }
                });
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        user.setLastModifyTime(new Date());
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws NotFoundException {
        Optional<User> userOptional= userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new NotFoundException("用户不存在");
        }
        return userOptional.get();
    }

    @Override
    public User getUserByUserName(String userName) throws NotFoundException {
        List<User> users= userRepository.findByUserName(userName);
        if(CollectionUtils.isEmpty(users)){
            throw new NotFoundException("'"+userName+"'用户不存在");
        }
        return users.get(0);
    }

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }
}
