package cn.guojk.cloud.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService9401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelService9401.class, args);
    }
}
