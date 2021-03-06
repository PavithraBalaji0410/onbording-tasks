package com.cg.application1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cg.application1.dao.IEmployeeDao;

@SpringBootApplication
@ComponentScan(basePackages = "com.cg.application1")
public class Application1Application implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(Application1Application.class);

	@Autowired
	private IEmployeeDao dao;
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = SpringApplication.run(Application1Application.class, args);
	
		String check =context.getApplicationName();
		System.out.println(check);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("found employee",dao.findById(1));
		logger.info("All details",dao.findAll());
		
		
	}

}
