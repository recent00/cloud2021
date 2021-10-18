package com.scut.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.scut.springcloud.dao"})
public class MyBatisConfig {
}
