package com.buleqr.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.buleqr.dao.PunchCardDao;
import com.buleqr.exception.ServiceException;
import com.buleqr.mapper.PunchCardMapper;
import com.buleqr.pojo.PunchCard;
import com.buleqr.security.JwtUser;
import com.buleqr.service.PunchCardService;
import com.buleqr.utils.security.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author buleqr
 */
@Service
public class PunchCardServiceImpl implements PunchCardService {
    private final PunchCardDao punchCardDao;

    public PunchCardServiceImpl(PunchCardDao punchCardDao) {
        this.punchCardDao = punchCardDao;
    }

    @Override
    public boolean punchCard() {
        // 获取登录用户
        JwtUser user = SecurityUtils.getLoginUser();
        if (Objects.isNull(user)) {
            throw new ServiceException("请先登陆",400);
        }
        Date date = new Date();
        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
        Integer count = punchCardDao.lambdaQuery()
                .eq(PunchCard::getCreatorId, user.getId())
                .between(PunchCard::getCreateTime, beginOfDay, endOfDay)
                .count();
        if (count>=3) {
            throw new ServiceException("今天打卡次数已达上限",400);
        }
        PunchCard punchCard = ((PunchCardMapper) punchCardDao.getBaseMapper()).queryLastPunch(user.getId());
        //新增打卡记录
        PunchCard addpunchCard = new PunchCard();
        addpunchCard.setCreatorId(user.getId());
        addpunchCard.setCreateTime(date);
        if (Objects.isNull(punchCard)) {
            if(!punchCardDao.save(addpunchCard)) {
                throw new ServiceException("打卡失败",400);
            }
            return true;
        }else {
            long betweenDay = DateUtil.between(punchCard.getCreateTime(), date, DateUnit.HOUR);
            if (betweenDay>1L) {
                if(!punchCardDao.save(addpunchCard)) {
                    throw new ServiceException("打卡失败",400);
                }
                return true;
            }
            throw new ServiceException("打卡失败,据上次打卡未超过1小时",400);
        }
    }
}
