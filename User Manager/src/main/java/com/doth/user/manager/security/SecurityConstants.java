package com.doth.user.manager.security;

import com.doth.user.manager.SpringApplicationContext;

public class SecurityConstants {
    public static final String SIGN_UP_URL = "/users";
    public static final String LOGIN_URL = "/users/login";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 84000000;
    public static final String USER_ID = "userID";

    public static String getSecretToken(){
        AppProperties appProperty = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperty.getProper("tokenSecret");
    }
}
