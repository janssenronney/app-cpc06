package com.ifrs.app_cpc06.service;

import com.ifrs.app_cpc06.domain.calculo.Calculo;
import com.ifrs.app_cpc06.domain.calculo.CalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculoService {

    // Injeção de dependência do repositório de fornecedores
    @Autowired// O Spring irá automaticamente injetar uma instância de ContratoRepository aqui
    private CalculoRepository calculoRepository;

    // Metodo para listar todos os fornecedores
    public List<Calculo> listarCalculo() {
        // Retorna a lista de todos os contrato usando o metodo findAll do repositório
        return calculoRepository.findAll();
    }

    // Metodo para buscar um fornecedor pelo ID
    public Optional<Calculo> buscarCalculoPorId(Integer id_calculo) {
        // Retorna um objeto Optional contendo o contrato se encontrado, ou vazio se não
        return calculoRepository.findById(id_calculo);
    }

    // Metodo para salvar um novo fornecedor no banco de dados
    public Calculo salvarCalculo(Calculo calculo) {
        // Salva o contrato e retorna a entidade salva (pode incluir o ID auto gerado)
        return calculoRepository.save(calculo);
    }

    // Metodo para deletar um contrato pelo ID
    public void deletarCalculo(Integer id_calculo) {
        // Deleta o contrato usando o metodo deleteById do repositorio
        calculoRepository.deleteById(id_calculo);
    }
}
