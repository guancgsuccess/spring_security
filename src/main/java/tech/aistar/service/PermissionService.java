package tech.aistar.service;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/2 0002
 */
public interface PermissionService {
    Map<String, Collection<ConfigAttribute>> getPermissionMap();
}
