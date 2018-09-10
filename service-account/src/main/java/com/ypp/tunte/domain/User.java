package com.ypp.tunte.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.util.Set;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/6 0006
 */
@Entity
@Table(name = "sys_users")
public class User extends BaseEntity {

    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.salt = userName;
    }

    private String userName;
    private String password;
    private String salt;

    private Set<Role> roles;

    @Column(name = "user_name",length = 100,unique = true)
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password",length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "salt",length = 50)
    public String getSalt() {
        if(StringUtils.isEmpty(salt)){
            salt=this.userName;
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sys_users_roles",joinColumns ={
            @JoinColumn(name = "user_id",referencedColumnName = "id")
    },inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    @JsonIgnore
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        if(null==roles){
            roles= Sets.newHashSet();
        }
        roles.add(role);

    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roles=" + roles +
                '}';
    }
}
