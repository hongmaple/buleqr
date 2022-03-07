package com.buleqr.service;

import com.buleqr.dto.response.AgeAnalysisVo;
import com.buleqr.dto.response.RankingListVo;
import com.buleqr.dto.response.StatisticsTopVo;
import com.buleqr.dto.response.WxinMineInfoVo;
import com.buleqr.pojo.PageDomain;
import com.buleqr.pojo.PageList;

import java.util.List;

/**
 * @author buleqr
 */
public interface StatisticsService {

    /**
     * 首页 top 统计
     * @return 统计数据
     */
    StatisticsTopVo getStatisticsTopVo();

    /**
     * 首页年龄分布统计
     * @return 年龄分布统计
     */
    List<AgeAnalysisVo> getAgeAnalysisVo();
}
