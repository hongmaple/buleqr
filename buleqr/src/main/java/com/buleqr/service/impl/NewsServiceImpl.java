package com.buleqr.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buleqr.dao.NewsDao;
import com.buleqr.dto.request.NewsQuery;
import com.buleqr.dto.response.NewsRowVo;
import com.buleqr.exception.ServiceException;
import com.buleqr.pojo.News;
import com.buleqr.pojo.PageList;
import com.buleqr.security.JwtUser;
import com.buleqr.service.NewsService;
import com.buleqr.utils.security.SecurityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsDao newsDao;
    private final ModelMapper modelMapper;

    public NewsServiceImpl(NewsDao newsDao, ModelMapper modelMapper) {
        this.newsDao = newsDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addNews(News news) {
        // 获取登录用户
        JwtUser user = SecurityUtils.getLoginUser();
        if (Objects.isNull(user)) {
            throw new ServiceException("请先登陆",400);
        }
        news.setCreatorId(user.getId());
        return newsDao.save(news);
    }

    @Override
    public boolean updateNews(News news) {
        if (newsDao.lambdaQuery().eq(News::getNewsId,news.getNewsId()).count()==0) {
            throw new ServiceException("修改失败,该文章不存在",400);
        }
        boolean isOk = newsDao.updateById(news);
        if (!isOk) {
            throw new ServiceException("修改失败",400);
        }
        return true;
    }

    @Override
    public boolean deleteNews(Long newsId) {
        if (newsDao.lambdaQuery().eq(News::getNewsId,newsId).count()==0) {
            throw new ServiceException("删除失败,该文章不存在",400);
        }
        boolean isOk = newsDao.removeById(newsId);
        if (!isOk) {
            throw new ServiceException("删除失败",400);
        }
        return true;
    }

    @Override
    public News getNewsById(Long newsId) {
        return newsDao.getById(newsId);
    }

    @Override
    public PageList<NewsRowVo> ListNews(NewsQuery query) {
        LambdaQueryChainWrapper<News> lambdaQuery = newsDao.lambdaQuery();
        if (query.getNewsContent()!=null) {
            lambdaQuery.like(News::getNewsContent,query.getNewsContent());
        }
        if (query.getNewsTitle()!=null) {
            lambdaQuery.like(News::getNewsTitle,query.getNewsTitle());
        }
        if (query.getOrderByColumn()!=null&&query.getOrderByColumn().equals("updateTime")) {
            if (query.getIsAsc()!=null&&query.getIsAsc().equals("asc")) {
                lambdaQuery.orderByAsc(News::getUpdateTime);
            }else {
                lambdaQuery.orderByDesc(News::getUpdateTime);
            }
        }
        if (query.getOrderByColumn()!=null&&query.getOrderByColumn().equals("createTime")) {
            if (query.getIsAsc()!=null&&query.getIsAsc().equals("asc")) {
                lambdaQuery.orderByAsc(News::getCreateTime);
            }else {
                lambdaQuery.orderByDesc(News::getCreateTime);
            }
        }
        Page<News> page = lambdaQuery.page(new Page<>(query.getPageNum(), query.getPageSize()));
        List<NewsRowVo> rowVos = new LinkedList<>();
        page.getRecords().forEach((item) -> {
            NewsRowVo rowVo = modelMapper.map(item, NewsRowVo.class);
            rowVos.add(rowVo);
        });
        return PageList.of(rowVos,page);
    }
}
