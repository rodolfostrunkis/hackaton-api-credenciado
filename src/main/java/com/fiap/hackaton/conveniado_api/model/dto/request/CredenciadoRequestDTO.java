package com.fiap.hackaton.conveniado_api.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CredenciadoRequestDTO {

    @NotNull
    private String nome;

    @NotNull
    @Length(min = 14, max = 18)
    private String cnpj;

    @NotNull
    private String endereco;

    @NotNull
    @Length(max = 60)
    private String cidade;

    @NotNull
    @Length(min = 2, max = 2)
    private String uf;

    @NotNull
    @Length(max = 10)
    private String cep;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp
    @Column(name = "atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;

}
