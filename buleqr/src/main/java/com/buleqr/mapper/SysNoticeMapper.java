package com.buleqr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buleqr.dto.request.SysNoticeQuery;
import com.buleqr.pojo.SysNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公告 数据层
 * 
 * @author buleqr
 */
public interface SysNoticeMapper extends BaseMapper<SysNotice>  {
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
    public List<SysNotice> selectNoticeList(SysNoticeQuery query);

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

    int deleteNoticeById(@Param("noticeId") Long noticeId);

    /**
     * 批量删除公告
     *
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeByIds(String[] noticeIds);

}