package tech.aistar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.UserRole;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */

@Mapper
public interface UserRoleMapper {

    @Select("select * from user_role where user_id = #{id}")
    List<UserRole> getByUserId(Integer id);
}
