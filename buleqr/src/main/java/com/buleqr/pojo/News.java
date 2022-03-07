package com.buleqr.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author buleqr
 */
@Data
@TableName("news")
public class News {
    @TableId(type = IdType.AUTO)
    private Long newsId;
    @NotNull(message = "标题不能为空")
    private String newsTitle;
    @NotNull(message = "内容不能为空")
    private String newsContent;
    @NotNull(message = "封面不能为空")
    private String coverImage;
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
     * 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDeleted;
}
