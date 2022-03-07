package com.buleqr.service;

import com.buleqr.dto.request.SysNoticeQuery;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.SysNotice;

import java.util.List;

/**
 * 公告 服务层
 * 
 * @author buleqr
 */
public interface ISysNoticeService
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询公告列表
     * 
     * @param query 公告信息
     * @return 公告集合
     */
    public PageList<SysNotice> selectNoticeList(SysNoticeQuery query);

    /**
     * 查询公告列表
     *
     * @return 公告集合
     */
    public List<SysNotice> selectNoticeList();

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 删除公告信息
     * @param noticeId 需要删除的数据ID
     * @return 结果
     */
    int deleteNoticeById(Long noticeId);

    /**
     * 删除公告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String ids);

    /**
     * 获取公告详情
     * @param noticeId
     * @return
     */
    SysNotice getSysNoticeById(Long noticeId);
}
