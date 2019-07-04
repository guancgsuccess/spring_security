package tech.aistar.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.test.context.junit4.SpringRunner;
import tech.aistar.entity.Permission;
import tech.aistar.entity.Role;
import tech.aistar.mapper.PermissionMapper;

import java.util.*;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {

    @Autowired
    PermissionService permissionService;

    @Test
    public void testgetPermissionMap(){
        Map<String,Collection<ConfigAttribute>> map = permissionService.getPermissionMap();

        Set<String> setkeys = map.keySet();
        Iterator<String> iter = setkeys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            System.out.println("key--->"+key);

            map.get(key).forEach(System.out::println);

            System.out.println("=====分割线=====");
        }
    }
}
