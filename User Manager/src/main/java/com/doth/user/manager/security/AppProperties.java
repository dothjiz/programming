package com.doth.user.manager.security;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    private final Environment ENV;

    public AppProperties(Environment ENV) {
        this.ENV = ENV;
    }

    public String getProper(String name){
        return ENV.getProperty(name);
    }

}
