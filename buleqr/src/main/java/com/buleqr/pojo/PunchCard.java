package com.buleqr.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 打卡记录
 * @author buleqr
 */
@Data
@TableName("punch_card")
public class PunchCard {
    @TableId(type = IdType.AUTO)
    private Long punchCardId;
    /**
     * 打卡人
     */
    private Long creatorId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDeleted;

}
