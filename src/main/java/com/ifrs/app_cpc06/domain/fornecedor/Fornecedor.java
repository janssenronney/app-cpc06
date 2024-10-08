package com.ifrs.app_cpc06.domain.fornecedor;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_fornecedor")
@Entity(name = "tbl_fornecedor")
@EqualsAndHashCode( of = "id_fornecedor")
@Getter
@Setter
@AllArgsConstructor
// Construtor vazio obrigatório para o JPA
@NoArgsConstructor
// Anotação que indica que esta classe será uma entidade JPA,
// ou seja, será mapeada para uma tabela no banco de dados.
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // Gera o valor do 'id' automaticamente, com base na estratégia de auto-incremento do banco.
    private int id_fornecedor;
    private String for_nome;
    private Number cont_despesa;
    private String cod_fornecedor;
}
