package by.kanarski.eshop.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan("by.kanarski.eshop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySources(value = {@PropertySource("classpath:application.properties")})
@ImportAutoConfiguration({
        ServicesConfig.class, ThymeleafWebConfig.class, SecurityConfig.class
})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(
                Application.class
        );
        applicationBuilder.run(args);
    }

}