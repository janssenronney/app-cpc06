package com.ifrs.app_cpc06.domain.calculo;
import com.ifrs.app_cpc06.domain.contrato.Contrato;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tbl_calculo")
@EqualsAndHashCode( of = "id_calculo")
@Getter
@Setter
@AllArgsConstructor
// Construtor vazio obrigatório para o JPA
@NoArgsConstructor
// Anotação que indica que esta classe será uma entidade JPA,
// ou seja, será mapeada para uma tabela no banco de dados.

public class Calculo extends Contrato {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private float vlr_presente;
    private float calc_depreciacao;
    private float vlr_juros;

    // Metodo para calcular o valor presente com base no valor futuro do contrato
    public float calculoValorPresente() {
        if (getTaxa_juros() < 0 || getNum_parcelas() <= 0 || getVlr_contrato() <= 0) {
            throw new IllegalArgumentException("Parâmetros inválidos.");
        }

        // Cálculo do valor presente usando a fórmula de valor presente para fluxo de caixa
        float calc_presente = (float) (getVlr_contrato() / Math.pow(1 + getTaxa_juros(), getNum_parcelas()));

        setVlr_presente(calc_presente);
        return (calc_presente);
    }


    public float calculoValorJuros() {
        if (getTaxa_juros() < 0 || getNum_parcelas() <= 0) {
            throw new IllegalArgumentException("Parametros Invalidos");
        }
        float calc_juros = calculoValorPresente()*getTaxa_juros();
        setVlr_juros(calc_juros);
        return (calc_juros);
    }


    public float calculoValorDepreciacao() {
        if (getTaxa_juros() < 0 || getNum_parcelas() <= 0) {
            throw new IllegalArgumentException("Parametros Invalidos");
        }
        float calc_depreciacao = calculoValorPresente()/getNum_parcelas();
        setCalc_depreciacao(calc_depreciacao);
        return (calc_depreciacao);
    }



}
