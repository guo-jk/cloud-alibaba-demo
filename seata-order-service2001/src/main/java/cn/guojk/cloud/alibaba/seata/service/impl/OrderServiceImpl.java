package cn.guojk.cloud.alibaba.seata.service.impl;

import cn.guojk.cloud.alibaba.seata.dao.OrderDao;
import cn.guojk.cloud.alibaba.seata.domain.Order;
import cn.guojk.cloud.alibaba.seata.feign.AccountFeignClient;
import cn.guojk.cloud.alibaba.seata.service.OrderService;
import cn.guojk.cloud.alibaba.seata.feign.StorageFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    private final StorageFeignClient storageService;

    private final AccountFeignClient accountService;

    public OrderServiceImpl(OrderDao orderDao, StorageFeignClient storageService, AccountFeignClient accountService) {
        this.orderDao = orderDao;
        this.storageService = storageService;
        this.accountService = accountService;
    }


    @GlobalTransactional(name = "fsp-insert-order", rollbackFor = Exception.class)
    @Override
    public void insert(Order order) {

        // 创建订单
        log.info("-------------->建订单");
        orderDao.insert(order);

        // 减库存
        log.info("-------------->减库存");
        storageService.decrease(order.getProductId(), order.getCount());

        // 减金额
        log.info("-------------->减金额");
        accountService.decrease(order.getUserId(), order.getMoney());

        // 完成订单
        log.info("-------------->修订单");
        int age = 10 / 0;
        orderDao.update(order);
    }
}
