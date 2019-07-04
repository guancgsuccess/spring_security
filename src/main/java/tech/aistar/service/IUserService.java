package tech.aistar.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.Role;
import tech.aistar.entity.User;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
public interface IUserService {
    User findByUserName(String username);

    void insert(User user);

    /**
     * 根据用户加载出该用户对应的角色信息
     * @param user
     * @return
     */
    List<Role> findByUser(User user);
}
