package com.dxk.microservice.mybatisPlus.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.dxk.microservice.mybatisPlus.properties.DataSourceProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Data
@Configuration
@EnableConfigurationProperties(value = DataSourceProperties.class)
@ConditionalOnProperty(prefix = "com.dxk.microservice.datasource",name = "enable",havingValue = "true", matchIfMissing = true)
public class MybatisAutoConfigure {

    @Value("${com.dxk.microservice.datasource.druid.url}")
    private String url;

    @Value("${com.dxk.microservice.datasource.druid.username}")
    private String username;

    @Value("${com.dxk.microservice.datasource.druid.password}")
    private String password;

    @Value("${com.dxk.microservice.datasource.druid.driver-class-name}")
    private String driverClassName;

    @Value("${com.dxk.microservice.datasource.druid.type}")
    private String type;

    @Value("${com.dxk.microservice.datasource.druid.filters}")
    private String filters;

    @Value("${com.dxk.microservice.datasource.druid.loginUserName}")
    private String loginUserName;

    @Value("${com.dxk.microservice.datasource.druid.loginPassword}")
    private String loginPassword;



    @Bean(name = "basisDataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource initDataSource() {
        log.info("初始化DruidDataSource");
        DruidDataSource dds = new DruidDataSource();
        dds.setDriverClassName(driverClassName);
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);
        dds.setDbType(type);
        try {
            dds.setFilters(filters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dds;
    }

    /*@Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername",loginUserName);
        servletRegistrationBean.addInitParameter("loginPassword",loginPassword);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }*/
}
