package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by msanaulla on 12/3/2014.
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class AppRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }
}
