package com.dirspy.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class StudentsWebServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentsWebServiceApplication.class);
	}

	public static void main(String[] args) {
		new StudentsWebServiceApplication()
				.configure(new SpringApplicationBuilder(StudentsWebServiceApplication.class))
				.run(args);
	}
}
