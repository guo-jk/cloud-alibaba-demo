package cn.guojk.cloud.alibaba.seata.service.impl;

import cn.guojk.cloud.alibaba.seata.dao.StorageDao;
import cn.guojk.cloud.alibaba.seata.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    private final StorageDao storageDao;

    public StorageServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("seata-storage-service 减库存开始...");
        storageDao.decrease(productId, count);
        log.info("seata-storage-service 减库存结束...");
    }
}
