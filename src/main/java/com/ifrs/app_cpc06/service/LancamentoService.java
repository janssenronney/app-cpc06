package com.ifrs.app_cpc06.service;

import com.ifrs.app_cpc06.domain.fornecedor.Fornecedor;
import com.ifrs.app_cpc06.domain.lancamento.Lancamento;
import com.ifrs.app_cpc06.domain.lancamento.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Anotação que indica que esta classe é um serviço do Spring

public class LancamentoService {

    // Injeção de dependência do repositório de fornecedores
    @Autowired
    private LancamentoRepository lancamentoRepository;

    // Metodo para salvar um novo fornecedor no banco de dados
    public Lancamento salvarLacamento(Lancamento lancamento) {
        // Salva o fornecedor e retorna a entidade salva (pode incluir o ID auto gerado)
        return lancamentoRepository.save(lancamento);
    }
}
