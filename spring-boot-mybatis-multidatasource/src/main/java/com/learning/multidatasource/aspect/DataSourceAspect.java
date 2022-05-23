package com.learning.multidatasource.aspect;

import com.learning.multidatasource.annotation.DataSource;
import com.learning.multidatasource.datasource.DataSourceNames;
import com.learning.multidatasource.datasource.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
 
import java.lang.reflect.Method;
 
/**
 * 4.多数据源，切面处理类
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
	 * 针对上面注解做切面拦截
 	 */
    @Pointcut("@annotation(com.learning.multidatasource.annotation.DataSource)")
    public void dataSourcePointCut() {}
 
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
        	//如果没有注解,使用默认数据源
            DynamicDataSource.setDataSource(DataSourceNames.MASTER);
        }else {
        	//根据注解中设置的数据源名称,选择对应的数据源
            DynamicDataSource.setDataSource(ds.name());
            logger.debug("set datasource is " + ds.name());
            System.out.println(ds.name());
        }
 
        try {
            return point.proceed();
        } finally {
        	//清除数据源配置
            DynamicDataSource.clearDataSource();
        }
    }
 
    @Override
    public int getOrder() {
        return 1;
    }
}