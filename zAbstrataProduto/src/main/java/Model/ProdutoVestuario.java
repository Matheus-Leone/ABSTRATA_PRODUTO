package Model;

import javax.persistence.*;

//Determina o produto como entidade para ser possível ser gerenciado
@Entity
@Table(name = "ProdutoVestuario")
public class ProdutoVestuario extends Produto {

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "cor")
    private String cor;

    @Column(name = "material")
    private String material;

    //Construtor de Produto Vestuário
    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    // Getters and setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
