package cn.guojk.cloud.alibaba.sentinel.api;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitApi {

    @GetMapping(path = "/testA")
    public String testA() {
        return "--- testA";
    }

    @GetMapping(path = "/testB")
    public String testB() {

        log.info("{} ...testB", Thread.currentThread().getName());

        return "--- testB";
    }

    @GetMapping(path = "/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("testD 测试RT");

        return "--- testD 测试RT";
    }

    @GetMapping(path = "/testE")
    public String testE() {
        log.info("testE 测试异常比例");

        int a = 10 / 0;

        return "--- testE 测试异常比例";
    }

    @GetMapping(path = "/testF")
    public String testF() {
        log.info("testF 测试异常数");

        int a = 10 / 0;

        return "--- testF 测试异常数";
    }

    @GetMapping(path = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "--- testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException blockException) {
        return "--- deal_testHotKey";
    }
}
