package cn.guojk.cloud.alibaba.seata.api;

import cn.guojk.cloud.alibaba.seata.domain.CommonResult;
import cn.guojk.cloud.alibaba.seata.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "storage", name = "库存")
public class StorageApi {

    private final StorageService storageService;

    public StorageApi(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(path = "/decrease", name = "减库存")
    public CommonResult<?> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);

        CommonResult<?> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setMsg("减库存成功");
        return commonResult;
    }

}
