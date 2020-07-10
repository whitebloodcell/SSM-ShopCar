package com.lhs.shopcar.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Member {
    private Integer memberId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private String icon;

    private Integer version;
}
