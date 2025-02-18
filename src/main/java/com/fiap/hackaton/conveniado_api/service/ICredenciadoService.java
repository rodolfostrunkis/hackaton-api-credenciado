package com.fiap.hackaton.conveniado_api.service;

import com.fiap.hackaton.conveniado_api.model.dto.request.CredenciadoRequestDTO;
import com.fiap.hackaton.conveniado_api.model.dto.response.CredenciadoResponseDTO;

public interface ICredenciadoService {
    CredenciadoResponseDTO cadastraCredenciado(CredenciadoRequestDTO credenciadoRequestDTO);
    CredenciadoResponseDTO buscaCredenciadoPorCnpj(String cnpj);
    CredenciadoResponseDTO atualizaCredenciado(String cnpj, CredenciadoRequestDTO credenciadoRequestDTO);
}
