package tech.aistar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.Role;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Mapper
public interface RoleMapper {

    @Select("select * from role where id = #{id}")
    Role getById(Integer id);
}
