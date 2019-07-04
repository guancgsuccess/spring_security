package tech.aistar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import tech.aistar.entity.Result;
import tech.aistar.entity.StatusCode;
import tech.aistar.util.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FuryAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper; // Json转化工具

    @Autowired
    private JwtUtil JwtUti;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功..");

        System.out.println(authentication+"=====");
        Map<String,Object> map = new HashMap<>();
        map.put("username",authentication.getName());

        String token = JwtUti.createJWT(null,authentication.getName(),null);
        map.put("token",token);

        response.setContentType("application/json;charset=UTF-8"); // 响应类型
        response.getWriter().write(objectMapper.writeValueAsString(new Result(true, StatusCode.OK,"登录成功",map)));
    }
}