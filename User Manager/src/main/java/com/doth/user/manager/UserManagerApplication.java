package com.doth.user.manager;

import com.doth.user.manager.security.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserManagerApplication {
    final Environment ENV;
    public UserManagerApplication(Environment ENV) {
        this.ENV = ENV;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserManagerApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext getApplicationContext(){
        return  new SpringApplicationContext();
    }

    @Bean
    public AppProperties getAppProperties(){
        return new AppProperties(ENV);
    }

}
