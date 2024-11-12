package com.ifrs.app_cpc06.domain.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FornecedorRepository é a interface que lida com as operações de banco de dados para a entidade Fornecedor.
 * Ela extende JpaRepository, que fornece várias operações CRUD pré-implementadas.
 * JpaRepository Fonecedor, Integer> significa que ela trabalhará com a entidade Fornecedor e sua chave primária é do tipo Integer.
 */

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {}