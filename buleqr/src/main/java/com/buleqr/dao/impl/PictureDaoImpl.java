package com.buleqr.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buleqr.dao.PictureDao;
import com.buleqr.mapper.PictureMapper;
import com.buleqr.pojo.Picture;
import org.springframework.stereotype.Repository;

/**
 * @author buleqr
 */
@Repository
public class PictureDaoImpl extends ServiceImpl<PictureMapper, Picture> implements PictureDao {
}
