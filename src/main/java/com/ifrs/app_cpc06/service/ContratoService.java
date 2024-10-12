package com.ifrs.app_cpc06.service;
import com.ifrs.app_cpc06.domain.contrato.Contrato;
import com.ifrs.app_cpc06.domain.contrato.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// Classe de serviço para gerenciar operações relacionadas a fornecedores
@Service // Anotação que indica que esta classe é um serviço do Spring

public class ContratoService {

    // Injeção de dependência do repositório de fornecedores
    @Autowired // O Spring irá automaticamente injetar uma instância de ContratoRepository aqui
    private ContratoRepository contratoRepository;

    // Metodo para listar todos os fornecedores
    public List<Contrato> listarcontrato() {
        // Retorna a lista de todos os contrato usando o metodo findAll do repositório
        return contratoRepository.findAll();
    }

    // Metodo para buscar um fornecedor pelo ID
    public Optional<Contrato> buscarContratoPorId(Integer id_contrato) {
        // Retorna um objeto Optional contendo o contrato se encontrado, ou vazio se não
        return contratoRepository.findById(id_contrato);
    }

    // Metodo para salvar um novo fornecedor no banco de dados
    public Contrato salvarContrato(Contrato contrato) {
        // Salva o contrato e retorna a entidade salva (pode incluir o ID auto gerado)
        return contratoRepository.save(contrato);
    }

    // Metodo para deletar um contrato pelo ID
    public void deletarContrato(Integer id_contrato) {
        // Deleta o contrato usando o metodo deleteById do repositorio
        contratoRepository.deleteById(id_contrato);
    }
}

