package com.buleqr.dto.request;

import com.buleqr.pojo.PageDomain;
import lombok.Data;

@Data
public class NewsQuery extends PageDomain {
    private String newsTitle;
    private String newsContent;
    private String coverImage;
}
