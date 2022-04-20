package com.scut.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

    //模拟ribbon实现
    @GetMapping("/consumer/payment1/nacos/{id}")
    public String paymentInfo1(@PathVariable("id") Long id) {
        //模拟ribbon实现
        /**
         * ribbon底层就是从注册中心中根据服务名获取实例结点，然后通过负载均衡算法选择一个结点，把结点的url信息替换服务名，发起服务调用
         */
        String url = getUri("nacos-payment-provider")+"/payment/nacos/"+id;
        return restTemplate.getForObject(url,String.class);
    }
    @Autowired
    private DiscoveryClient discoveryClient;

    private String getUri(String serviceName) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);//从注册中心中获取结点实例
        if(serviceInstances == null || serviceInstances.isEmpty()) {
            return null;
        }
        int serviceSize = serviceInstances.size();
        //轮询
        int indexServer = incrementAndGetModulo(serviceSize);
        return serviceInstances.get(indexServer).getUri().toString();
    }
    private AtomicInteger nextIndex = new AtomicInteger(0);
    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextIndex.get();
            int next = (current + 1) % modulo;
            if (nextIndex.compareAndSet(current, next) && current < modulo){
                return current;
            }
        }
    }

}
