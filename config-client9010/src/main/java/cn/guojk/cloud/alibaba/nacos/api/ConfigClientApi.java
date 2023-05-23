package cn.guojk.cloud.alibaba.nacos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 支持Nacos配置动态刷新
public class ConfigClientApi {

    @Value(value = "${config.info}")
    private String configInfo;

    @GetMapping(path = "/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

}
