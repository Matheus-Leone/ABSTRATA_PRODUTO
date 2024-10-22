package utilidades;

//Classe que irá herdar o atributo de Produto, tendo seus próprio Atributos também
public class ProdutoVestuario extends Produto {
    private String tamanho;
    private String cor;
    private String material;

    //Construtor de ProdutoVestuario
    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

  //Override para sobreescrever as informações já colocadas no mesmo método (salvar)
    @Override
    public void salvar() {
        System.out.println("Produto de vestuário " + nome + " salvo com sucesso!");
    }
    
  //Override para sobreescrever as informações já colocadas no mesmo método (deletar)
    @Override
    public void deletar() {
        System.out.println("Produto de vestuário " + nome + " deletado com sucesso!");
    }

  //Override para sobreescrever as informações já colocadas no mesmo método (atualizar)
    @Override
    public void atualizar() {
        System.out.println("Produto de vestuário " + nome + " atualizado com sucesso!");
    }

    // Getters e Setters
    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getMaterial() {
        return material;
    }
}
