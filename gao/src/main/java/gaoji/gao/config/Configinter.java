package gaoji.gao.config;


import gaoji.gao.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc//配置拦截器必须写
public class Configinter implements WebMvcConfigurer {
    @Override//添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/session.do");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/session.do").excludePathPatterns();//设置拦截例外
    }

    public static void main(String[] args) {
        System.out.println("更新1");
        System.out.println("更新2");
    }

}
