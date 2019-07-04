package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tech.aistar.entity.Role;
import tech.aistar.entity.User;
import tech.aistar.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Component
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("detail:"+username);
        User user = userService.findByUserName(username);

        if(user == null){
            throw new UsernameNotFoundException("user is not exists!");
        }

        //定义权限列表
        List<GrantedAuthority> authorityList = new ArrayList<>();
        //用户可以访问的资源[或者说用户具有的权限]必须以"ROLE_"开头
        //authorityList.add(new SimpleGrantedAuthority("ROLE_user"));

        //动态从数据中加载权限...
        List<Role> roles = userService.findByUser(user);
        if(null!=roles && roles.size()>0){
            for (Role role : roles) {
                authorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }
        }

        org.springframework.security.core.userdetails.User ud = new org.springframework.security.core.userdetails.User(username,user.getPassword(),authorityList);
        return ud;
    }
}
