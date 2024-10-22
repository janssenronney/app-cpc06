package com.ifrs.app_cpc06.domain.calculo;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_calculo")
@Entity(name = "tbl_calculo")
@EqualsAndHashCode( of = "id_calculo")
@Getter
@Setter
@AllArgsConstructor
// Construtor vazio obrigatório para o JPA
@NoArgsConstructor
// Anotação que indica que esta classe será uma entidade JPA,
// ou seja, será mapeada para uma tabela no banco de dados.
public class Calculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Gera o valor do 'id' automaticamente, com base na estratégia de auto-incremento do banco.
    private int id_calculo;
    private int num_parcelas;
    private float vlr_presente;
    private float calc_depreciacao;
}
