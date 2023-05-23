package cn.guojk.cloud.alibaba.sentinel.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CustomerBlockHandler {

    public static ResponseEntity<?> handlerException(BlockException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", 4444);
        body.put("message", "按客户自定义， global handlerException---1");
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<?> handlerException2(BlockException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", 4444);
        body.put("message", "按客户自定义， global handlerException---2");
        return ResponseEntity.ok(body);
    }

}
