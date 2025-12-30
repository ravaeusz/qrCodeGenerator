package com.qrcode.QrCodeGenerator.core.usecases;


import com.qrcode.QrCodeGenerator.core.gateway.QrCodeGateway;

public class CreateQrCodeUseCaseImpl implements CreateQrCodeUseCase{

    private final QrCodeGateway qrCodeGateway;

    public CreateQrCodeUseCaseImpl(QrCodeGateway qrCodeGateway) {
        this.qrCodeGateway = qrCodeGateway;
    }

    @Override
    public byte[] execute(String link) {
        byte[] image = qrCodeGateway.CreateQrCode(link);


        return image;

    }
}
