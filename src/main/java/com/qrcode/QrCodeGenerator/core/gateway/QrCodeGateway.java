package com.qrcode.QrCodeGenerator.core.gateway;

import com.google.zxing.WriterException;
import com.qrcode.QrCodeGenerator.core.entities.QrCode;

import java.io.IOException;

public interface QrCodeGateway {

    public byte[] CreateQrCode(String link);


}
