package com.qrcode.QrCodeGenerator.infra.mapper;

import com.qrcode.QrCodeGenerator.core.entities.QrCode;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeEntity;

public class QrCodeMapper {

    public QrCodeEntity toEntity(QrCode qrCode){
        return new QrCodeEntity(
                qrCode.id(),
                qrCode.link(),
                qrCode.image()
        );
    }

    public QrCode toDomain(QrCodeEntity qrCodeEntity){
        return new QrCode(
                qrCodeEntity.getId(),
                qrCodeEntity.getLink(),
                qrCodeEntity.getImage()
        );
    }

}
