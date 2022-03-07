package com.buleqr.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buleqr.dao.PunchCardDao;
import com.buleqr.mapper.PunchCardMapper;
import com.buleqr.pojo.PunchCard;
import org.springframework.stereotype.Repository;

/**
 * @author buleqr
 */
@Repository
public class PunchCardDaoImpl extends ServiceImpl<PunchCardMapper, PunchCard> implements PunchCardDao {
}
