package cn.guojk.cloud.alibaba.seata.domain;

import lombok.Data;

@Data
public class Account {

    private Long id;

    private Long userId;

    private Integer total;

    private Integer used;

    private Integer residue;

}
