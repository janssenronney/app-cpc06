package com.ifrs.app_cpc06.domain.contrato;
import com.ifrs.app_cpc06.service.ContratoService;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "tbl_contrato")
@Entity(name = "tbl_contrato")
@EqualsAndHashCode( of = "id_controle")
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
    private int id_controle;
    private int cod_ctto;
    private int num_parcelas;
    private String id_n_fornecedor;
    private Date dt_inicio;
    private float taxa_contrato;
    private float vlr_contrato;
    private String ctto_objeto;
    private float vlr_presente;
    private float valor_depreciacao;
    private float valor_juros;
    private float saldo_contrato;


    public float calculoValorPresente() {
        if (getTaxa_contrato() < 0 || getNum_parcelas() <= 0) {
            throw new IllegalArgumentException("Parâmetros inválidos.");
        }

        float calc_presente = 0; // inicialização da variável de valor presente

        // Loop para iterar sobre cada parcela
        for (int i = 1; i <= getNum_parcelas(); i++) {
            float vlr_parcela = getVlr_contrato()/getNum_parcelas();
            // Cálculo do valor presente usando a fórmula
            calc_presente += (float) (vlr_parcela / (Math.pow(1 + (Math.pow(((getTaxa_contrato() / 100) + 1), (1.0 / 12)) - 1), i)));
        }

        setVlr_presente(calc_presente); // Configura o valor presente calculado
        return calc_presente; // Retorna o valor presente total
    }

    public float saldoContrato(int i) {

        float saldo = i == 1? getVlr_presente(): getSaldo_contrato(); // Inicializa com o valor presente
        float valorParcela = -getVlr_contrato()/getNum_parcelas(); // Valor da parcela
        double calc_juros = saldo * (Math.pow((getTaxa_contrato() / 100) + 1, 1.0 / 12) - 1);
        saldo += (float) (calc_juros + valorParcela); // Atualiza o saldo
        setValor_juros((float) calc_juros);
        setSaldo_contrato(saldo); // Atualiza o saldo no contrato
        return saldo;
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
