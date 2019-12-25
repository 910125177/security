package com.zlflovemm.security.entry;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserEntry
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/12/24 18:43
 * @Version 1.0
 */
@Setter
@Getter
public class UserEntry implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private boolean enabled;
    private List<RoleEntry> roles;
    private String email;
    private String userface;
    private Timestamp regTime;

    /**
     * 获取角色权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntry role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }

    /**
     * 获取密码
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 获取用户名
     * @return
     */
    @Override
    public String getUsername() {
        return username;
    }


    /**
     * 用户账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
