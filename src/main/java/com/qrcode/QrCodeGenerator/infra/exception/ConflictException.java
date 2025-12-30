package com.qrcode.QrCodeGenerator.infra.exception;

public class ConflictException extends RuntimeException{

    public ConflictException(String message){
        super(message);
    }
}
