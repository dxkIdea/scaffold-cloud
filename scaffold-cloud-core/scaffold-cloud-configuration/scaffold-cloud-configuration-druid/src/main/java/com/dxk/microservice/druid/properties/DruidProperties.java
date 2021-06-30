package com.dxk.microservice.druid.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

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
     * 初始化大小
     */
    private Integer initialSize;

    /**
     * 最小连接数
     */
    private Integer minIdle;

    /**
     * 最大连接数
     */
    private Integer maxIdle;

    /**
     * 最大连接数
     */
    private Integer maxActive;

    /**
     * 获取连接等待超时时间
     */
    private Integer maxWait;

    /**
     * 间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     */
    private Integer timeBetweenEvictionRunsMillis;

    /**
     * 一个连接在池中最小生存的时间，单位是毫秒
     */
    private Integer minEvictableIdleTimeMillis;

    /**
     *
     */
    private String validationQuery;

    /**
     *
     */
    private Boolean testWhileIdle;

    /**
     *
     */
    private Boolean testOnBorrow;

    /**
     *
     */
    private Boolean testOnReturn;

    /**
     *
     */
    private Boolean poolPreparedStatements;

    /**
     *
     */
    private Integer maxPoolPreparedStatementPerConnectionSize;

    /**
     *
     */
    private Boolean useGlobalDataSourceStat;

    /**
     *
     */
    private Properties connectionProperties;

}
