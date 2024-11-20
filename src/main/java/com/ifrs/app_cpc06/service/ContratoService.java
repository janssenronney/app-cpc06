package com.ifrs.app_cpc06.service;
import com.ifrs.app_cpc06.domain.contrato.Contrato;
import com.ifrs.app_cpc06.domain.contrato.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Classe de serviço para gerenciar operações relacionadas a fornecedores
@Service // Anotação que indica que esta classe é um serviço do Spring

public class ContratoService {

    // Injeção de dependência do repositório de fornecedores
    @Autowired // O Spring irá automaticamente injetar uma instância de ContratoRepository aqui
    private ContratoRepository contratoRepository;

    // Metodo para listar todos os fornecedores
    public List<Contrato> listarContrato() {
        // Retorna a lista de todos os contrato usando o metodo findAll do repositório
        return contratoRepository.findAll();
    }

    // Metodo para buscar um fornecedor pelo ID
    public Optional<Contrato> buscarContratoPorId(Integer id_controle) {
        // Retorna um objeto Optional contendo o contrato se encontrado, ou vazio se não
        return contratoRepository.findById(id_controle);
    }

    // Metodo para salvar um novo fornecedor no banco de dado's
    public List<Contrato> salvarContrato(Contrato contrato) {
        int j = contrato.getNum_parcelas();
        int i = 0;
        List<Contrato> contratosSalvos = new ArrayList<>(); // lista para armazenar instâncias salvas
        int ultimo_contrato;

        while (i < j) {
            Contrato novoContrato = new Contrato();
            novoContrato.setCod_ctto(contrato.getCod_ctto());
            novoContrato.setId_n_fornecedor(contrato.getId_n_fornecedor());
            novoContrato.setVlr_presente(contrato.calculoValorPresente());
            novoContrato.setValor_depreciacao(contrato.calculoValorDepreciacao());
            float saldo = i == 0? contrato.getVlr_presente() : contrato.saldoContrato(i); // Calcula o saldo uma vez
            novoContrato.setSaldo_contrato(saldo); // Define o saldo no novo contrato
            novoContrato.setValor_juros((float) (saldo * (Math.pow((contrato.getTaxa_contrato()/100)+1, 1.0 / 12) - 1))); // Calcula os jurosnovoContrato.setTaxa_contrato(contrato.getTaxa_contrato());
            novoContrato.setNum_parcelas(i+1);
            novoContrato.setTaxa_contrato(contrato.getTaxa_contrato());
            novoContrato.setDt_inicio(contrato.getDt_inicio());
            novoContrato.setCtto_objeto(contrato.getCtto_objeto());
            novoContrato.setVlr_contrato(contrato.getVlr_contrato());


            // Salva e adiciona à lista
            contratosSalvos.add(contratoRepository.save(novoContrato));
            i++;
        }

        return contratosSalvos; // Retorna todas as instâncias salvas
    }

    // Metodo para deletar um contrato pelo ID
    public void deletarContrato(Integer id_controle) {
        // Deleta o contrato usando o metodo deleteById do repositorio
        contratoRepository.deleteById(id_controle);
    }
}

