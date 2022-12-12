package com.leyou.sms.ye.rly.utils;

import java.util.Random;

/**
 * 随机生成验证码
 * @author 小叶
 */
public class RandCode {
    public static String getRandCode(Integer len){

        StringBuilder builder=new StringBuilder();
        Random random=new Random();
        len=Math.min(len,8);

        for (int i = 0; i <len; i++) {
            //产生0-9的随机数 根据len参数
            int nextInt = random.nextInt(10);
            //把int类型转换成string类型
            builder.append(String.valueOf(nextInt));
        }
        return builder.toString();
    }

}
