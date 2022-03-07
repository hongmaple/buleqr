package com.buleqr.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 二维码配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "qrcode")
public class QrCodeProperties {
    private String domainName;
    private String logoUrl;
}
