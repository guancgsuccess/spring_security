package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.aistar.entity.Role;
import tech.aistar.entity.User;
import tech.aistar.entity.UserRole;
import tech.aistar.mapper.RoleMapper;
import tech.aistar.mapper.UserMapper;
import tech.aistar.mapper.UserRoleMapper;
import tech.aistar.service.IUserService;

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
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<Role> findByUser(User user) {
        List<UserRole> userRoles = userRoleMapper.getByUserId(user.getId());
        List<Role> roles = new ArrayList<>();
        if(null!=userRoles && userRoles.size()>0){
            for(UserRole ur:userRoles){
                roles.add(roleMapper.getById(ur.getRoleId()));
            }
        }
        return roles;
    }
}
