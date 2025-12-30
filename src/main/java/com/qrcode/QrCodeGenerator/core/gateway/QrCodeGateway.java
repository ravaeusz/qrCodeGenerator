package com.qrcode.QrCodeGenerator.core.gateway;


import com.qrcode.QrCodeGenerator.core.entities.QrCode;

public interface QrCodeGateway {

    public byte[] CreateQrCode(String link);

    public QrCode GetQrCode(String link);


}
