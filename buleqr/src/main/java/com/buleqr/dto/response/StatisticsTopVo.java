package com.buleqr.dto.response;


import lombok.Data;

/**
 * @author buleqr
 */
@Data
public class StatisticsTopVo {
    private Integer totalNumberRegistrants;
    private Double menThan;
    private Double womenThan;
    private Integer newRegistrations;
}
