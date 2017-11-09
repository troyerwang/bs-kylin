package com.kylinteam.base.utils;

import java.time.Instant;

/**
 * Created by troy on 2017/11/8.
 */
public class KeyUtil {
    public static String transform(Long number){
        StringBuffer resBuffer = new StringBuffer();
        while (number > 0){
            resBuffer.append(transformTochar(number%62));
            number/=62;
        }
        return resBuffer.reverse().toString();
    }

    /**
     * @describe:
     * @param number
     * @return
     */
    public static String transformTochar(long number){
        if (number < 10) {
            return number + "";
        }
        if(number >=10 && number <36 ){
            number = number+55;
            char res =(char)number;
            return res+"";
        }
        if(number >=36 && number < 62 ){
            number = number+61;
            char res =(char)number;
            return res+"";
        }
        else {
            return null;
        }
    }

    public  static void main(String []args){
        Long time = Instant.now().toEpochMilli();
        System.out.println(time);
        System.out.println(transform(time));

    }

}
