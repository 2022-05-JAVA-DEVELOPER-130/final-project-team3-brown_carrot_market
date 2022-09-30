package com.itwill.brown_carrot_market.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.brown_carrot_market.dao.ProductDao;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.brown_carrot_market"})
public class ProductDaoSpringBootTestApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication application = 
				new SpringApplication(ProductDaoSpringBootTestApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context=application.run(args);
		ProductDao productDao=(ProductDao)context.getBean(ProductDao.class);
		System.out.println(productDao.selectProductAll());
		//System.out.println(guestDao.selectByNo(881));
		
	}
/*
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestDao;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itwill.guest"})
public class GuestDaoSpringBootTestApplication {
	public static void main(String[] args) throws Exception {
		/****************case1********************/
		/*
		 * application.properties에 설정추가
		 *    spring.main.web-application-type=none
		 */
		/*
		ConfigurableApplicationContext context = 
				SpringApplication.run(GuestDaoSpringBootTestApplication.class, args);
		GuestDao guestDao = (GuestDao) context.getBean(GuestDao.class);
		System.out.println(guestDao.selectAll());
		System.out.println(guestDao.selectByNo(881));
		
		
		SpringApplication application = 
				new SpringApplication(GuestDaoSpringBootTestApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context=application.run(args);
		GuestDao guestDao=(GuestDao)context.getBean(GuestDao.class);
		System.out.println(guestDao.selectAll());
		System.out.println(guestDao.selectByNo(881));
		 

	}
}
 */
	
	
}
