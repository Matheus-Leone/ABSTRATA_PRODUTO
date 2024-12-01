package Model;

import javax.persistence.*;

//Determina o produto como entidade para ser possível ser gerenciado
@Entity
@Table(name = "ProdutoAlimenticio")
public class ProdutoAlimenticio extends Produto {

    @Column(name = "data_validade")
    private String dataValidade;

    @Column(name = "informacoes_nutricionais")
    private String informacoesNutricionais;

    //Construtor de Produto Alimentício
    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
        super(nome, precoCusto, precoVenda);
        this.dataValidade = dataValidade;
        this.informacoesNutricionais = informacoesNutricionais;
    }

    // Getters and setters
    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getInformacoesNutricionais() {
        return informacoesNutricionais;
    }

    public void setInformacoesNutricionais(String informacoesNutricionais) {
        this.informacoesNutricionais = informacoesNutricionais;
    }
}
