package com.dxk.microservice.mybatis.plus.properties;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = Constants.MYBATIS_PLUS)
public class MybatisPlusAutoProperties extends MybatisPlusProperties {
    /**
     * 是否初始化mybatis-plus
     */
    private boolean enable;
}
