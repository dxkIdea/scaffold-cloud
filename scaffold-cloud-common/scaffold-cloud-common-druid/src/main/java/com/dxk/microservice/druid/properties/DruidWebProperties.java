package com.dxk.microservice.druid.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
//@ConfigurationProperties(prefix = "com.dxk.microservice.datasource.druid.web")
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
