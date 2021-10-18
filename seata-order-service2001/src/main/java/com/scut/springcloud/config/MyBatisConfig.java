package com.scut.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.scut.springcloud.dao"})//使得dao包内的所有接口可以被扫到，不用一个一个加@Mapper
public class MyBatisConfig {
}
