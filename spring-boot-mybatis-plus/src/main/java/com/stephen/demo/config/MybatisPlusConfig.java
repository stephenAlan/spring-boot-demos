package com.stephen.demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by stephen on 2021-01-29 11:08 .
 * Description: 分页插件配置
 */
@Configuration
@MapperScan("com.stephen.demo.mapper")
public class MybatisPlusConfig {

    // // 新版本已过时
    // @Bean
    // public PaginationInterceptor paginationInterceptor() {
    //     PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    //     paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
    //     return new PaginationInterceptor();
    // }

    // 3.4.0版本以上用这个
    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

}
