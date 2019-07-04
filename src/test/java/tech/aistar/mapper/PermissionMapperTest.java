package tech.aistar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.aistar.entity.Permission;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionMapperTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void testFindById(){
        System.out.println(permissionMapper.getById(1));
    }
}
