package com.dxk.microservice.druid.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

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

}
