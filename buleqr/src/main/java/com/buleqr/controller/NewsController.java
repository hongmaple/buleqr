package com.buleqr.controller;

import com.buleqr.dto.request.NewsQuery;
import com.buleqr.pojo.AjaxResult;
import com.buleqr.pojo.News;
import com.buleqr.pojo.PageList;
import com.buleqr.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 新闻
 *
 * @author buleqr
 */
@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    /**
     * 添加新闻
     * @param news 新闻
     * @return 结果
     */
    @PostMapping()
    @PreAuthorize("hasAnyAuthority('admin')")
    public AjaxResult addNews(@Valid @RequestBody News news) {
        AjaxResult ajaxResult = AjaxResult.success("添加新闻成功", newsService.addNews(news));
        return ajaxResult;
    }

    /**
     * 修改
     * @param news 新闻
     * @return 结果
     */
    @PutMapping
    @PreAuthorize("hasAnyAuthority('admin')")
    public AjaxResult updateNews(@Valid @RequestBody News news) {
        AjaxResult ajaxResult = AjaxResult.success("修改新闻成功", newsService.updateNews(news));
        return ajaxResult;
    }

    /**
     * 删除文章
     * @param newsId
     * @return
     */
    @DeleteMapping("/{newsId}")
    @PreAuthorize("hasAnyAuthority('admin')")
    public AjaxResult deleteNews(@PathVariable Long newsId) {
        AjaxResult ajaxResult = AjaxResult.success("删除新闻成功", newsService.deleteNews(newsId));
        return ajaxResult;
    }

    /**
     * 根据id获取文章详情
     * @param newsId 文章id
     * @return 详情
     */
    @GetMapping("/{newsId}")
    public AjaxResult getNewsById(@PathVariable Long newsId) {
        AjaxResult ajaxResult = AjaxResult.success( newsService.getNewsById(newsId));
        return ajaxResult;
    }

    /**
     * 加载文章列表
     * @param query 参数
     * @return 结果
     */
    @PostMapping("/list")
    public AjaxResult ListNews(@RequestBody NewsQuery query) {
        AjaxResult ajaxResult = AjaxResult.success(newsService.ListNews(query));
        return ajaxResult;
    }
}
