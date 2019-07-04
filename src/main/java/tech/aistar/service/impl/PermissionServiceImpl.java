package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.aistar.entity.Permission;
import tech.aistar.entity.Role;
import tech.aistar.mapper.PermissionMapper;
import tech.aistar.service.IRoleService;
import tech.aistar.service.PermissionService;

import java.util.*;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private IRoleService roleService;

    @Override
    public Map<String, Collection<ConfigAttribute>> getPermissionMap() {
        //key = url, value = 权限集合.
        Map<String,Collection<ConfigAttribute>> permissionMap = new HashMap<>();

        //获取所有的权限信息
        List<Permission> permissions = permissionMapper.findAll();

        if(null!=permissions && permissions.size()>0){
            for (Permission permission : permissions) {
                //存放该权限对应的角色ROLE_角色名称
                Collection<ConfigAttribute> collection = new ArrayList<ConfigAttribute>();
                //获取对应的role
                List<Role> roles = roleService.findByPermission(permission);

                if(null!=roles && roles.size()>0){
                    for (Role r : roles) {
                        ConfigAttribute configAttribute = new SecurityConfig("ROLE_"+r.getRoleName());
                        collection.add(configAttribute);
                    }
                }
                permissionMap.put(permission.getUrl(),collection);
            }
        }

        return permissionMap;
    }
}
