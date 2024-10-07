package com.ifrs.app_cpc06.service;

import com.ifrs.app_cpc06.models.Fornecedor;
import com.ifrs.app_cpc06.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

// Marca esta classe como um "service",
// permitindo que o Spring a gerencie como um componente de injeção de dependência.

public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;
    public List<Fornecedor> listarfornecedor() {
        return fornecedorRepository.findAll();
    }
    public Optional<Fornecedor> buscarfornecedorPorId(Integer id_fornecedor) {
        return fornecedorRepository.findById(id_fornecedor);
    }
    public Fornecedor salvarfornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }
    public void deletarfornecedor(Integer id_fornecedor) {
        fornecedorRepository.deleteById(id_fornecedor);
    }
}
