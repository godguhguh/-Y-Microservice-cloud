package com.ypp.tunte.repository;


import com.ypp.tunte.common.domain.user.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    /**
     * 通过ID查询
     * @param ids
     * @return
     */
    List<Permission> findByIdIn(List<Long> ids);

}
