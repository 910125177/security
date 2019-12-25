package com.zlflovemm.security.mapper;

import com.zlflovemm.security.entry.RoleEntry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RolesMapper {

    List<RoleEntry> getRolesByUid(Long uid);
}
