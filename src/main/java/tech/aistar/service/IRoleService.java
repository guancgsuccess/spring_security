package tech.aistar.service;

import org.apache.ibatis.annotations.Select;
import tech.aistar.entity.Permission;
import tech.aistar.entity.Role;

import java.util.List;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
public interface IRoleService {
    /**
     * 根据权限来寻找role
     * @param permission
     * @return
     */
    List<Role> findByPermission(Permission permission);
}
