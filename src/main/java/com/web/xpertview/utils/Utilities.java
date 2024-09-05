package com.web.xpertview.utils;


import java.security.SecureRandom;

public class Utilities {
    private static final SecureRandom secureRandom = new SecureRandom();
    public static String generateTrackingNumber(){
        StringBuilder output = new StringBuilder();
        int number =  secureRandom.nextInt(100000,999999);
        for (int index = 0; index < 3; index++)
                    output.append(Integer.toString(
                    secureRandom.nextInt(100)).charAt(0));
        return output.append(number).toString();
    }
}
