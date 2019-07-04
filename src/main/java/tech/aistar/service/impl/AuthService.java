package tech.aistar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import tech.aistar.service.PermissionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/3 0003
 */
@Service
public class AuthService {
    @Autowired
    private PermissionService permissionService;

    public boolean canAccess(HttpServletRequest request, Authentication authentication) {
        System.out.println("auservice....");

        boolean b = false;//如果b为true,则代表被授权允许访问
        System.out.println("authentication:"+authentication);

        /*
		 * 1/未登录的情况下，需要做一个判断或者是拦截。 anonymousUser | userDetails.user
		 *
		 */
        Object pricipal = authentication.getPrincipal();
        System.out.println("pricipal:"+pricipal);
        if(pricipal == null || "anonymousUser".equals(pricipal)) {
            return b;
        }
        /*
		 * 3/ 通过的request对象url）获取到权限信息。
		 */
        Map<String,Collection<ConfigAttribute>> map = permissionService.getPermissionMap();
        Collection<ConfigAttribute> list = null;

        Set<String> keySets = map.keySet();
        Iterator<String> iter = keySets.iterator();
        while(iter.hasNext()){
            String url = iter.next();
            AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
            System.out.println("matcher:"+matcher+"=============");
            if(matcher.matches(request)){
                list = map.get(url);
                System.out.println("list:"+list);
                break;
            }
        }
        if(list == null || list.size() ==0) {
            System.out.println("没有匹配到任何的url...");
            return b;
        }
        System.out.println("当前登录的用户角色的信息:"+authentication.getAuthorities());

        /*
		 *  将获取到的权限信息和当前的登录账号的权限信息进行比对。
		 */
        for(ConfigAttribute c:list){
            String role = c.getAttribute();
            System.out.println("role:"+role+"===============>>>>>>>>>>>");
           for(GrantedAuthority grantedAuthority:authentication.getAuthorities()){
               String srole = grantedAuthority.getAuthority();
               if(role.equals(srole)){
                   System.out.println("被授权");
                   b = true;
                   break;
               }
           }
        }
        return b;
    }
}
