package com.buleqr.service;

import com.buleqr.pojo.PageDomain;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.Picture;

public interface PictureService {

    /**
     * add
     * @param picture 参数
     * @return 结果
     */
    Boolean addPicture(Picture picture);

    /**
     * update
     * @param picture 参数
     * @return 结果
     */
    Boolean updatePicture(Picture picture);

    /**
     * 加载轮播图列表
     * @param query
     * @param pictureStatus
     * @return 列表
     */
    PageList<Picture> queryPictureList(PageDomain query,Integer pictureStatus);
}
