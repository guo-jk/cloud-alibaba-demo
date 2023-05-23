package cn.guojk.cloud.alibaba.seata.domain;

import lombok.Data;

@Data
public class CommonResult<T> {

    private Integer code;

    private String msg;

    private T data;

}
