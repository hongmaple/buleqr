package com.buleqr.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buleqr.dao.*;
import com.buleqr.dto.response.AgeAnalysisVo;
import com.buleqr.dto.response.RankingListVo;
import com.buleqr.dto.response.StatisticsTopVo;
import com.buleqr.pojo.PageDomain;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.User;
import com.buleqr.security.JwtUser;
import com.buleqr.service.StatisticsService;
import com.buleqr.utils.security.SecurityUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @author buleqr
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final UserDao userDao;

    public StatisticsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public StatisticsTopVo getStatisticsTopVo() {
        StatisticsTopVo statisticsTopVo = new StatisticsTopVo();
        statisticsTopVo.setTotalNumberRegistrants(userDao.lambdaQuery().count());
        Integer menCount = userDao.lambdaQuery().eq(User::getSex, "男").count();
        Integer womenCount = userDao.lambdaQuery().eq(User::getSex, "女").count();
        statisticsTopVo.setMenThan(Chufa(menCount,statisticsTopVo.getTotalNumberRegistrants())*100);
        statisticsTopVo.setWomenThan(Chufa(womenCount,statisticsTopVo.getTotalNumberRegistrants())*100);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        statisticsTopVo.setNewRegistrations(userDao.lambdaQuery().between(User::getCreateTime,today_start,today_end).count());
        return statisticsTopVo;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static double Chufa(int a,int b) {
        double jieguo = new BigDecimal((float)a/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return jieguo;
    }

    @Override
    public List<AgeAnalysisVo> getAgeAnalysisVo() {
        List<AgeAnalysisVo> ageAnalysisVos = new ArrayList<>();
        AgeAnalysisVo ageAnalysisVo = new AgeAnalysisVo();
        ageAnalysisVo.setName("15~25岁");
        ageAnalysisVo.setValue(userDao.lambdaQuery().between(User::getAge,15,25).count());
        if (ageAnalysisVo.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo);
        }
        AgeAnalysisVo ageAnalysisVo1 = new AgeAnalysisVo();
        ageAnalysisVo1.setName("25~35岁");
        ageAnalysisVo1.setValue(userDao.lambdaQuery().between(User::getAge,25,35).count());
        if (ageAnalysisVo1.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo1);
        }
        AgeAnalysisVo ageAnalysisVo2 = new AgeAnalysisVo();
        ageAnalysisVo2.setName("35~45岁");
        ageAnalysisVo2.setValue(userDao.lambdaQuery().between(User::getAge,35,45).count());
        if (ageAnalysisVo2.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo2);
        }
        AgeAnalysisVo ageAnalysisVo3 = new AgeAnalysisVo();
        ageAnalysisVo3.setName("45~55岁");
        ageAnalysisVo3.setValue(userDao.lambdaQuery().between(User::getAge,45,55).count());
        if (ageAnalysisVo3.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo3);
        }
        AgeAnalysisVo ageAnalysisVo4 = new AgeAnalysisVo();
        ageAnalysisVo4.setName("55~65岁");
        ageAnalysisVo4.setValue(userDao.lambdaQuery().between(User::getAge,55,65).count());
        if (ageAnalysisVo4.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo4);
        }
        AgeAnalysisVo ageAnalysisVo5 = new AgeAnalysisVo();
        ageAnalysisVo5.setName("65~75岁");
        ageAnalysisVo5.setValue(userDao.lambdaQuery().between(User::getAge,65,75).count());
        if (ageAnalysisVo5.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo5);
        }
        AgeAnalysisVo ageAnalysisVo6 = new AgeAnalysisVo();
        ageAnalysisVo6.setName("75~85岁");
        ageAnalysisVo6.setValue(userDao.lambdaQuery().between(User::getAge,75,85).count());
        if (ageAnalysisVo6.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo6);
        }
        AgeAnalysisVo ageAnalysisVo7 = new AgeAnalysisVo();
        ageAnalysisVo7.setName("85岁以上");
        ageAnalysisVo7.setValue(userDao.lambdaQuery().between(User::getAge,85,100000).count());
        if (ageAnalysisVo7.getValue()>0) {
            ageAnalysisVos.add(ageAnalysisVo7);
        }
        return ageAnalysisVos;
    }
}
