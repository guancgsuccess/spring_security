package tech.aistar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.RolePermission;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Mapper
public interface RolePermissionMapper {

    /**
     * 根据角色id来查找
     */
    @Select("select * from role_permission where role_id=#{value}")
    List<RolePermission> findByRole(Integer role_id);

    /**
     * 根据权限id来获取权限
     * @param permission_id
     * @return
     */
    @Select("select * from role_permission where permission_id=#{value}")
    List<RolePermission> findByPermission(Integer permission_id);
}
