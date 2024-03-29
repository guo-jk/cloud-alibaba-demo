package cn.guojk.cloud.alibaba.seata.domain;

import lombok.Data;

@Data
public class Storage {

    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;

}
