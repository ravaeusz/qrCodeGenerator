package com.qrcode.QrCodeGenerator.core.usecases;

import com.qrcode.QrCodeGenerator.core.entities.QrCode;
import com.qrcode.QrCodeGenerator.core.gateway.QrCodeGateway;

public class GetQrCodeByLinkUseCaseImpl implements GetQrCodeByLinkUseCase{

    private final QrCodeGateway qrCodeGateway;

    public GetQrCodeByLinkUseCaseImpl(QrCodeGateway qrCodeGateway) {
        this.qrCodeGateway = qrCodeGateway;
    }

    @Override
    public QrCode GetQrCode(String link) {
       return qrCodeGateway.GetQrCode(link);
    }
}
