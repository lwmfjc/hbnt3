package fife.ly.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author user
 */
@Configuration
@ComponentScan("fife.ly")
/**
 * 这里不是@Transactional 不要再写错了
 * 会导致java.lang.NoClassDefFoundError: org.springframework.beans.FatalBeanException的错误
 */
@EnableTransactionManagement
public class ConfigShop {
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .addScript("sql/schema.sql").addScript("sql/data.sql")
                .build();
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        //transactionManager需要设置sessionFactory
        return new HibernateTransactionManager(sessionFactory());
    }
    @Bean
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
        localSessionFactoryBean.setPackagesToScan("fife.ly");
        //这个不能随便设置, 会导致报错
        //localSessionFactoryBean.setJtaTransactionManager(platformTransactionManager());
        //sessionFactory需要设置dataSource
        localSessionFactoryBean.setDataSource(dataSource());
        try {
            localSessionFactoryBean.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localSessionFactoryBean.getObject();
    }
}
