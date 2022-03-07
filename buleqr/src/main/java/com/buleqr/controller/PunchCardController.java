package com.buleqr.controller;

import com.buleqr.pojo.AjaxResult;
import com.buleqr.service.PunchCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打卡
 *
 * @author buleqr
 */
@Slf4j
@RestController()
@RequestMapping("/PunchCard")
public class PunchCardController {

    private final PunchCardService punchCardService;

    public PunchCardController(PunchCardService punchCardService) {
        this.punchCardService = punchCardService;
    }

    /**
     * 打卡
     * @return 结果
     */
    @PostMapping
    public AjaxResult punchCard() {
        AjaxResult ajaxResult = AjaxResult.success("打卡成功",punchCardService.punchCard());
        return ajaxResult;
    }
}
