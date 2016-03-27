package com.newssystem.lab;

import com.newssystem.lab.model.Comment;
import com.newssystem.lab.model.News;
import com.newssystem.lab.service.CommentService;
import com.newssystem.lab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableCaching
public class NewsSystemApplication implements CommandLineRunner {


	@Autowired
	public NewsService newsService;

	@Autowired
	public CommentService commentService;

	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}


	public static void main(String[] args) {
		SpringApplication.run(NewsSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {




		News obj = new News("Tytul", "Tresc", "Data", "Autor");
		News obj2 = new News("Tytul2", "Tresc2", "Data2", "Autor2");

		newsService.create(obj);
		newsService.create(obj2);

		Comment comObj = new Comment("123","56f149110706d23db6542453","123","123","123");
		Comment comObj2 = new Comment("Nowy","56f149110706d23db6542453","123","123","123");

		commentService.create(comObj);
		commentService.create(comObj2);

	}


}