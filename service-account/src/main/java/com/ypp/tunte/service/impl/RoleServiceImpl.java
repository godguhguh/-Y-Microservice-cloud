package com.ypp.tunte.service.impl;


import com.ypp.tunte.common.annotation.CommonDataGenMethodAnnotation;
import com.ypp.tunte.common.domain.user.Permission;
import com.ypp.tunte.common.domain.user.Role;
import com.ypp.tunte.repository.RoleRepository;
import com.ypp.tunte.service.PermissionService;
import com.ypp.tunte.service.RoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionService   permissionService;

    @Override
    public void createRole(String roleName) {
        Role role=new Role(roleName);
        createRole(role);
    }

    @Override
    @CommonDataGenMethodAnnotation
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getById(Long id) throws NotFoundException {
        Optional<Role> roleOptional= roleRepository.findById(id);
        if(!roleOptional.isPresent()){
            throw new NotFoundException("角色不存在");
        }
        return roleOptional.get();
    }

    @Override
    public List<Role> listAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> listByIds(List<Long> ids) {
        if(CollectionUtils.isEmpty(ids)){return Collections.EMPTY_LIST;}
        return roleRepository.findByIdIn(ids);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        try {
            Role role=getById(roleId);
            List<Permission> permissionList= permissionService.listPermissionByIds(Arrays.asList(permissionIds));
            if(!CollectionUtils.isEmpty(permissionList)) {
                if (!CollectionUtils.isEmpty(role.getPermissions())) {
                    role.getPermissions().addAll(permissionList);
                } else {
                    role.setPermissions(new HashSet<>(permissionList));
                }
                updateRole(role);
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        try {
            Role role=getById(roleId);
            List<Permission> permissionList= permissionService.listPermissionByIds(Arrays.asList(permissionIds));
            if (!CollectionUtils.isEmpty(role.getPermissions()) && !CollectionUtils.isEmpty(permissionList) ){
                role.getPermissions().removeAll(new HashSet<>(permissionList));
                updateRole(role);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

    }
}
