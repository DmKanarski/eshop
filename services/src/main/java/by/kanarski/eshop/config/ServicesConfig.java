package by.kanarski.eshop.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("by.kanarski.eshop")
@ImportAutoConfiguration(JpaConfig.class)
public class ServicesConfig {



}
