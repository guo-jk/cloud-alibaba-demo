package cn.guojk.cloud.alibaba.nacos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentApi {

    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping(path = "/payment/nacos/{id}")
    public String getPayment(@PathVariable Integer id) {
        return "nacos registry, serverPort: " + serverPort + ", id: " + id;
    }

}
