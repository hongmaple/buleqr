package com.buleqr.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.buleqr.enums.QrCodeState;
import lombok.Data;

import java.util.Date;

@Data
public class QrCodeUserFile {
    public static final String FILEDIRECTORY = "/QrCodeUserFile";
    @TableId(type = IdType.AUTO)
    private Long id;
    private String qrUuid;
    private String qrUrl;
    private QrCodeState qrCodeState;
    /**
     * 创建者
     */
    private Long creatorId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 最后一次扫码时间
     */
    private Date lastScanTime;
    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDeleted;
}
