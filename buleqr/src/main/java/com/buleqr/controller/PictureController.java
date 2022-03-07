package com.buleqr.controller;

import com.buleqr.pojo.AjaxResult;
import com.buleqr.pojo.PageDomain;
import com.buleqr.pojo.Picture;
import com.buleqr.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 轮播图
 *
 * @author buleqr
 */
@Slf4j
@RestController()
@RequestMapping("/picture")
public class PictureController {
    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    /**
     * add
     * @param picture 参数
     * @return 结果
     */
    @PreAuthorize("hasAnyAuthority('admin')")
    @PostMapping
    public AjaxResult addPicture(@Valid @RequestBody Picture picture) {
        AjaxResult ajaxResult = AjaxResult.success("添加成功",pictureService.addPicture(picture));
        return ajaxResult;
    }

    /**
     * update
     * @param picture 参数
     * @return 结果
     */
    @PreAuthorize("hasAnyAuthority('admin')")
    @PutMapping
    public AjaxResult updatePicture(@Valid @RequestBody Picture picture) {
        AjaxResult ajaxResult = AjaxResult.success("修改成功",pictureService.updatePicture(picture));
        return ajaxResult;
    }

    /**
     * 加载轮播图列表
     * @param query
     * @return 列表
     */
    @PreAuthorize("hasAnyAuthority('admin')")
    @PostMapping("/query")
    public AjaxResult queryPictureList(@RequestBody PageDomain query) {
        AjaxResult ajaxResult = AjaxResult.success(pictureService.queryPictureList(query,null));
        return ajaxResult;
    }

    /**
     * 加载轮播图列表
     * @param query
     * @return 列表
     */
    @PostMapping("/query/{pictureStatus}")
    public AjaxResult queryPictureList(@RequestBody PageDomain query,@PathVariable Integer pictureStatus) {
        AjaxResult ajaxResult = AjaxResult.success(pictureService.queryPictureList(query,pictureStatus));
        return ajaxResult;
    }
}
