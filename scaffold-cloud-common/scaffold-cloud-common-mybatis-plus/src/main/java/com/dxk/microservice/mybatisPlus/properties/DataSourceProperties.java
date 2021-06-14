package com.dxk.microservice.mybatisPlus.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.dxk.microservice.datasource")
public class DataSourceProperties {
    /**
     * 是否初始化数据源
     */
    private boolean enable = true;
}
