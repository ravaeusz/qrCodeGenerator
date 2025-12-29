package com.qrcode.QrCodeGenerator.infra.beans;

import com.qrcode.QrCodeGenerator.core.gateway.QrCodeGateway;
import com.qrcode.QrCodeGenerator.core.usecases.CreateQrCodeUseCase;
import com.qrcode.QrCodeGenerator.core.usecases.CreateQrCodeUseCaseImpl;
import com.qrcode.QrCodeGenerator.infra.gateway.QrCodeGatewayRepository;
import com.qrcode.QrCodeGenerator.infra.mapper.QrCodeMapper;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeGenerator;
import com.qrcode.QrCodeGenerator.infra.persistence.QrCodeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {


    @Bean
    QrCodeMapper qrCodeMapper() {
        return new QrCodeMapper();
    }

    @Bean
    QrCodeGenerator qrCodeGenerator(){
        return new QrCodeGenerator();
    }

    @Bean
    CreateQrCodeUseCase createQrCodeUseCase(QrCodeGateway qrCodeGateway){
        return new CreateQrCodeUseCaseImpl(qrCodeGateway);
    }

    @Bean
    QrCodeGateway qrCodeGateway(QrCodeRepository repository, QrCodeMapper mapper, QrCodeGenerator generator){
        return new QrCodeGatewayRepository(mapper,repository,generator);
    }


}
