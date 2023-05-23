package cn.guojk.cloud.alibaba.seata.dao;

import cn.guojk.cloud.alibaba.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    void insert(Order order);

    void update(Order order);
}
