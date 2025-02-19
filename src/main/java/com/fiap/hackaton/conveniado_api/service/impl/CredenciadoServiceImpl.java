package com.fiap.hackaton.conveniado_api.service.impl;

import com.fiap.hackaton.conveniado_api.exception.InvalidCNPJException;
import com.fiap.hackaton.conveniado_api.model.dto.request.CredenciadoRequestDTO;
import com.fiap.hackaton.conveniado_api.model.dto.response.CredenciadoResponseDTO;
import com.fiap.hackaton.conveniado_api.model.entity.CredenciadoEntity;
import com.fiap.hackaton.conveniado_api.repository.CredenciadoRepository;
import com.fiap.hackaton.conveniado_api.service.ICredenciadoService;
import com.fiap.hackaton.conveniado_api.utils.ValidarCNPJ;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CredenciadoServiceImpl implements ICredenciadoService {

    private static final Logger logger = LogManager.getLogger(CredenciadoServiceImpl.class);

    @Autowired
    private final CredenciadoRepository credenciadoRepository;

    @Override
    public CredenciadoResponseDTO cadastraCredenciado(CredenciadoRequestDTO credenciadoRequestDTO) {
        Optional<CredenciadoEntity> credenciadoEncontrado = credenciadoRepository.findByCnpj(credenciadoRequestDTO.getCnpj());
        if (credenciadoEncontrado.isEmpty()) {
            if (!ValidarCNPJ.isCNPJ(credenciadoRequestDTO.getCnpj())) {
                logger.error("CNPJ inválido: " + credenciadoRequestDTO.getCnpj());
                throw new InvalidCNPJException("CNPJ inválido: " + credenciadoRequestDTO.getCnpj());
            }
            CredenciadoEntity credenciado = new CredenciadoEntity();
            credenciado.setNome(credenciadoRequestDTO.getNome());
            credenciado.setCnpj(credenciadoRequestDTO.getCnpj());
            credenciado.setEndereco(credenciadoRequestDTO.getEndereco());
            credenciado.setCidade(credenciadoRequestDTO.getCidade());
            credenciado.setUf(credenciadoRequestDTO.getUf());
            credenciado.setCep(credenciadoRequestDTO.getCep());

            var credenciadoSalvo = credenciadoRepository.save(credenciado);

            return new CredenciadoResponseDTO(credenciadoSalvo.getNome(), credenciadoSalvo.getCnpj(), credenciadoSalvo.getEndereco(), credenciadoSalvo.getCidade(), credenciadoSalvo.getUf(), credenciadoSalvo.getCep());
        }
        return null;
    }

    @Override
    public CredenciadoResponseDTO buscaCredenciadoPorCnpj(String cnpj) {

        Optional<CredenciadoEntity> credenciadoEncontrado = credenciadoRepository.findByCnpj(cnpj);
        return credenciadoEncontrado.map(credenciado -> new CredenciadoResponseDTO(credenciado.getNome(), credenciado.getCnpj(), credenciado.getEndereco(), credenciado.getCidade(), credenciado.getUf(), credenciado.getCep())).orElse(null);
    }

    @Override
    public CredenciadoResponseDTO atualizaCredenciado(String cnpj, CredenciadoRequestDTO credenciadoRequestDTO) {
        Optional<CredenciadoEntity> credenciadoEncontrado = credenciadoRepository.findByCnpj(cnpj);
        if (credenciadoEncontrado.isPresent()) {
            CredenciadoEntity credenciado = credenciadoEncontrado.get();
            credenciado.setNome(credenciadoRequestDTO.getNome());
            credenciado.setEndereco(credenciadoRequestDTO.getEndereco());
            credenciado.setCidade(credenciadoRequestDTO.getCidade());
            credenciado.setUf(credenciadoRequestDTO.getUf());
            credenciado.setCep(credenciadoRequestDTO.getCep());

            var CredenciadoAtualizado = credenciadoRepository.save(credenciado);

            return new CredenciadoResponseDTO(CredenciadoAtualizado.getNome(), CredenciadoAtualizado.getCnpj(), CredenciadoAtualizado.getEndereco(), CredenciadoAtualizado.getCidade(), CredenciadoAtualizado.getUf(), CredenciadoAtualizado.getCep());
        }
        return null;
    }
}
