package com.ifrs.app_cpc06.domain.contrato;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Table(name = "tbl_contrato")
@Entity(name = "tbl_contrato")
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    // Gera o valor do 'id' automaticamente, com base na estratégia de auto-incremento do banco.
    private int id_contrato;
    private int num_parcelas;
    private Date dt_inicio;
    private float taxa_contrato;
    private float vlr_contrato;
    private String ctto_objeto;
    private float vlr_presente;
    private float valor_depreciacao;
    private float valor_juros;

    public float calculoValorPresente() {
        if (getTaxa_contrato() < 0 || getNum_parcelas() <= 0) {
            throw new IllegalArgumentException("Parâmetros inválidos.");
        }

        // Cálculo do valor presente usando a fórmula de valor presente para fluxo de caixa
        float calc_presente = (float) (getVlr_contrato() / Math.pow(1 + (getTaxa_contrato()/100), getNum_parcelas()));

        setVlr_presente(calc_presente);
        return (calc_presente);
    }

    public float calculoValorJuros() {
        if (getTaxa_contrato() < 0 || getNum_parcelas() <= 0) {
            throw new IllegalArgumentException("Parametros Invalidos");
        }
        float calc_juros = calculoValorPresente()*getTaxa_contrato()/100;
        setValor_juros(calc_juros);
        return (calc_juros);
    }
    public float calculoValorDepreciacao() {
        if (getTaxa_contrato() < 0 || getNum_parcelas() <= 0) {
            throw new IllegalArgumentException("Parametros Invalidos");
        }
        float calc_depreciacao = calculoValorPresente()/getNum_parcelas();
        // Formatar o resultado para 2 casas decimais usando BigDecimal
        setValor_depreciacao(calc_depreciacao);
        return (calc_depreciacao);
    }


}
