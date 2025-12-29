package com.qrcode.QrCodeGenerator.core.entities;

public record QrCode(
        Long id,
        String link,
        byte[] image
) {
}
