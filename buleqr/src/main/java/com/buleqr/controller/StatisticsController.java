package com.buleqr.controller;

import com.buleqr.dto.response.AgeAnalysisVo;
import com.buleqr.dto.response.StatisticsTopVo;
import com.buleqr.pojo.AjaxResult;
import com.buleqr.pojo.PageDomain;
import com.buleqr.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据统计
 *
 * @author buleqr
 */
@Slf4j
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    /**
     * 首页 top 统计
     * @return 统计数据
     */
    @GetMapping("/top")
    public StatisticsTopVo getStatisticsTopVo() {
        return statisticsService.getStatisticsTopVo();
    }

    /**
     * 首页年龄分布统计
     * @return 年龄分布统计
     */
    @GetMapping("/ageAnalysis")
    public List<AgeAnalysisVo> getAgeAnalysisVo() {
        return statisticsService.getAgeAnalysisVo();
    }
}
