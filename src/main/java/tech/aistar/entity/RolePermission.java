package tech.aistar.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:角色-权限
 * @date 2019/7/2 0002
 */
@Data
public class RolePermission implements Serializable{
    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}
