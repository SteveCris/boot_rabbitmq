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
public @interface RedisCacheAble {
    String value() default "";   //key名称、前缀
    String[] names() default {};  //所需要包含的键值
    long timeout() default 30; //过期时间
}
