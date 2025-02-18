package com.fiap.hackaton.conveniado_api.controller;

import com.fiap.hackaton.conveniado_api.model.dto.request.CredenciadoRequestDTO;
import com.fiap.hackaton.conveniado_api.model.dto.response.CredenciadoResponseDTO;
import com.fiap.hackaton.conveniado_api.service.ICredenciadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1/SUS/credenciados")
public class CredenciadoController {

    private final ICredenciadoService credenciadoService;

    public CredenciadoController(ICredenciadoService credenciadoService) {
        this.credenciadoService = credenciadoService;
    }

    @PostMapping
    public ResponseEntity<CredenciadoResponseDTO> cadastraCredenciado(@RequestBody CredenciadoRequestDTO credenciadoRequestDTO) {
        var credenciado = credenciadoService.cadastraCredenciado(credenciadoRequestDTO);
        return ResponseEntity.status(Objects.isNull(credenciado) ? HttpStatus.NOT_FOUND : HttpStatus.CREATED).body(credenciado);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<CredenciadoResponseDTO> buscaCredenciado(@PathVariable String cnpj) {
        var credenciado = credenciadoService.buscaCredenciadoPorCnpj(cnpj);
        return ResponseEntity.status(Objects.isNull(credenciado) ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(credenciado);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<CredenciadoResponseDTO> atualizaCredenciado(@PathVariable String cnpj, @RequestBody CredenciadoRequestDTO credenciadoRequestDTO) {
        var credenciado = credenciadoService.atualizaCredenciado(cnpj, credenciadoRequestDTO);
        return ResponseEntity.status(Objects.isNull(credenciado) ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED).body(credenciado);
    }

}
