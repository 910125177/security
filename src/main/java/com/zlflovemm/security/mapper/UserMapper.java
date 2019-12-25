package com.zlflovemm.security.mapper;


import com.zlflovemm.security.entry.UserEntry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserEntry loadUserByUsername(@Param("username") String username);
}
