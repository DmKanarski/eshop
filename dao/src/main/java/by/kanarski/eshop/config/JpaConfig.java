package by.kanarski.eshop.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

import javax.sql.DataSource;

import lombok.Data;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableCaching
@PropertySource("classpath:jpa.properties")
@ComponentScan("by.kanarski.eshop")
//@EntityScan("by.kanarski.eshop.entities.*")
@EnableJpaRepositories(basePackages = "by.kanarski.eshop.dao")
public class JpaConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDataSourceProperties(hikariProperties().getProperties());
        DataSource dataSource = new HikariDataSource(new HikariConfig(hikariProperties().getProperties()));
        return dataSource;
    }

    @Bean
//    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan("by.kanarski.eshop.entities");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(hibernateProperties().getProperties());
        return entityManager;
    }

//  Используется только для подсветки сущностей
    @Bean
    @Primary
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setImplicitNamingStrategy(new CustomImplicitNamingStrategy());
        sessionFactoryBean.setHibernateProperties(hibernateProperties().getProperties());
        sessionFactoryBean.setPackagesToScan("by.kanarski.eshop.entities");
//        sessionFactoryBean.setAnnotatedPackages("by.kanarski.eshop.entities.*");
        return sessionFactoryBean;
    }

//    @Bean
//    public CacheManager cacheManager() {
//        return new EhcacheManager(ehCacheCacheManager().getObject());
//    }
//
//    @Bean
//    public EhCacheManagerFactoryBean ehCacheCacheManager() {
//        EhCacheMana
//        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
//        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        cmfb.setShared(true);
//        return cmfb;
//    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa")
    public PropertiesContainer hibernateProperties() {
        return new PropertiesContainer();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public PropertiesContainer hikariProperties() {
        return new PropertiesContainer();
    }

//    @Bean
//    @Primary
//    public MessageSource messageSource() {
//        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:i18n/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }

//    @Bean
//    public LocalValidatorFactoryBean mvcValidator(MessageSource messageSource) {
//        final LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
//        factory.setValidationMessageSource(messageSource);
//        return factory;
//    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Data
    public static class PropertiesContainer {

        private Properties properties;

    }

}
