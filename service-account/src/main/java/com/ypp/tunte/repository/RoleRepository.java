package com.ypp.tunte.repository;

import com.ypp.tunte.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    /**
     * 根据ID查询
     * @param ids
     * @return
     */
    List<Role> findByIdIn(List<Long> ids);

}
