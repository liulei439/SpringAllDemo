package com.learning.multidatasource.config;
 
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.learning.multidatasource.datasource.DataSourceNames;
import com.learning.multidatasource.datasource.DynamicDataSource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
 
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
 
/**
 * 5.多数据源配置类
 */
@Configuration
public class DynamicDataSourceConfig {

    /** Spring应用上下文环境 */
    private static ConfigurableListableBeanFactory beanFactory;
 
	//如果ioc容器中,同一个类型有多个bean,则bean的名称为方法的名称
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        System.out.println(dataSource);
        return dataSource;
    }
 
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave", name = "enabled", havingValue = "true")
    public DataSource slaveDataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        System.out.println(dataSource);
        return dataSource;

    }

 
    @Bean
    @Primary // Primary 一定要写在这里，写上面任意一个bean相当于指定唯一数据源
    public DynamicDataSource dataSource(DataSource masterDataSource,DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.MASTER, masterDataSource);
        targetDataSources.put(DataSourceNames.SLAVE,slaveDataSource);
//        setDataSource(targetDataSources, DataSourceNames.SLAVE, "slaveDataSource");
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

    /**
     * 设置数据源
     *
     * @param targetDataSources 备选数据源集合
     * @param sourceName 数据源名称
     * @param beanName bean名称
     */
    public void setDataSource(Map<Object, Object> targetDataSources, String sourceName, String beanName)
    {
        try
        {
            DataSource dataSource = (DataSource) beanFactory.getBean(beanName);
            targetDataSources.put(sourceName, dataSource);
        }
        catch (Exception e)
        {
        }
    }
}