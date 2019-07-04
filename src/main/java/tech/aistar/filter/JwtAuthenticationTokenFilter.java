package tech.aistar.filter;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tech.aistar.util.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:OncePerRequestFilter
 * 确保在一次请求只通过一次filter，而不需要重复执行
 * @date 2019/7/3 0003
 */
@Component
public class JwtAuthenticationTokenFilter  extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("doFilterInternal...------------->");
        //获取Token
        String token = request.getHeader("Authorization");
        System.out.println(token);

        if(token!=null) {
            token = token.substring(7);
            Claims claim = jwtUtil.parseJWT(token);
            System.out.println("claim:"+claim);
            if (null != claim) {
                request.setAttribute("claim",claim);
                System.out.println("true============");
                //return true;
            }
        }
        filterChain.doFilter(request, response);
    }
}
