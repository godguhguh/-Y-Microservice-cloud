package com.ypp.tunte.service.impl;

import com.ypp.tunte.annotation.CommonDataGenMethodAnnotation;
import com.ypp.tunte.domain.Permission;
import com.ypp.tunte.domain.Role;
import com.ypp.tunte.repository.PermissionRepository;
import com.ypp.tunte.service.PermissionService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void createPermission(String permissionName) {
        Permission permission=new Permission(permissionName);
        createPermission(permission);
    }

    @Override
    @CommonDataGenMethodAnnotation
    public void createPermission(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public Permission getById(Long id) throws NotFoundException {
        Optional<Permission> permissionOptional= permissionRepository.findById(id);
        if(!permissionOptional.isPresent()){
            throw new NotFoundException("角色不存在");
        }
        return permissionOptional.get();
    }

    @Override
    public List<Permission> listAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public List<Permission> listPermissionByIds(List<Long> permissionIds) {
        if(CollectionUtils.isEmpty(permissionIds)){return Collections.EMPTY_LIST;}
        return permissionRepository.findByIdIn(permissionIds);
    }
}
