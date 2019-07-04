package tech.aistar.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
@Data
public class User implements Serializable{
    private Integer id;

    private String username;

    private String password;
}
