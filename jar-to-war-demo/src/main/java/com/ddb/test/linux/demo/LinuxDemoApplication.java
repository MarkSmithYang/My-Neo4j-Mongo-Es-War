package com.ddb.test.linux.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
@SpringBootApplication
// @EnableTransactionManagement//加入data-jpa就有了此注解/jdbc应该可以---事物管理器
public class LinuxDemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(LinuxDemoApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LinuxDemoApplication.class, args);
	}
}

