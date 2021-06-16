package com.dxk.microservice.druid.configure;

import com.dxk.microservice.druid.properties.DruidProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = DruidProperties.class)
@ConditionalOnProperty(prefix = "com.dxk.microservice.datasource.druid",name = "enable",havingValue = "true", matchIfMissing = true)
public class DruidAutoConfigure {
}
