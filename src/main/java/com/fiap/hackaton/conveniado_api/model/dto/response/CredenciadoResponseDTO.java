package com.fiap.hackaton.conveniado_api.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CredenciadoResponseDTO {

    private String nome;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;

}
