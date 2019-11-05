/**
 * @Copyright (C), 2013-2019 www.sino-essence.com Inc. All rights reserved.
 * @Title:    MultiSqlSessionFactoryConfig.java
 * @Package:  cn.stylefeng.guns.config.datasource.multi
 * @Description:   TODO
 * @author:      xuBiao
 * @date:  2019年7月1日 下午2:42:12
 * @Version:   V1.0.0
*/
package cn.stylefeng.guns.config.datasource.multi;

import cn.stylefeng.roses.core.config.properties.DruidProperties;
import cn.stylefeng.roses.core.datascope.DataScopeInterceptor;
import cn.stylefeng.roses.core.mutidatasource.mybatis.OptionalSqlSessionTemplate;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  MultiSqlSessionFactoryConfig
 * @Description:   TODO
 * @author: xuBiao
 * @date:  2019年7月1日 下午2:42:12
*/

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "guns.muti-datasource", name = "open", havingValue = "true")
public class MultiSqlSessionFactoryConfig {
	
	/**
     * xml文件的位置，改包了注意修改哦
     */
    public static final String MAPPING_XML_CLASSPATH = "classpath:cn/stylefeng/guns/modular/**/mapping/*.xml";

    /**
     * 主sqlSessionFactory
     */
    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactoryPrimary(@Qualifier("dataSourcePrimary") DataSource dataSource) {
        return createSqlSessionFactory(dataSource);
    }

    /**
     * 第二个sqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBusiness(@Qualifier("dataSourceBusiness") DataSource dataSource) {
        return createSqlSessionFactory(dataSource);
    }

    /**
     * 多数据源sqlSessionTemplate切换模板
     */
    @Bean(name = "gunsSqlSessionTemplate")
    public OptionalSqlSessionTemplate gunsSqlSessionTemplate(@Qualifier("sqlSessionFactoryPrimary") SqlSessionFactory sqlSessionFactoryPrimary,
                                                             @Qualifier("sqlSessionFactoryBusiness") SqlSessionFactory sqlSessionFactoryBusiness,
                                                             @Qualifier("druidProperties") DruidProperties druidProperties,
                                                             @Qualifier("mutiDataSourceProperties") DruidProperties mutiDataSourceProperties) {
        if (ToolUtil.isOneEmpty(druidProperties, druidProperties.getDataSourceName())) {
            throw new IllegalArgumentException("初始化OptionalSqlSessionTemplate错误！请设置spring.datasource.data-source-name属性的值！");
        }

        if (ToolUtil.isOneEmpty(mutiDataSourceProperties, mutiDataSourceProperties.getDataSourceName())) {
            throw new IllegalArgumentException("初始化OptionalSqlSessionTemplate错误！请设置spring.muti-datasource.data-source-name属性的值！");
        }

        Map<Object, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
        sqlSessionFactoryMap.put(druidProperties.getDataSourceName(), sqlSessionFactoryPrimary);
        sqlSessionFactoryMap.put(mutiDataSourceProperties.getDataSourceName(), sqlSessionFactoryBusiness);
        return new OptionalSqlSessionTemplate(sqlSessionFactoryPrimary, sqlSessionFactoryMap);
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 数据范围mybatis插件
     */
    @Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }

    /**
     * 乐观锁mybatis插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 创建数据源
     */
    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource) {
        try {
            MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPING_XML_CLASSPATH));
            bean.setVfs(SpringBootVFS.class);
            bean.setPlugins(new Interceptor[]{
                    paginationInterceptor(),
                    dataScopeInterceptor(),
                    optimisticLockerInterceptor()
            });
            return bean.getObject();
        } catch (Exception e) {
            log.error("初始化SqlSessionFactory错误！", e);
            throw new ServiceException(500, "初始化SqlSessionFactory错误！");
        }
    }

}
