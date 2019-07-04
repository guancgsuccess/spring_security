package tech.aistar.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.User;

/**
 * @author success https://www.jianshu.com/p/650a497b3a40
 * @version 1.0
 * @description:本类用来演示:https://github.com/lenve/vhr.git
 *
 * https://blog.csdn.net/XlxfyzsFdblj/article/details/82083443
 * @date 2019/7/2 0002
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    @Insert("insert into user(username,password) values(#{username},#{password})")
    void insert(User user);
}
