package Main;

import Dao.ProdutoDAO;
import Model.Produto;
import Model.ProdutoAlimenticio;
import Model.ProdutoVestuario;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        int opcao;

        
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

         // Criação de objetos de cada tipo de Produto antes de coletar os dados
            switch (opcao) {
                case 1:
                    cadastrarProduto(scanner, produtoDAO);
                    break;
                case 2:
                    cadastrarProdutoAlimenticio(scanner, produtoDAO);
                    break;
                case 3:
                    cadastrarProdutoVestuario(scanner, produtoDAO);
                    break;
                case 4:
                    listarProdutos(produtoDAO);
                    break;
                case 5:
                    atualizarProduto(scanner, produtoDAO);
                    break;
                case 6:
                    deletarProduto(scanner, produtoDAO);
                    break;
                case 0:
                    System.out.println("Saindo... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        produtoDAO.close();
        scanner.close();
    }

    // Criação de um Sistema CLI
    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Cadastrar Produto ");
        System.out.println("2. Cadastrar Produto Alimentício");
        System.out.println("3. Cadastrar Produto de Vestuário");
        System.out.println("4. Listar Todos os Produtos");
        System.out.println("5. Atualizar Produto");
        System.out.println("6. Deletar Produto");
        System.out.println("0. Sair");
        System.out.print("Digite sua escolha: ");
    }

    //Cadastra o Produto
    private static void cadastrarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço de custo: ");
        double precoCusto = scanner.nextDouble();
        System.out.print("Digite o preço de venda: ");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        Produto produto = new Produto(nome, precoCusto, precoVenda);
        produtoDAO.salvar(produto);
        System.out.println("Produto Genérico cadastrado com sucesso!");
    }
    //Cadastra o Produto Alimentício
    private static void cadastrarProdutoAlimenticio(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.print("Digite o nome do produto alimentício: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço de custo: ");
        double precoCusto = scanner.nextDouble();
        System.out.print("Digite o preço de venda: ");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite a data de validade: ");
        String dataValidade = scanner.nextLine();
        System.out.print("Digite as informações nutricionais: ");
        String infoNutricionais = scanner.nextLine();

        ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio(nome, precoCusto, precoVenda, dataValidade, infoNutricionais);
        produtoDAO.salvar(produtoAlimenticio);
        System.out.println("Produto Alimentício cadastrado com sucesso!");
    }
    //Cadastra o Produto Vestuário
    private static void cadastrarProdutoVestuario(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.print("Digite o nome do produto de vestuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço de custo: ");
        double precoCusto = scanner.nextDouble();
        System.out.print("Digite o preço de venda: ");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite o tamanho: ");
        String tamanho = scanner.nextLine();
        System.out.print("Digite a cor: ");
        String cor = scanner.nextLine();
        System.out.print("Digite o material: ");
        String material = scanner.nextLine();

        ProdutoVestuario produtoVestuario = new ProdutoVestuario(nome, precoCusto, precoVenda, tamanho, cor, material);
        produtoDAO.salvar(produtoVestuario);
        System.out.println("Produto de Vestuário cadastrado com sucesso!");
    }
    //Lista o Produto
    private static void listarProdutos(ProdutoDAO produtoDAO) {
        List<Produto> produtos = produtoDAO.buscarTodos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + 
                                   " | Preço Custo: " + produto.getPrecoCusto() + 
                                   " | Preço Venda: " + produto.getPrecoVenda());
            }
        }
    }
    //Atualiza o Produto
    private static void atualizarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        Produto produto = produtoDAO.buscarPorId(id);

        if (produto != null) {
            System.out.print("Digite o novo nome do produto: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo preço de custo: ");
            double novoPrecoCusto = scanner.nextDouble();
            System.out.print("Digite o novo preço de venda: ");
            double novoPrecoVenda = scanner.nextDouble();
            scanner.nextLine(); // Limpar buffer

            produto.setNome(novoNome);
            produto.setPrecoCusto(novoPrecoCusto);
            produto.setPrecoVenda(novoPrecoVenda);

            produtoDAO.atualizar(produto);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }
    //Deleta o Produto
    private static void deletarProduto(Scanner scanner, ProdutoDAO produtoDAO) {
        System.out.print("Digite o ID do produto a ser deletado: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Limpar buffer
        produtoDAO.deletar(id);
        System.out.println("Produto deletado com sucesso, se existia.");
    }
}
