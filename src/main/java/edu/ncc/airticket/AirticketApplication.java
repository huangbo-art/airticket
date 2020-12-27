package edu.ncc.airticket;

import edu.ncc.airticket.sys.AuthInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("edu.ncc.airticket.dao")
public class AirticketApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AirticketApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/manager/login");///customer/login//除了登录请求不拦截
    }
}
