package com.hakaryzhang.config;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

// 这里还不太懂
public class MybatisConfig {

    /*
    Mybatis 的封装层次
        database <- jdbc <- mybatis
    Mybatis 的工作流程
        factory -> session -> op_instance -> [jdbc] -> result -> domain
     */

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 采用配置数据源，如果不配置数据源，则要在此配置 jdbc 数据库配置
        factoryBean.setDataSource(dataSource);
        // mybatis 自动扫描 domain 的实体对象，自动实现从查询结果到实体类的映射
        factoryBean.setTypeAliasesPackage("com.hakaryzhang.domain");
        return factoryBean;
    }

    // 我们只用定义 dao 的接口，定义对数据库的操作。mybatis 动态代理得到实现类
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.hakaryzhang.dao");
        return msc;
    }
}
