package com.itwill.brown_carrot_market.test.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.brown_carrot_market.dao.ProductImageDao;
import com.itwill.brown_carrot_market.dto.ProductImage;

	@SpringBootApplication
	@ComponentScan(basePackages = {"com.itwill.brown_carrot_market"})
	public class ProductImageDaoSpringBootTestApplication {
		
		public static void main(String[] args) throws Exception{
			SpringApplication application = 
					new SpringApplication(ProductImageDaoSpringBootTestApplication.class);
			application.setWebApplicationType(WebApplicationType.NONE);
			ConfigurableApplicationContext context=application.run(args);
			ProductImageDao productImageDao=(ProductImageDao)context.getBean(ProductImageDao .class);
			
			//System.out.println(productImageDao.selectProductImgList(1));
			//System.out.println(productImageDao.selectProductImgOne(1));
			//System.out.println(productImageDao.insertProductImg(new ProductImage(0, "test.jpg", 10)));
			//System.out.println(productImageDao.deleteProductImg(21));
		}
}
