package com.ouyue.xiwennews.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-18 11-50
 */
@Configuration
@MapperScan({"com.ouyue.xiwennews.dao","com.ouyue.xiwennews.mapper"})
public class MyBatisConfig {
}
