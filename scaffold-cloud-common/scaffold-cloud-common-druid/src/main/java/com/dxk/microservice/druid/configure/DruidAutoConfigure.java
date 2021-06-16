package com.dxk.microservice.druid.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.dxk.microservice.druid.properties.DruidProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(value = DruidProperties.class)
@ConditionalOnProperty(prefix = "com.dxk.microservice.datasource.druid",name = "enable",havingValue = "true", matchIfMissing = true)
public class DruidAutoConfigure {
    @Autowired
    private DruidProperties druidProperties;

    /**
     * 初始化数据源
     * @return
     */
    @Bean(name = "druidDataSource", initMethod = "init", destroyMethod = "close")
    @ConditionalOnMissingBean
    public DruidDataSource initDataSource() {
        log.info("初始化Druid数据源DruidDataSource 开始--------------------");
        DruidDataSource dds = null;
        try {
            dds = new DruidDataSource();
            dds.setUrl(druidProperties.getUrl());
            dds.setUsername(druidProperties.getUsername());
            dds.setPassword(druidProperties.getPassword());
            dds.setDriverClassName(druidProperties.getDriverClassName());
            dds.setDbType(druidProperties.getType());
            dds.setFilters(druidProperties.getFilters());
        } catch (Exception e) {
            log.error("Druid数据源初始化异常，异常信息为：{}", e.getMessage());
        }
        log.info("初始化Druid数据源DruidDataSource 结束--------------------");
        return dds;
    }
}
