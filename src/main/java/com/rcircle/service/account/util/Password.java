package com.rcircle.service.account.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
    public static String crypt(String str) {
        return new BCryptPasswordEncoder().encode(str.trim());
    }

    public static boolean isSame(String password, String encrypass){
        return new BCryptPasswordEncoder().matches(password, encrypass);
    }
}
