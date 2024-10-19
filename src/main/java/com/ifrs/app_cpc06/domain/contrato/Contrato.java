package com.ifrs.app_cpc06.domain.contrato;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "tbl_contrato")
@Entity(name = "tbl_contrato")
@Inheritance(strategy = InheritanceType.JOINED)  // Cada subclasse terá sua própria tabela
@EqualsAndHashCode( of = "id_contrato")
@Getter
@Setter
@AllArgsConstructor
// Construtor vazio obrigatório para o JPA
@NoArgsConstructor
// Anotação que indica que esta classe será uma entidade JPA,
// ou seja, será mapeada para uma tabela no banco de dados.
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Gera o valor do 'id' automaticamente, com base na estratégia de auto-incremento do banco.
    private int id_contrato;
    private int num_parcelas;
    private Date dt_inicio;
    private float vlr_contrato;
    private String ctto_objeto;
    private float taxa_juros;
}
