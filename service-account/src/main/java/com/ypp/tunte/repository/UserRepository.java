package com.ypp.tunte.repository;

import com.ypp.tunte.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * 通用用户名查询用户
     * @param userName
     * @return
     */
    List<User> findByUserName(String userName);

}
