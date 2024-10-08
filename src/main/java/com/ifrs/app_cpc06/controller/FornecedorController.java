package com.ifrs.app_cpc06.controller;
import com.ifrs.app_cpc06.domain.fornecedor.Fornecedor;
import com.ifrs.app_cpc06.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired  // Injeta automaticamente o FornecedorService, que contém a lógica de negócios.
    private FornecedorService fornecedorService;
    /**
     * Endpoint GET para listar todos os fornecedor.
     *
     * @return Lista de fornecedor.
     */
    @GetMapping  // Mapeia requisições HTTP GET para este metodo
    public List<Fornecedor> listarFornecedor() {
        return fornecedorService.listarfornecedor();  // Chama o metodo listarProdutos() do serviço.
    }

    /**
     * Endpoint GET para buscar um produto específico pelo ID.
     *
     * @param id_fonecedor fornecedor a ser buscado.
     * @return Produto encontrado (se existir) ou um Optional vazio.
     */
    @GetMapping("/{id}")  // Mapeia requisições GET com um ID na URL (ex: /api/fornecedor/1).
    public Optional<Fornecedor> buscarFornecedor(@PathVariable Integer id_fonecedor) {
        return fornecedorService.buscarfornecedorPorId(id_fonecedor);  // Busca o fornecedor pelo ID usando o serviço.
    }

    /**
     * Endpoint POST para adicionar um novo fornecedo.
     *
     * @param fornecedor a ser adicionado.
     * @return fornecedor adicionado.
     */
    @PostMapping  // Mapeia requisições HTTP POST para este metodo.
    public Fornecedor adicionarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvarfornecedor(fornecedor);  // Salva o novo fornecedor usando o serviço.
    }

    /**
     * Endpoint PUT para atualizar um produto existente.
     *
     * @param id_fornecedor ID do produto a ser atualizado.
     * @param fornecedorAtualizado Dados atualizados do produto.
     * @return Produto atualizado ou null se o produto não existir.
     */
    @PutMapping("/{id}")  // Mapeia requisições HTTP PUT com um ID na URL.
    public Fornecedor atualizarFornecedor(@PathVariable Integer id_fornecedor, @RequestBody Fornecedor fornecedorAtualizado) {
        Optional<Fornecedor> fornecedorExistente = fornecedorService.buscarfornecedorPorId(id_fornecedor);  // Verifica se o fonecedor existe.
        if (fornecedorExistente.isPresent()) {
            Fornecedor fornecedor = fornecedorExistente.get();  // Se o fornecedor existir, atualiza os valores.
            fornecedor.setFor_nome(fornecedorAtualizado.getFor_nome());
            fornecedor.setCont_despesa(fornecedorAtualizado.getCont_despesa());
            fornecedor.setCod_fornecedor(fornecedorAtualizado.getCod_fornecedor());
            return fornecedorService.salvarfornecedor(fornecedor);  // Salva o fornecedor atualizado.
        }
        return null;  // Retorna null se o fornecedor não existir.
    }

    /**
     * Endpoint DELETE para remover um fornecedor pelo ID.
     *
     * @param id_fornecedor ID do fornecedor a ser removido.
     */
    @DeleteMapping("/{id}")  // Mapeia requisições HTTP DELETE com um ID na URL.
    public void deletarFornecedor(@PathVariable Integer id_fornecedor) {
        fornecedorService.deletarFornecedor(id_fornecedor);  // Remove o fornecedor pelo ID usando o serviço.
    }
}
