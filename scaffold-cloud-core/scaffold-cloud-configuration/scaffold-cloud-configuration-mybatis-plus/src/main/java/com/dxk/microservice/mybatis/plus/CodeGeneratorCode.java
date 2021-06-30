package com.dxk.microservice.mybatis.plus;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import lombok.extern.slf4j.Slf4j;

import java.sql.Driver;
import java.util.Scanner;

@Slf4j
public class CodeGeneratorCode {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder("jdbc:mysql://127.0.0.1:3306/scaffold-cloud?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&serverTimeZone=GMT","root","123456")
                .driver(Driver.class)
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .dbQuery(new MySqlQuery())
                .schema("scaffold-cloud")
                .build();

        GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder()
                //.fileOverride(true)
                .openDir(true)
                //.kotlin(false)
                //.swagger(true)
                .outputDir("com/dxk/microservice/mybatis/plus/mapper")
                .author("dingxk")
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();

        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .parent("com/dxk/microservice/mybatis/plus/mapper")
                .moduleName("scaffold-cloud")
                .build();

        TemplateConfig templateConfig = new TemplateConfig
                .Builder()
                .build();

        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
                //.enableSqlFilter(true)// 启用sql过滤
                //.capitalMode(true)// 是否大写命名
                .entityBuilder()// 实体配置构建者
                .enableLombok()// 开启lombok模型
                .versionColumnName("version") //乐观锁数据库表字段
                .naming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略
                .addTableFills(new Column("create_time", FieldFill.INSERT))	//基于数据库字段填充
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))	//基于模型属性填充
                .controllerBuilder() //控制器属性配置构建
                //.restStyle(true)
                .build();

        //构建代码自动生成器对象
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig)
                .config(new ConfigBuilder(packageConfig,dataSourceConfig,strategyConfig,templateConfig,globalConfig,null));
        autoGenerator.execute();

    }

}
