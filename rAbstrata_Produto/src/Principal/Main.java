package Principal;

//Import para buscar os métodos de outras classes
import utilidades.ProdutoAlimenticio;
import utilidades.ProdutoVestuario;

//Método principal para testar tudo que foi configurado
public class Main {
    public static void main(String[] args) {
        // Criando um produto alimentício
        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio("Arroz", 10.0, 15.0, "2025-12-31", "Carboidratos, Proteínas");
        produtoAlimenticio.salvar();

        // Criando um produto de vestuário
        ProdutoVestuario produtoVestuario = new ProdutoVestuario("Camisa", 30.0, 50.0, "M", "Azul", "Algodão");
        produtoVestuario.salvar();

        // Atualizando o produto alimentício
        produtoAlimenticio.precoCusto = 11.0; // Novo preço de custo
        produtoAlimenticio.atualizar();

        // Deletando o produto de vestuário
        produtoVestuario.deletar();
    }
}
