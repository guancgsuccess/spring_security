package tech.aistar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tech.aistar.filter.JwtAuthenticationTokenFilter;

/**
 * @author success
 * @version 1.0
 * @description:本类用来演示:
 * @date 2019/7/1 0001
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//会拦截注解了@PreAuthrize注解的角色配置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FuryAuthenticationSuccessHandler furyAuthenticationSuccessHandler;

    @Autowired
    private FuryAuthenticationFailureHandler furyAuthenticationFailureHandler;

    @Autowired
    private RestAuthAccessDeniedHandler restAuthAccessDeniedHandler;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //基于内存的方式,构建俩个用户账号
//        //auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(passwordEncoder.encode("admin")).roles("admin");
//        //auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user").password(passwordEncoder.encode("user")).roles("user");
//    }


    /**
     * https://www.cnblogs.com/zhoukebo/p/9674361.html
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("security...");
        http.authorizeRequests().antMatchers("/hello").permitAll()
                .anyRequest().access("@authService.canAccess(request,authentication)").and()
                .formLogin().loginProcessingUrl("/user/login")
                .successHandler(furyAuthenticationSuccessHandler)//登录成功...
                .failureHandler(furyAuthenticationFailureHandler)//登录失败
                //配置没有权限
                .and().exceptionHandling().accessDeniedHandler(restAuthAccessDeniedHandler)
                .and().exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
                .and().csrf().disable();
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class); // JWT Filter

    }
}
