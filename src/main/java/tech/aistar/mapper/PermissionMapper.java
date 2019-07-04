package tech.aistar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.Permission;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Mapper
public interface PermissionMapper {

    @Select("select * from permission where id=#{id}")
    Permission getById(Integer id);

    @Select("select * from permission")
    List<Permission> findAll();
}
