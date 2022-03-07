package com.buleqr.service.impl;

import com.buleqr.dto.request.SysNoticeQuery;
import com.buleqr.exception.ServiceException;
import com.buleqr.mapper.SysNoticeMapper;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.SysNotice;
import com.buleqr.security.JwtUser;
import com.buleqr.service.ISysNoticeService;
import com.buleqr.utils.security.SecurityUtils;
import com.buleqr.utils.string.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 公告 服务层实现
 * 
 * @author buleqr
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService
{
    @Autowired
    private SysNoticeMapper noticeMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param query 公告信息
     * @return 公告集合
     */
    @Override
    public PageList<SysNotice> selectNoticeList(SysNoticeQuery query)
    {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<SysNotice> sysNotices = noticeMapper.selectNoticeList(query);
        return PageList.of(PageInfo.of(sysNotices));
    }

    @Override
    public List<SysNotice> selectNoticeList() {
        SysNoticeQuery query = new SysNoticeQuery();
        List<SysNotice> sysNotices = noticeMapper.selectNoticeList(query);
        return  sysNotices;
    }

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int insertNotice(SysNotice notice)
    {
        // 获取登录用户
        JwtUser user = SecurityUtils.getLoginUser();
        if (Objects.isNull(user)) {
            throw new ServiceException("请先登陆",400);
        }
        notice.setCreatorId(user.getId());
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public int deleteNoticeById(Long noticeId) {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    /**
     * 删除公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(String ids)
    {
        return noticeMapper.deleteNoticeByIds(Convert.toStrArray(ids));
    }

    @Override
    public SysNotice getSysNoticeById(Long noticeId) {
        return noticeMapper.selectById(noticeId);
    }
}