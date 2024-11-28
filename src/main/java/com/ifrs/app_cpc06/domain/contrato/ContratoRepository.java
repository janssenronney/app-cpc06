package com.ifrs.app_cpc06.domain.contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    @Query("SELECT c FROM tbl_contrato c WHERE c.id_n_fornecedor = :id_fornecedor")
    List<Contrato> findById_n_fornecedor(@Param("id_fornecedor") String id_n_fornecedor);
}
