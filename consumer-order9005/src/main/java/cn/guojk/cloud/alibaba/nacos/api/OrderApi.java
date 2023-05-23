package cn.guojk.cloud.alibaba.nacos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderApi {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping(path = "/consumer/payment/nacos/{id}")
    public String order(@PathVariable Integer id) {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }

}
