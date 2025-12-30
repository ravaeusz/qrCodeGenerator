package com.qrcode.QrCodeGenerator.infra.gateway;

import com.google.zxing.WriterException;
import com.qrcode.QrCodeGenerator.core.entities.QrCode;
import com.qrcode.QrCodeGenerator.core.gateway.QrCodeGateway;
import com.qrcode.QrCodeGenerator.infra.exception.ConflictException;
import com.qrcode.QrCodeGenerator.infra.mapper.QrCodeMapper;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeEntity;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeGenerator;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
;
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
    public byte[] CreateQrCode(String link) {
        QrCodeEntity existing = qrCodeRepository.findByLink(link);
        if (existing != null) {
            throw new ConflictException("QrCode já gerado");
        }
        byte[] image;
        try {
            image = qrCodeGenerator.generateQRCode(link);
        } catch (WriterException | IOException e) {
            throw new ConflictException("Erro ao gerar QR Code");
        }

        QrCode qrCode = new QrCode(null, link, image);

        qrCodeRepository.save(mapper.toEntity(qrCode));

        return image;
    }

    @Override
    public QrCode GetQrCode(String link) {
    var entity = qrCodeRepository.findByLink(link);
    if (entity == null){
        return null;
    }
    return mapper.toDomain(entity);
    }
}
