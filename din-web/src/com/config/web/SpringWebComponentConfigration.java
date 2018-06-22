package com.config.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.config.SecurityConfig;



@Configuration
//@EnableAspectJAutoProxy
@EnableWebMvc

@ComponentScan({ "com.controller"})
@Import({ SecurityConfig.class })
public class SpringWebComponentConfigration extends WebMvcConfigurerAdapter{

	 @Bean(name = "viewResolver")
	    public InternalResourceViewResolver getViewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	        viewResolver.setOrder(1);
	        return viewResolver;
	    }
	  
	  @Bean
	  public TilesConfigurer tilesConfigurer() {
	  TilesConfigurer tiles = new TilesConfigurer();
	  tiles.setDefinitions(new String[] {
	  "/WEB-INF/layout/tiles.xml"
	  });
	  tiles.setCheckRefresh(true);
	  return tiles;
	  }
	  
	  @Bean
	  public ViewResolver viewResolver() {
		  TilesViewResolver tilesViewResolver=	  new TilesViewResolver();
		  tilesViewResolver.setOrder(0);
	  return tilesViewResolver;
	  }
	     
	  /* @Autowired
	    @Bean(name = "auditService")
	    public AuditService getAuditService() {
	    	return new AuditService();
	    }*/
	@Override
	  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		    registry.addResourceHandler("/resources/**","/webjars/**").addResourceLocations("/resources/","/webjars/");
		}
	/*@Bean
    public View jsonTemplate() {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }
     
    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }*/
	
	@Override/*Static content handling*/
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}

}
