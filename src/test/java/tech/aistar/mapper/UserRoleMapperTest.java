package tech.aistar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import tech.aistar.entity.Role;
import tech.aistar.entity.User;
import tech.aistar.entity.UserRole;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testFindByUsername(){
        User u = userMapper.findByUserName("admin");
    }

    @Test
    public void testFindByUserId(){
        User user = userMapper.findByUserName("admin");
        List<UserRole> roles = userRoleMapper.getByUserId(user.getId());
        if(roles!=null){
            roles.forEach(System.out::println);
        }
    }
}
