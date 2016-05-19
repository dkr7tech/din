package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAspectJAutoProxy

@ComponentScan(basePackages={"com.service"},
excludeFilters={
@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
})
public class SpringAppComponentConfig {

}
