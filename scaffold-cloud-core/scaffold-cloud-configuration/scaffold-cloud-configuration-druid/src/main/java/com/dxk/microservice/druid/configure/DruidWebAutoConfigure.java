package com.dxk.microservice.druid.configure;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.dxk.microservice.druid.properties.DruidWebProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(value = DruidWebProperties.class)
@ConditionalOnProperty(prefix = "com.dxk.microservice.datasource.druid.web",name = "enable",havingValue = "true", matchIfMissing = true)
public class DruidWebAutoConfigure {
    @Autowired
    private DruidWebProperties druidWebProperties;

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置登录查看信息的账号密码.
        registrationBean.addInitParameter("loginUsername",druidWebProperties.getLoginUserName());
        registrationBean.addInitParameter("loginPassword",druidWebProperties.getLoginPassword());
        return registrationBean;
    }

    @Bean(name = "druidWebStatFilter")
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }
}
