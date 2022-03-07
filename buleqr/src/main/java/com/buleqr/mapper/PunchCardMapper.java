package com.buleqr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buleqr.pojo.PunchCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author buleqr
 */
@Repository
public interface PunchCardMapper extends BaseMapper<PunchCard>   {

    PunchCard queryLastPunch(@Param("creatorId") Long creatorId);

}