package tech.aistar.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.aistar.entity.Role;
import tech.aistar.entity.User;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testFindRoleByUser(){
        User user = userService.findByUserName("tom");
        List<Role> roles = userService.findByUser(user);
        
        if(roles!=null){
            for (Role role : roles) {
                System.out.println(role);
            }
        }
    }
}
