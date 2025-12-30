package com.qrcode.QrCodeGenerator.infra.persistence;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.BinaryJdbcType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QrCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 500)
    String link;
    byte[] image;

}
