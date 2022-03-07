package com.buleqr.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 通知公告表 sys_notice
 * 
 * @author buleqr
 */
@Data
@TableName("sys_notice")
public class SysNotice {
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    @TableId(type = IdType.AUTO)
    private Long noticeId;

    /** 公告标题 */
    @NotNull(message = "公告标题不能为空")
    private String noticeTitle;

    /** 公告类型（1通知 2公告） */
    private String noticeType;

    /** 公告内容 */
    @NotNull(message = "公告内容不能为空")
    private String noticeContent;

    /** 公告状态（0正常 1关闭） */
    private String status;

    /**
     * 创建者
     */
    private Long creatorId;

    /**
     * 更新
     */
    private Long updateId;

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
     * 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDeleted;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeType", getNoticeType())
            .append("noticeContent", getNoticeContent())
            .append("status", getStatus())
            .append("creatorId", getCreatorId())
            .append("createTime", getCreateTime())
            .append("updateId", getUpdateId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}