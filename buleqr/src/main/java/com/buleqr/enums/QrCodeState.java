package com.buleqr.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QrCodeState implements CodedEnum {
    /**
     *二维码状态
     */
    UNKNOWN(0, "未知"),
    NOT_BOUND(1, "未绑定"),
    IS_BINDING(2, "已绑定")
    ;
    private final Integer code;

    private final String tag;
}
