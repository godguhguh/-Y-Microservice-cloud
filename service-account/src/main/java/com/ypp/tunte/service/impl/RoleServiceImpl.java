package com.ypp.tunte.service.impl;

import com.ypp.tunte.annotation.CommonDataGenMethodAnnotation;
import com.ypp.tunte.domain.Role;
import com.ypp.tunte.repository.RoleRepository;
import com.ypp.tunte.service.RoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
