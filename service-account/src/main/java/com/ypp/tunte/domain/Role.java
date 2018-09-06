package com.ypp.tunte.domain;

import com.google.common.collect.Sets;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Entity
@Table(name = "sys_roles")
public class Role  extends BaseEntity{

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public Role(String roleName, String description, boolean available) {
        this.roleName = roleName;
        this.description = description;
        this.available = available;
    }

    private String roleName;
    private String description;
    private boolean available=false;

    private Set<User> users;

    private Set<Permission> permissions;

    @Column(name = "role_name",length = 100,nullable = false,unique = true)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sys_roles_permissions",joinColumns ={
            @JoinColumn(name = "role_id",referencedColumnName = "id")
    },inverseJoinColumns = {@JoinColumn(name = "permission_id",referencedColumnName = "id")})
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission){
        if(null==permissions){
            permissions= Sets.newHashSet();
        }
        permissions.add(permission);
    }

}
