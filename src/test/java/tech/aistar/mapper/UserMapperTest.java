package tech.aistar.mapper;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import tech.aistar.entity.User;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testFindByUsername(){
        User u = userMapper.findByUserName("admin");
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword(bCryptPasswordEncoder.encode("admin"));
        userMapper.insert(user);

        User user1 = new User();
        user1.setUsername("tom");
        user1.setPassword(bCryptPasswordEncoder.encode("tom"));
        userMapper.insert(user1);
    }
}
