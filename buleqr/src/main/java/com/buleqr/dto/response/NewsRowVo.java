package com.buleqr.dto.response;
import lombok.Data;

import java.util.Date;

@Data
public class NewsRowVo {
    private Long newsId;
    private String newsTitle;
    private String newsContent;
    private String coverImage;
    private String description;
    private Long creatorId;
    private Date createTime;
    private Date updateTime;

}
