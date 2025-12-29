package com.qrcode.QrCodeGenerator.infra.persistence;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QrCodeGenerator {


    public byte[] generateQRCode(String link) throws WriterException, IOException {

            if (link == null || link.isBlank()) {
                throw new IllegalArgumentException("Link inválido para geração do QR Code");
            }
            try {
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
                BitMatrix bitMatrix = qrCodeWriter.encode(link, BarcodeFormat.QR_CODE, 255, 255);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }catch (WriterException | IOException e){
                throw new RuntimeException("Erro ao gravar", e);
            }

    }




}
