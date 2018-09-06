package com.ypp.tunte.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Entity
@Table(name = "sys_permissions")
public class Permission extends BaseEntity {

    public Permission(){}

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    public Permission(String permissionName, String description) {
        this.permissionName = permissionName;
        this.description = description;
    }

    public Permission(String permissionName, String description, boolean available) {
        this.permissionName = permissionName;
        this.description = description;
        this.available = available;
    }

    public Permission(String permissionName, boolean available) {
        this.permissionName = permissionName;
        this.available = available;
    }

    private String permissionName;

    private String description;

    private boolean available=false;


    private Set<Role> roles;

    @Column(name = "permission_name",length = 100, nullable = false,unique = true)
    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @ManyToMany(mappedBy = "permissions")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
