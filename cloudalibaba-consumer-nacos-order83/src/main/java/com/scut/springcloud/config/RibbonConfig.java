package com.scut.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.scut.springcloud.rule.NacosRandomWithWeightRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfig {

    @Bean
    public IRule rule() {
        return new NacosRandomWithWeightRule();
    }
}
