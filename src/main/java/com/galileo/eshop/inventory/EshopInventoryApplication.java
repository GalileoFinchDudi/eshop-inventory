package com.galileo.eshop.inventory;

import java.util.HashSet;
import java.util.Set;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * 库存服务的Application入口类
 */
@MapperScan("com.galileo.eshop.inventory.mapper")
@SpringBootApplication
public class EshopInventoryApplication {

    /**
     * 构建数据源
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DataSource();
    }

    /**
     * 构建MyBatis的入口类：SqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 构建事务管理器
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JedisCluster jedisClusterFactory(){
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("10.1.70.220", 7004));
        jedisClusterNodes.add(new HostAndPort("10.1.70.223", 7005));
        jedisClusterNodes.add(new HostAndPort("10.1.70.220", 7003));
        jedisClusterNodes.add(new HostAndPort("10.1.70.200", 7001));
        jedisClusterNodes.add(new HostAndPort("10.1.70.223", 7006));
        jedisClusterNodes.add(new HostAndPort("10.1.70.200", 7002));
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
        return jedisCluster;
    }

    /**
     * Spring Boot 启动 main方法
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(EshopInventoryApplication.class, args);
    }

}
