package com.buleqr.service.impl;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.buleqr.config.BuleqrConfig;
import com.buleqr.config.QrCodeProperties;
import com.buleqr.config.ServerConfig;
import com.buleqr.dao.QrCodeUserFileDao;
import com.buleqr.dto.request.QrcodeQuery;
import com.buleqr.dto.response.NewsRowVo;
import com.buleqr.enums.QrCodeState;
import com.buleqr.exception.ServiceException;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.QrCodeUserFile;
import com.buleqr.security.JwtUser;
import com.buleqr.service.QrCodeUserFileService;
import com.buleqr.utils.file.FileUploadUtils;
import com.buleqr.utils.security.SecurityUtils;
import com.google.zxing.qrcode.encoder.QRCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Service
public class QrCodeUserFileServiceImpl implements QrCodeUserFileService {
    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private QrCodeProperties qrCodeProperties;

    @Autowired
    private QrCodeUserFileDao qrCodeUserFileDao;

    @Override
    public String createQrCodeFile(int num) {
        // 获取登录用户
        JwtUser user = SecurityUtils.getLoginUser();
        if (Objects.isNull(user)) {
            throw new ServiceException("请先登陆",400);
        }
        String baseDir = BuleqrConfig.getUploadPath()+QrCodeUserFile.FILEDIRECTORY+"/";
        String baseDirUuid = IdUtil.simpleUUID();
        String filePath = baseDir+baseDirUuid;
        String datePath = FileUploadUtils.datePath();
        for (int i=0;i<num;i++) {
            String simpleUUID = IdUtil.simpleUUID();
            // 生成二维码到文件，也可以到流
            // 上传文件路径

            String fileName;
            String extension = ".jpg";

            fileName = datePath + "/" + simpleUUID + "." + extension;

            File desc = null;
            try {
                desc = FileUploadUtils.getAbsoluteFile(filePath, fileName);
            } catch (IOException e) {
                log.debug("二维码生成失败"+e.getMessage());
                break;
            }
            String domainName = qrCodeProperties.getDomainName()+simpleUUID;
            try {
                QrCodeUtil.generate(domainName,
                        QrConfig.create().setImg(qrCodeProperties.getLogoUrl()), //附带logo
                        desc);
            } catch (Exception e) {
                log.debug("二维码生成失败"+e.getMessage());
                break;
            }
            String pathFileName = FileUploadUtils.getPathFileName(filePath, fileName);
            //String url = serverConfig.getUrl() + pathFileName;
            QrCodeUserFile qrCodeUserFile = new QrCodeUserFile();
            qrCodeUserFile.setQrCodeState(QrCodeState.NOT_BOUND);
            qrCodeUserFile.setCreatorId(user.getId());
            qrCodeUserFile.setQrUrl(pathFileName);
            qrCodeUserFile.setQrUuid(simpleUUID);
            try {
                qrCodeUserFileDao.save(qrCodeUserFile);
            } catch (Exception e) {
                log.debug("二维码生成失败"+e.getMessage());
                break;
            }
        }
        String dowLoad = filePath + "/" + datePath;
        String zipPath = baseDir+baseDirUuid+".zip";
        try {
            File zip = ZipUtil.zip(dowLoad,zipPath,true);
        } catch (UtilException e) {
            throw new ServiceException("二维码生成失败",400);
        }
        return zipPath;
    }

    @Override
    public PageList<QrCodeUserFile> ListQrCodeFile(QrcodeQuery query) {
        LambdaQueryChainWrapper<QrCodeUserFile> lambdaQuery = qrCodeUserFileDao.lambdaQuery();
        if (query.getQrCodeState()!=null) {
            lambdaQuery.eq(QrCodeUserFile::getQrCodeState,query.getQrCodeState());
        }
        Page<QrCodeUserFile> page = lambdaQuery.page(new Page<>(query.getPageNum(), query.getPageSize()));
        return PageList.of(page.getRecords(),page);
    }

    @Override
    public QrCodeUserFile bindingRegister(String qrUuid) {
        QrCodeUserFile qrCodeUserFile = qrCodeUserFileDao.lambdaQuery().eq(QrCodeUserFile::getQrUuid, qrUuid).one();
        if (qrCodeUserFile==null) {
            throw new ServiceException("该二维码不存在",400);
        }
        return qrCodeUserFile;
    }
}
