package com.springboot.study.springbootshiro.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringBoot配置Cors解决跨域请求问题
 * 
 * @ClassName: CorsFilter
 * @Description:TODO
 * @author: Huang
 * @date: 2018年12月18日 下午1:55:02
 * 
 * @Copyright: 2018 注意：本内容仅限于黄世民毕业设计使用，禁止外泄以及用于其他的商业目的
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
				.maxAge(3600).allowCredentials(true);
	}

}
