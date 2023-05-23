package cn.guojk.cloud.alibaba.seata.api;

import cn.guojk.cloud.alibaba.seata.domain.CommonResult;
import cn.guojk.cloud.alibaba.seata.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/account", name = "余额")
public class AccountApi {

    private final AccountService accountService;

    public AccountApi(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/decrease", name = "减金额")
    public CommonResult<?> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) {
        accountService.decrease(userId, money);

        CommonResult<?> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setMsg("减余额成功");
        return commonResult;
    }

}
