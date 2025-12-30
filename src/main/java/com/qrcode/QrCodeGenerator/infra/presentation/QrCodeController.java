package com.qrcode.QrCodeGenerator.infra.presentation;

import com.qrcode.QrCodeGenerator.core.usecases.CreateQrCodeUseCase;
import com.qrcode.QrCodeGenerator.infra.dto.QrCodeRequest;
import com.qrcode.QrCodeGenerator.infra.exception.ConflictException;
import com.qrcode.QrCodeGenerator.infra.mapper.QrCodeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final CreateQrCodeUseCase createQrCodeUseCase;
    private final QrCodeMapper mapper;

    public QrCodeController(CreateQrCodeUseCase createQrCodeUseCase, QrCodeMapper mapper) {
        this.createQrCodeUseCase = createQrCodeUseCase;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> generateQrCode(@RequestBody QrCodeRequest request){
        if (request.link() == null | request.link() == ""){
            throw new ConflictException("Erro ao gerar QR Code");
        }
        var bytes = createQrCodeUseCase.execute(request.link());
        Map<String, Object> response = new HashMap<>();
        response.put("Message","QrCode Gerado com sucesso");
        response.put("QrCode", bytes);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{link}")
    public ResponseEntity<Map<String,Object>> getQrCodeBylink(@PathVariable QrCodeRequest request){
        var entity = createQrCodeUseCase.execute(request.link());

        Map<String, Object> response = new HashMap<>();
        response.put("Message","QrCode Gerado com sucesso");
        response.put("Data", entity);

        return ResponseEntity.ok().body(response);
    }



}
