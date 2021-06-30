package com.dxk.microservice.druid.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.dxk.microservice.datasource.druid.web")
public class DruidWebProperties {
    /**
     * 是否初始化数据源
     */
    private boolean enable = true;

    /**
     * Druid数据界面登录用户名
     */
    private String loginUserName;

    /**
     * Druid数据界面登录密码
     */
    private String loginPassword;
}
