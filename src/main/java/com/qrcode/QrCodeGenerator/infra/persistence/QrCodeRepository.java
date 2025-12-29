package com.qrcode.QrCodeGenerator.infra.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCodeEntity, Long> {
}
