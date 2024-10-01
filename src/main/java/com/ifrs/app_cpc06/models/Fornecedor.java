package com.ifrs.app_cpc06.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Anotação que indica que esta classe será uma entidade JPA,
// ou seja, será mapeada para uma tabela no banco de dados.
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Gera o valor do 'id' automaticamente, com base na estratégia de auto-incremento do banco.
    private int id_fornecedor;
    private String nome;
    private int cont_despesa;
    // Construtor vazio obrigatório para o JPA
    public Fornecedor() {}
    public Fornecedor(String nome, int cont_despesa) {
        this.nome = nome;
        this.cont_despesa = cont_despesa;
    }
    public int getId_fornecedor() {
        return id_fornecedor;
    }
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCont_despesa() {
        return cont_despesa;
    }
    public void setCont_despesa(int cont_despesa) {
        this.cont_despesa = cont_despesa;
    }

}
