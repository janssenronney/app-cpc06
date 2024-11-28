package com.ifrs.app_cpc06.controller;

import com.ifrs.app_cpc06.domain.contrato.Contrato;
import com.ifrs.app_cpc06.domain.fornecedor.Fornecedor;
import com.ifrs.app_cpc06.domain.lancamento.Lancamento;
import com.ifrs.app_cpc06.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {
    @Autowired  // Injeta automaticamente o FornecedorService, que contém a lógica de negócios.
    private LancamentoService lancamentoService;

    /**
     * Endpoint POST para adicionar um novo lancamento.
     *
     * @param lancamento a ser adicionado.
     * @return contrato adicionado.
     */
    @PostMapping
    public Lancamento adicionarLancamento(@RequestBody Lancamento lancamento) {
        return lancamentoService.salvarLacamento(lancamento);  // Salva e retorna a lista de contratos.
    }
}
