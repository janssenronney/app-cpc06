package com.ifrs.app_cpc06.controller;
import com.ifrs.app_cpc06.domain.calculo.Calculo;
import com.ifrs.app_cpc06.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calculo")

public class CalculoController {
    @Autowired  // Injeta automaticamente o FornecedorService, que contém a lógica de negócios.
    private CalculoService calculoService;
    /**
     * Endpoint GET para listar todos os contratos.
     *
     * @return Lista de contrato.
     */
    @GetMapping  // Mapeia requisições HTTP GET para este metodo
    public List<Calculo> listarCalculo() {
        return calculoService.listarCalculo();  // Chama o metodo listarProdutos() do serviço.
    }

    /**
     * Endpoint GET para buscar um contrato específico pelo ID.
     *
     * @param id_calculo contrato a ser buscado.
     * @return Contrato encontrado (se existir) ou um Optional vazio.
     */
    @GetMapping("/{id}")  // Mapeia requisições GET com um ID na URL (ex: /api/fornecedor/1).
    public Optional<Calculo> buscarCalculo(@PathVariable Integer id_calculo) {
        return calculoService.buscarCalculoPorId(id_calculo);  // Busca o contrato pelo ID usando o serviço.
    }

    /**
     * Endpoint POST para adicionar um novo fornecedo.
     *
     * @param calculo a ser adicionado.
     * @return contrato adicionado.
     */
    @PostMapping  // Mapeia requisições HTTP POST para este metodo.
    public Calculo adicionarCalculo(@RequestBody Calculo calculo) {
        return calculoService.salvarCalculo(calculo);  // Salva o novo contrato usando o serviço.
    }

    /**
     * Endpoint PUT para atualizar um produto existente.
     *
     * @param id_calculo ID do produto a ser atualizado.
     * @param calculoAtualizado Dados atualizados do produto.
     * @return Produto atualizado ou null se o produto não existir.
     */
    @PutMapping("/{id}")  // Mapeia requisições HTTP PUT com um ID na URL.
    public Calculo atualizarCalculo(@PathVariable Integer id_calculo, @RequestBody Calculo calculoAtualizado) {
        // Verifica se o contrato existe.
        Optional<Calculo> calculoExistente = calculoService.buscarCalculoPorId(id_calculo);
        if (calculoExistente.isPresent()) {
            Calculo calculo = calculoExistente.get();  // Se o fornecedor existir, atualiza os valores.
            calculo.setVlr_contrato(calculoAtualizado.getVlr_contrato());
            calculo.setNum_parcelas(calculoAtualizado.getNum_parcelas());
            calculo.setTaxa_juros(calculoAtualizado.getTaxa_juros());
            calculo.setVlr_contrato(calculoAtualizado.getVlr_contrato());
           return calculoService.salvarCalculo(calculo);  // Salva o fornecedor atualizado.
        }
        return null;  // Retorna null se o contrato não existir.
    }

    /**
     * Endpoint DELETE para remover um contrato pelo ID.
     *
     * @param id_calculo ID do contrato a ser removido.
     */
    @DeleteMapping("/{id}")  // Mapeia requisições HTTP DELETE com um ID na URL.
    public void deletarCalculo(@PathVariable Integer id_calculo) {
        calculoService.deletarCalculo(id_calculo);  // Remove o contrato pelo ID usando o serviço.
    }
}
