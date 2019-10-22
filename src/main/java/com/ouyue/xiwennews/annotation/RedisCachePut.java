package com.ouyue.xiwennews.annotation;

import java.lang.annotation.*;

/**
 * @author :tongjingji01@gmail.com
 * @program:billionbottle-engine
 * @description:
 * @create:2019-10-21 17-16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RedisCachePut {
    String value() default "";  //类名
    String key() default "";   //所需要存的key名
    String [] names() default ""; //类中需要存的字段
}