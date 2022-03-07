package com.buleqr.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buleqr.dao.NewsDao;
import com.buleqr.mapper.NewsMapper;
import com.buleqr.pojo.News;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends ServiceImpl<NewsMapper, News> implements NewsDao {
}
