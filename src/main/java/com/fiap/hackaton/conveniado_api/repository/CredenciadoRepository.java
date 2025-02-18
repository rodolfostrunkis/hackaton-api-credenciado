package com.fiap.hackaton.conveniado_api.repository;

import com.fiap.hackaton.conveniado_api.model.entity.CredenciadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredenciadoRepository extends JpaRepository<CredenciadoEntity, Long> {
    Optional<CredenciadoEntity> findFirstByOrderById();
    Optional<CredenciadoEntity> findByCnpj(String cnpj);
}
