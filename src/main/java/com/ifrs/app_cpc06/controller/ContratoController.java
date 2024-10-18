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
     * @param id_contrato contrato a ser buscado.
     * @return Contrato encontrado (se existir) ou um Optional vazio.
     */
    @GetMapping("/{id}")  // Mapeia requisições GET com um ID na URL (ex: /api/fornecedor/1).
    public Optional<Contrato> buscarContrato(@PathVariable Integer id_contrato) {
        return contratoService.buscarContratoPorId(id_contrato);  // Busca o contrato pelo ID usando o serviço.
    }

    /**
     * Endpoint POST para adicionar um novo fornecedo.
     *
     * @param contrato a ser adicionado.
     * @return contrato adicionado.
     */
    @PostMapping  // Mapeia requisições HTTP POST para este metodo.
    public Contrato adicionarContrato(@RequestBody Contrato contrato) {
        return contratoService.salvarContrato(contrato);  // Salva o novo contrato usando o serviço.
    }

    /**
     * Endpoint PUT para atualizar um produto existente.
     *
     * @param id_contrato ID do produto a ser atualizado.
     * @param contratoAtualizado Dados atualizados do produto.
     * @return Produto atualizado ou null se o produto não existir.
     */
    @PutMapping("/{id}")  // Mapeia requisições HTTP PUT com um ID na URL.
    public Contrato atualizarContrato(@PathVariable Integer id_contrato, @RequestBody Contrato contratoAtualizado) {
        // Verifica se o contrato existe.
        Optional<Contrato> contratoExistente = contratoService.buscarContratoPorId(id_contrato);
        if (contratoExistente.isPresent()) {
            Contrato contrato = contratoExistente.get();  // Se o fornecedor existir, atualiza os valores.
            contrato.setCtto_objeto(contratoAtualizado.getCtto_objeto());
            contrato.setNum_parcelas(contratoAtualizado.getNum_parcelas());
            contrato.setDt_inicio(contratoAtualizado.getDt_inicio());
            contrato.setVlr_contrato(contratoAtualizado.getVlr_contrato());
            return contratoService.salvarContrato(contrato);  // Salva o fornecedor atualizado.
        }
        return null;  // Retorna null se o contrato não existir.
    }

    /**
     * Endpoint DELETE para remover um contrato pelo ID.
     *
     * @param id_contrato ID do contrato a ser removido.
     */
    @DeleteMapping("/{id}")  // Mapeia requisições HTTP DELETE com um ID na URL.
    public void deletarContrato(@PathVariable Integer id_contrato) {
        contratoService.deletarContrato(id_contrato);  // Remove o contrato pelo ID usando o serviço.
    }
}
