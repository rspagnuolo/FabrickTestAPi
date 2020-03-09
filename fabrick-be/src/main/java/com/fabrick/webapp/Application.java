/**
 * 
 */
package com.fabrick.webapp;

import com.fabrick.webapp.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author Spagnuolo Roberto
 *
 */
@Import(AppConfig.class)
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
