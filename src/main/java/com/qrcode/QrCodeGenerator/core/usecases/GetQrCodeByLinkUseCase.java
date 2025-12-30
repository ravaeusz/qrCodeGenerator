package com.qrcode.QrCodeGenerator.core.usecases;

import com.qrcode.QrCodeGenerator.core.entities.QrCode;

public interface GetQrCodeByLinkUseCase {

    public QrCode GetQrCode(String link);

}
