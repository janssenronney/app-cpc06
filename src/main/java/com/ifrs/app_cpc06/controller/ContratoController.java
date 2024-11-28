package com.ifrs.app_cpc06.controller;
import com.ifrs.app_cpc06.domain.contrato.Contrato;
import com.ifrs.app_cpc06.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    @Autowired  // Injeta automaticamente o FornecedorService, que contém a lógica de negócios.
    private ContratoService contratoService;
    /**
     * Endpoint GET para listar todos os contratos.
     *
     * @return Lista de contrato.
     */
    @GetMapping  // Mapeia requisições HTTP GET para este metodo
    public List<Contrato> listarContrato() {
        return contratoService.listarContrato();  // Chama o metodo listarProdutos() do serviço.
    }

    /**
     * Endpoint GET para buscar um contrato específico pelo ID.
     *
     * @param id_controle contrato a ser buscado.
     * @return Contrato encontrado (se existir) ou um Optional vazio.
     */
    @GetMapping("/{id_controle}")  // Mapeia requisições GET com um ID na URL (ex: /api/fornecedor/1).
    public Optional<Contrato> buscarContrato(@PathVariable("id_controle") Integer id_controle) {
        return contratoService.buscarContratoPorId(id_controle);  // Busca o contrato pelo ID usando o serviço.
    }
    @GetMapping("/fornecedores/{id_n_fornecedor}")
    public List<Contrato> listarContratosPorFornecedor(@PathVariable("id_n_fornecedor") String id_n_fornecedor) {
        return contratoService.buscarContratosPorFornecedor(id_n_fornecedor);
    }

    /**
     * Endpoint POST para adicionar um novo fornecedo.
     *
     * @param contrato a ser adicionado.
     * @return contrato adicionado.
     */
    @PostMapping
    public List<Contrato> adicionarContrato(@RequestBody Contrato contrato) {
        return contratoService.salvarContrato(contrato);  // Salva e retorna a lista de contratos.
    }

    /*
     * Endpoint PUT para atualizar um contrato existente.
     *
     * @param id_controle ID do contrato a ser atualizado.
     * @param contratoAtualizado Dados atualizados do contrato.
     * @return contrato atualizado ou null se contrato não existir.
     */
    /**
     * Endpoint DELETE para remover um contrato pelo ID.
     *
     * @param id_controle ID do contrato a ser removido.
     */
    @DeleteMapping("/{id_controle}")  // Mapeia requisições HTTP DELETE com um ID na URL.
    public void deletarContrato(@PathVariable("id_controle") Integer id_controle) {
        contratoService.deletarContrato(id_controle);  // Remove o contrato pelo ID usando o serviço.
    }
}
