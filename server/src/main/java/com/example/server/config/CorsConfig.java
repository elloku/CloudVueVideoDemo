package com.example.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/5/28 22:37
 * @description：解决跨域问题
 * 这部分注释掉是因为采用了GateWay中的解决方案。
 * 就不需要使用这个配置来解决跨域问题了。
 * 而且如果和GateWay中的一起使用好像还会冲突
 */
/*@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true)
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）
    }
}*/
