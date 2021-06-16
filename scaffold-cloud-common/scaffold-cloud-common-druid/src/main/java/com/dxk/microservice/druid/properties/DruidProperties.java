package com.dxk.microservice.druid.properties;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@Data
@ConfigurationProperties(prefix = "com.dxk.microservice.datasource.druid")
public class DruidProperties {
    /**
     * 是否初始化数据源
     */
    private boolean enable = true;

    /**
     * 数据库连接地址
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 驱动类名称
     */
    private String driverClassName;

    /**
     * 数据源类型，如：Druid/Hikari
     */
    private String type;

    /**
     * 过滤
     */
    private String filters;

    /**
     * 初始化数据源
     * @return
     */
    @Bean(name = "druidDataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource initDataSource() {
        log.info("初始化Druid数据源DruidDataSource 开始--------------------");
        DruidDataSource dds = null;
        try {
            dds = new DruidDataSource();
            dds.setUrl(url);
            dds.setUsername(username);
            dds.setPassword(password);
            dds.setDriverClassName(driverClassName);
            dds.setDbType(type);
            dds.setFilters(filters);
        } catch (Exception e) {
            log.error("Druid数据源初始化异常，异常信息为：{}", e.getMessage());
        }
        log.info("初始化Druid数据源DruidDataSource 结束--------------------");
        return dds;
    }

}
