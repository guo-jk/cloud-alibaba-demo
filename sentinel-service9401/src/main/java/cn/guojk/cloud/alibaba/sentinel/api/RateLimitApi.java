package cn.guojk.cloud.alibaba.sentinel.api;

import cn.guojk.cloud.alibaba.sentinel.blockhandler.CustomerBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RateLimitApi {

    @GetMapping(path = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public ResponseEntity<?> byResource() {
        Map<String, Object> body = new HashMap<>();
        body.put("code", 200);
        body.put("message", "按资源名称限流测试OK");

        Map<String, Object> data = new HashMap<>();
        data.put("id", 2020L);
        data.put("serial", "serial001");

        body.put("data", data);
        return ResponseEntity.ok(body);
    }

    public ResponseEntity<?> handleException(BlockException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", 4444);
        body.put("message", exception.getClass().getCanonicalName() + " 服务不可用");
        return ResponseEntity.ok(body);
    }


    @GetMapping(path = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public ResponseEntity<?> customerBlockHandler() {
        Map<String, Object> body = new HashMap<>();
        body.put("code", 200);
        body.put("message", "按资源名称限流测试OK");

        Map<String, Object> data = new HashMap<>();
        data.put("id", 2020L);
        data.put("serial", "serial003");

        body.put("data", data);
        return ResponseEntity.ok(body);
    }
}
