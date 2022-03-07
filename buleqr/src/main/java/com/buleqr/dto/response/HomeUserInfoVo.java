package com.buleqr.dto.response;

import lombok.Data;

@Data
public class HomeUserInfoVo {
    private String username;
    private long inNumberOfDays;
    private String designation;
}
