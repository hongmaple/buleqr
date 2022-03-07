package com.buleqr.dto.request;

import com.buleqr.pojo.PageDomain;
import lombok.Data;

@Data
public class SysNoticeQuery extends PageDomain {
    /** 公告标题 */
    private String noticeTitle;

    /** 公告类型（1通知 2公告） */
    private String noticeType;

    /**
     * 创建者
     */
    private Long creatorId;

}
