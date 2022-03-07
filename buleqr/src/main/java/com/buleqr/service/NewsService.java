package com.buleqr.service;

import com.buleqr.dto.request.NewsQuery;
import com.buleqr.dto.response.NewsRowVo;
import com.buleqr.pojo.News;
import com.buleqr.pojo.PageDomain;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.User;

public interface NewsService {

    /**
     * 添加新闻
     * @param news 新闻
     * @return 结果
     */
    boolean addNews(News news);

    /**
     * 修改
     * @param news 新闻
     * @return 结果
     */
    boolean updateNews(News news);

    /**
     * 删除文章
     * @param newsId
     * @return
     */
    boolean deleteNews(Long newsId);

    /**
     * 根据id获取文章详情
     * @param newsId 文章id
     * @return 详情
     */
    News getNewsById(Long newsId);

    /**
     * 加载文章列表
     * @param query 参数
     * @return 结果
     */
    PageList<NewsRowVo> ListNews(NewsQuery query);
}
