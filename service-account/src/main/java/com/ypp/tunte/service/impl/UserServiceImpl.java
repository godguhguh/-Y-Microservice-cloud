package com.ypp.tunte.service.impl;

import com.ypp.tunte.annotation.CommonDataGenMethodAnnotation;
import com.ypp.tunte.domain.User;
import com.ypp.tunte.repository.UserRepository;
import com.ypp.tunte.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @CommonDataGenMethodAnnotation
    public void createUser(User user) {
        userRepository.save(user);
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
