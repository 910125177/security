package com.zlflovemm.security.service.impl;

import com.zlflovemm.security.entry.RoleEntry;
import com.zlflovemm.security.entry.UserEntry;
import com.zlflovemm.security.mapper.RolesMapper;
import com.zlflovemm.security.mapper.UserMapper;
import com.zlflovemm.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/12/24 19:05
 * @Version 1.0
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Autowired
    RolesMapper rolesMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntry user = userMapper.loadUserByUsername(s);
        if (user == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new UserEntry();
        }
        //查询用户的角色信息，并返回存入user中
        List<RoleEntry> roles = rolesMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }
}
