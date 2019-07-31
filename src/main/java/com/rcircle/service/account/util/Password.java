package com.rcircle.service.account.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Pattern;

public class Password {
    public static Password instance = null;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

    public static Password self(){
        if(instance == null){
            instance = new Password();
        }
        return instance;
    }

    public String crypt(String str){
        if (!BCRYPT_PATTERN.matcher(str).matches()) {
            return passwordEncoder.encode(str);
        }
        return str;
    }

    public boolean isSame(String raw, String encode){
        return passwordEncoder.matches(raw, encode);
    }
}
