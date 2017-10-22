/**
 * 
 */
package com.socgen.mkt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Syeda Zainab
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootRestApiApp {
		 
	    public static void main(String[] args) {
	        SpringApplication.run(SpringBootRestApiApp.class, args);
	    }
}
