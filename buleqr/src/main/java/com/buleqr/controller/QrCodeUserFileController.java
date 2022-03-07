package com.buleqr.controller;


import com.buleqr.config.BuleqrConfig;
import com.buleqr.dto.request.QrcodeQuery;
import com.buleqr.enums.QrCodeState;
import com.buleqr.exception.ServiceException;
import com.buleqr.pojo.AjaxResult;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.QrCodeUserFile;
import com.buleqr.service.QrCodeUserFileService;
import com.buleqr.utils.file.FileUploadUtils;
import com.buleqr.utils.file.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 二维码
 *
 * @author buleqr
 */
@Slf4j
@RestController
@RequestMapping("/QrCode")
public class QrCodeUserFileController {

    private final QrCodeUserFileService qrCodeUserFileService;

    public QrCodeUserFileController(QrCodeUserFileService qrCodeUserFileService) {
        this.qrCodeUserFileService = qrCodeUserFileService;
    }

    /**
     * 生成唯一二维码文件并保存到数据库，并下载文件
     * @param num
     * @return
     */
    @GetMapping("createQrCodeFile")
    public void createQrCodeFile(int num, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            String filePath = qrCodeUserFileService.createQrCodeFile(num);
            String realFileName = System.currentTimeMillis() + filePath.substring(filePath.indexOf("_") + 1);
//            String filePath = BuleqrConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
            throw new ServiceException("二维码生成失败",400);
        }
    }

    /**
     * 加载二维码文件列表
     * @param query 参数
     * @return 结果
     */
    @PostMapping("/list")
    public AjaxResult ListQrCodeFile(@RequestBody QrcodeQuery query) {
        AjaxResult ajaxResult = AjaxResult.success(qrCodeUserFileService.ListQrCodeFile(query));
        return ajaxResult;
    }

    /**
     * 申请绑定二维码
     * @param qrUuid
     * @return
     */
//    @GetMapping("/{qrUuid}")
//    public AjaxResult bindingRegister(@PathVariable String qrUuid) {
//        QrCodeUserFile qrCodeUserFile = qrCodeUserFileService.bindingRegister(qrUuid);
//        AjaxResult ajaxResult = AjaxResult.success(qrCodeUserFile);
//        return ajaxResult;
//    }
    @PostMapping("/{qrUuid}")
    public AjaxResult bindingRegister(@PathVariable String qrUuid) {
        QrCodeUserFile qrCodeUserFile = qrCodeUserFileService.bindingRegister(qrUuid);
        AjaxResult ajaxResult = AjaxResult.success(qrCodeUserFile);
        return ajaxResult;
    }

    /**
     * 生成唯一二维码文件并保存到数据库，并下载文件
     * @return
     */
    @GetMapping("downLoad")
    public void createQrCodeFile(String qrUuid,HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            QrCodeUserFile qrCodeUserFile = qrCodeUserFileService.bindingRegister(qrUuid);
            String realFileName = System.currentTimeMillis() + qrUuid.substring(qrUuid.indexOf("_") + 1);
            String filePath = BuleqrConfig.getProfile() + qrCodeUserFile.getQrUrl().replace("/profile","");
            String extension = FilenameUtils.getExtension(qrCodeUserFile.getQrUrl());
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName+"."+extension);
            FileUtils.writeBytes(filePath, response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
            throw new ServiceException("下载文件失败",400);
        }
    }

}
