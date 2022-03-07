package com.buleqr.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buleqr.dao.PictureDao;
import com.buleqr.exception.ServiceException;
import com.buleqr.pojo.PageDomain;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.Picture;
import com.buleqr.security.JwtUser;
import com.buleqr.service.PictureService;
import com.buleqr.utils.security.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author buleqr
 */
@Service
public class PictureServiceImpl implements PictureService {

    private final PictureDao pictureDao;

    public PictureServiceImpl(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    @Override
    public Boolean addPicture(Picture picture) {
        // 获取登录用户
        JwtUser user = SecurityUtils.getLoginUser();
        if (Objects.isNull(user)) {
            throw new ServiceException("请先登陆",400);
        }
        picture.setCreatorId(user.getId());
        picture.setCreateTime(new Date());
        Boolean isOk = pictureDao.save(picture);
        if (!isOk) {
            throw new ServiceException("新增失败",400);
        }
        return true;
    }

    @Override
    public Boolean updatePicture(Picture picture) {
        Boolean isOk = pictureDao.updateById(picture);
        if (!isOk) {
            throw new ServiceException("修改失败",400);
        }
        return true;
    }

    @Override
    public PageList<Picture> queryPictureList(PageDomain query,Integer pictureStatus) {
        LambdaQueryChainWrapper<Picture> lambdaQuery = pictureDao.lambdaQuery();
        if (pictureStatus!=null) {
            lambdaQuery.eq(Picture::getPictureStatus,pictureStatus);
        }
        lambdaQuery.orderByAsc(Picture::getPictureIndex);
        Page<Picture> page = lambdaQuery.page(new Page<>(query.getPageNum(), query.getPageSize()));
        return PageList.of(page.getRecords(),page);
    }
}
