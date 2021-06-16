package com.dxk.microservice.druid.configure;

import com.dxk.microservice.druid.properties.DruidWebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = DruidWebProperties.class)
//@ConditionalOnProperty(prefix = "com.dxk.microservice.datasource.druid.web",name = "enable",havingValue = "true", matchIfMissing = true)
public class DruidWebAutoConfigure {
}
