package com.bladejava.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.blade.Blade;
import com.blade.ioc.annotation.Bean;
import com.blade.loader.BladeLoader;
import com.blade.mvc.view.template.JetbrickTemplateEngine;
import ralin.Ralin;

@Bean
public class startUpConfig implements BladeLoader {

    @Override
    public void load(Blade blade){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(blade.environment().getOrNull("jdbc.url"));
        dataSource.setUsername(blade.environment().getOrNull("jdbc.username"));
        dataSource.setPassword(blade.environment().getOrNull("jdbc.password"));
        Ralin.open(dataSource);

        //如果你render的页面使用了vue等前端渲染模板，则使用下面的jetbrick模板引擎
//        blade.templateEngine(new JetbrickTemplateEngine());
    }
}
