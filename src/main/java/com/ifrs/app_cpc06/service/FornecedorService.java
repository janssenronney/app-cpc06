package com.ifrs.app_cpc06.service;

import com.ifrs.app_cpc06.domain.fornecedor.Fornecedor;
import com.ifrs.app_cpc06.domain.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Classe de serviço para gerenciar operações relacionadas a fornecedores
@Service // Anotação que indica que esta classe é um serviço do Spring

public class FornecedorService {

    // Injeção de dependência do repositório de fornecedores
    @Autowired // O Spring irá automaticamente injetar uma instância de FornecedorRepository aqui
    private FornecedorRepository fornecedorRepository;

    // Metodo para listar todos os fornecedores
    public List<Fornecedor> listarfornecedor() {
        // Retorna a lista de todos os fornecedores usando o método findAll do repositório
        return fornecedorRepository.findAll();
    }

    // Metodo para buscar um fornecedor pelo ID
    public Optional<Fornecedor> buscarfornecedorPorId(Integer id_fornecedor) {
        // Retorna um objeto Optional contendo o fornecedor se encontrado, ou vazio se não
        return fornecedorRepository.findById(id_fornecedor);
    }

    // Metodo para salvar um novo fornecedor no banco de dados
    public Fornecedor salvarfornecedor(Fornecedor fornecedor) {
        // Salva o fornecedor e retorna a entidade salva (pode incluir o ID auto gerado)
        return fornecedorRepository.save(fornecedor);
    }

    // Metodo para deletar um fornecedor pelo ID
    public void deletarfornecedor(Integer id_fornecedor) {
        // Deleta o fornecedor usando o mEtodo deleteById do repositório
        fornecedorRepository.deleteById(id_fornecedor);
    }
}
