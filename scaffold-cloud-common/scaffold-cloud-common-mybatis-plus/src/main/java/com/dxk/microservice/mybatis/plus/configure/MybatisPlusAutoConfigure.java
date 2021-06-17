package com.dxk.microservice.mybatis.plus.configure;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dxk.microservice.mybatis.plus.properties.MybatisPlusAutoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(value = MybatisPlusAutoProperties.class)
@ConditionalOnProperty(prefix = Constants.MYBATIS_PLUS, name = "enable", havingValue = "true", matchIfMissing = true)
@AutoConfigureAfter(MybatisPlusAutoConfiguration.class)
public class MybatisPlusAutoConfigure {
    @Autowired
    private MybatisPlusAutoProperties mybatisPlusAutoProperties;

    public MybatisPlusAutoConfigure(MybatisPlusAutoProperties mybatisPlusAutoProperties) {
        this.mybatisPlusAutoProperties = mybatisPlusAutoProperties;
    }
}
