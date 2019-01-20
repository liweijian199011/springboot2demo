package com.jack;

import com.jack.controller.UserController;
import com.jack.entity.User;
import com.jack.handler.GreetingWebClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableAspectJAutoProxy
@RestController
@SpringBootApplication
@MapperScan("com.jack.mapper")
public class Springboot2demoApplication implements ApplicationContextAware {

    private static ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(Springboot2demoApplication.class, args);

		System.out.println("hello, liweijian, CNM");
//		ThreadTest threadTest = new ThreadTest();
//
//		for (int i = 0; i < 100; i++) {
//		    new Thread(threadTest).start();
//        }
	}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    static class ThreadTest implements Runnable {
        UserController userController = context.getBean(UserController.class);
        @Override
        public void run() {
//            userController.print();
            userController.printService();
        }
    }

    @Bean
    public ViewResolver viewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/");
	    viewResolver.setSuffix(".html");
	    return viewResolver;
    }
}
