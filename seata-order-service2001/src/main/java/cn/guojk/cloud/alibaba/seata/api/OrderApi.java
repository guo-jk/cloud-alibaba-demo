package cn.guojk.cloud.alibaba.seata.api;

import cn.guojk.cloud.alibaba.seata.domain.CommonResult;
import cn.guojk.cloud.alibaba.seata.domain.Order;
import cn.guojk.cloud.alibaba.seata.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "order", name = "订单")
public class OrderApi {

    private final OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "insert", name = "建订单")
    public CommonResult<?> insert(@RequestBody Order order) {
        orderService.insert(order);

        CommonResult<?> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setMsg("订单创建成功");
        return commonResult;
    }


}
