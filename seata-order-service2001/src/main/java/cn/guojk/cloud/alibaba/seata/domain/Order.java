package cn.guojk.cloud.alibaba.seata.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private Integer money;

    /**
     * 订单状态：[0：创建中；1：已完成]
     */
    private Integer status;

}
