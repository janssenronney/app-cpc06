package com.ifrs.app_cpc06.domain.lancamento;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "tbl_lancamento")
@Entity(name = "tbl_lancamento")
@EqualsAndHashCode( of = "id_lancamento")
@Getter
@Setter
@AllArgsConstructor
// Construtor vazio obrigatório para o JPA
@NoArgsConstructor
// Anotação que indica que esta classe será uma entidade JPA,
// ou seja, será mapeada para uma tabela no banco de dados.
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_lancamento;
    private int id_fornecedor;
    private int id_controle;
    private float lnc_valorpres;
    private String cod_fornecedor;
    private int lnc_cc;
    private float lnc_juros;
    private int cont_despesa;
    private float lnc_depreciacao;
    private float vlr_despesa;
    private Date dt_lancamento;
}
