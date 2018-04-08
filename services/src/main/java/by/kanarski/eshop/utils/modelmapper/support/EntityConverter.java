package by.kanarski.eshop.utils.modelmapper.support;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import by.kanarski.eshop.config.JpaConfig;
import by.kanarski.eshop.utils.modelmapper.service.ModelMapperWrapper;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public abstract class EntityConverter<S, D> extends AbstractConverter<S, D> implements InitializingBean {

    protected ApplicationContext applicationContext;

    protected ModelMapperWrapper getMapper() {
        return applicationContext.getBean(ModelMapperWrapper.class);
    }

    protected ModelMapper getDefaultMapper() {
        return applicationContext.getBean(ModelMapperWrapper.class).emptyMapper();
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ClassLoader classLoader = JpaConfig.class.getClassLoader();
        System.out.println(classLoader.getParent());
    }

    public void initializeConstants() {
        JpaConfig.class.getClassLoader();
    }

    private String getEntitiesRoot() {
        return "entities";
    }

    public static void main(String[] args) {
        ClassLoader classLoader = JpaConfig.class.getClassLoader();
        System.out.println(classLoader.getParent());
    }

}
