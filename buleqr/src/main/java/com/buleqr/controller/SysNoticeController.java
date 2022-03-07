package com.buleqr.controller;


import com.buleqr.dto.request.SysNoticeQuery;
import com.buleqr.pojo.AjaxResult;
import com.buleqr.pojo.SysNotice;
import com.buleqr.service.ISysNoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 实时公告
 *
 * @author buleqr
 */
@Slf4j
@RestController
@RequestMapping("/notice")
public class SysNoticeController {
    private final ISysNoticeService iSysNoticeService;

    public SysNoticeController(ISysNoticeService iSysNoticeService) {
        this.iSysNoticeService = iSysNoticeService;
    }

    @PostMapping("/list")
    public AjaxResult selectNoticeList(@RequestBody SysNoticeQuery query) {
        AjaxResult ajaxResult = AjaxResult.success(iSysNoticeService.selectNoticeList(query));
        return ajaxResult;
    }

    /**
     * 查询公告列表
     *
     * @return 公告集合
     */
    @GetMapping("/list")
    public AjaxResult selectNoticeList() {
        AjaxResult ajaxResult = AjaxResult.success(iSysNoticeService.selectNoticeList());
        return ajaxResult;
    }

    /**
     * 新增公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @PostMapping
    @PreAuthorize("hasAnyAuthority('admin')")
    public AjaxResult insertNotice(@Valid @RequestBody SysNotice notice) {
        AjaxResult ajaxResult = AjaxResult.success(iSysNoticeService.insertNotice(notice));
        return ajaxResult;
    }

    /**
     * 修改公告
     *
     * @param notice 公告信息
     * @return 结果
     */
    @PutMapping
    @PreAuthorize("hasAnyAuthority('admin')")
    public AjaxResult updateNotice(@Valid @RequestBody SysNotice notice) {
        AjaxResult ajaxResult = AjaxResult.success(iSysNoticeService.updateNotice(notice));
        return ajaxResult;
    }

    /**
     * 删除公告信息
     * @param noticeId 需要删除的数据ID
     * @return 结果
     */
    @PreAuthorize("hasAnyAuthority('admin')")
    @DeleteMapping("/{noticeId}")
    public AjaxResult deleteNoticeById(@PathVariable Long noticeId) {
        AjaxResult ajaxResult = AjaxResult.success(iSysNoticeService.deleteNoticeById(noticeId));
        return ajaxResult;
    }

    /**
     * 获取公告详情
     * @param noticeId
     * @return
     */
    @GetMapping("/{noticeId}")
    public AjaxResult getSysNoticeById(@PathVariable Long noticeId) {
        AjaxResult ajaxResult = AjaxResult.success(iSysNoticeService.getSysNoticeById(noticeId));
        return ajaxResult;
    }

}
