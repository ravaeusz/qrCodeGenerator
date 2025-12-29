package com.qrcode.QrCodeGenerator.core.usecases;

public interface CreateQrCodeUseCase {

    public byte[] execute(String link);
}
