package utilidades;

//Classe que irá herdar o atributo de Produto, tendo seus próprio Atributos também
public class ProdutoAlimenticio extends Produto {
    private String dataValidade;
    private String informacoesNutricionais;
    
//Construtor da Classe ProdutoAlimenticio
    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
        super(nome, precoCusto, precoVenda);
        this.dataValidade = dataValidade;
        this.informacoesNutricionais = informacoesNutricionais;
    }
    
  //Override para sobreescrever as informações já colocadas no mesmo método (salvar)
    @Override
    public void salvar() {
        System.out.println("Produto alimentício " + nome + " salvo com sucesso!");
    }
    
  //Override para sobreescrever as informações já colocadas no mesmo método (deletar)
    @Override
    public void deletar() {
        System.out.println("Produto alimentício " + nome + " deletado com sucesso!");
    }
    
  //Override para sobreescrever as informações já colocadas no mesmo método (atualizar)
    @Override
    public void atualizar() {
        System.out.println("Produto alimentício " + nome + " atualizado com sucesso!");
    }

    // Getters e Setters
    public String getDataValidade() {
        return dataValidade;
    }

    public String getInformacoesNutricionais() {
        return informacoesNutricionais;
    }
}
