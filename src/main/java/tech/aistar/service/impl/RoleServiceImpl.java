package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.aistar.entity.Permission;
import tech.aistar.entity.Role;
import tech.aistar.entity.RolePermission;
import tech.aistar.mapper.RoleMapper;
import tech.aistar.mapper.RolePermissionMapper;
import tech.aistar.service.IRoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByPermission(Permission permission) {
        List<Role> roles = new ArrayList<>();
        List<RolePermission> rolePermissions = rolePermissionMapper.findByPermission(permission.getId());

        if(rolePermissions!=null){

            for (RolePermission rolePermission : rolePermissions) {
                roles.add(roleMapper.getById(rolePermission.getRoleId()));
            }
        }
        return roles;
    }
}
