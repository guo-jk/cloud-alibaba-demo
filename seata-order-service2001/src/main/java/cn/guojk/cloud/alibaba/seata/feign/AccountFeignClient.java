package cn.guojk.cloud.alibaba.seata.feign;

import cn.guojk.cloud.alibaba.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountFeignClient {

    @PostMapping(path = "/account/decrease", name = "减金额")
    CommonResult<?> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);

}
