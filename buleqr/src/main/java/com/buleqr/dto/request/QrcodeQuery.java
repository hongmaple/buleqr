package com.buleqr.dto.request;

import com.buleqr.enums.QrCodeState;
import com.buleqr.pojo.PageDomain;
import lombok.Data;

/**
 * @author maple
 */
@Data
public class QrcodeQuery extends PageDomain {
    private QrCodeState qrCodeState;
}
