package com.epam.spring.core.context;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dmytro_Adonin
 * @since 2/18/2016.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseApplicationContext {

    @Bean
    public SessionFactory sessionFactory() throws Exception {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        localSessionFactoryBean.afterPropertiesSet();
        return  localSessionFactoryBean.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws Exception {
        return new HibernateTransactionManager(sessionFactory());
    }

}
