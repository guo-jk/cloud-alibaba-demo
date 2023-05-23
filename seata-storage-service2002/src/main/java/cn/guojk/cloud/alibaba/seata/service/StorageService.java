package cn.guojk.cloud.alibaba.seata.service;

public interface StorageService {

    void decrease(Long productId, Integer count);

}
