package com.qrcode.QrCodeGenerator.infra.gateway;

import com.google.zxing.WriterException;
import com.qrcode.QrCodeGenerator.core.gateway.QrCodeGateway;
import com.qrcode.QrCodeGenerator.infra.mapper.QrCodeMapper;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeEntity;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeGenerator;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeRepository;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.awt.desktop.QuitResponse;
import java.io.IOException;


public class QrCodeGatewayRepository implements QrCodeGateway {

    private final QrCodeMapper mapper;
    private final QrCodeRepository qrCodeRepository;
    private final QrCodeGenerator qrCodeGenerator;

    public QrCodeGatewayRepository(QrCodeMapper mapper, QrCodeRepository qrCodeRepository, QrCodeGenerator qrCodeGenerator) {
        this.mapper = mapper;
        this.qrCodeRepository = qrCodeRepository;
        this.qrCodeGenerator = qrCodeGenerator;
    }



    @Override
    public byte[] CreateQrCode(String link) {byte[] image = null;
        try {
            image = qrCodeGenerator.generateQRCode(link);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }
}
