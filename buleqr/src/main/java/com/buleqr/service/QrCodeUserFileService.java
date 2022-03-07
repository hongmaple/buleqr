package com.buleqr.service;

import com.buleqr.dto.request.NewsQuery;
import com.buleqr.dto.request.QrcodeQuery;
import com.buleqr.dto.response.NewsRowVo;
import com.buleqr.pojo.PageList;
import com.buleqr.pojo.QrCodeUserFile;

import java.util.List;

public interface QrCodeUserFileService {

    /**
     * 生成唯一二维码文件并保存到数据库，返回文件路径
     * @param num
     * @return
     */
    String createQrCodeFile(int num);

    /**
     * 加载二维码文件列表
     * @param query 参数
     * @return 结果
     */
    PageList<QrCodeUserFile> ListQrCodeFile(QrcodeQuery query);

    /**
     * 申请绑定二维码
     * @param qrUuid
     * @return
     */
    QrCodeUserFile bindingRegister(String qrUuid);

}
