package cn.guojk.cloud.alibaba.seata.service.impl;

import cn.guojk.cloud.alibaba.seata.dao.AccountDao;
import cn.guojk.cloud.alibaba.seata.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    public AccountServiceImpl (AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void decrease(Long userId, Integer money) {
        log.info("seata-account-service 减余额开始...");
        accountDao.decrease(userId, money);
        log.info("seata-account-service 减余额结束...");
    }
}
