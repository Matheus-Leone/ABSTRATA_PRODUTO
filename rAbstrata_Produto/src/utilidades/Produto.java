package utilidades;

//SuperClasse que irá repassar seus Atributos para outras classes, possui alto nivel de abstração para que não seja instanciada
public abstract class Produto {
    protected String nome;
    public double precoCusto;
    protected double precoVenda;

    //Construtor da Classe Produto
    public Produto(String nome, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    // Método para simular salvar o produto no banco de dados
    public abstract void salvar();

    // Método para simular deletar o produto do banco de dados
    public abstract void deletar();

    // Método para simular atualizar o produto no banco de dados
    public abstract void atualizar();

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
}
