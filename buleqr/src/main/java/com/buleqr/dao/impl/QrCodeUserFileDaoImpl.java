package com.buleqr.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buleqr.dao.QrCodeUserFileDao;
import com.buleqr.mapper.QrCodeUserFileMapper;
import com.buleqr.pojo.QrCodeUserFile;
import org.springframework.stereotype.Repository;

@Repository
public class QrCodeUserFileDaoImpl extends ServiceImpl<QrCodeUserFileMapper, QrCodeUserFile> implements QrCodeUserFileDao {
}
