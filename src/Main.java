import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoFuncs produtoFuncs = new ProdutoFuncs();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Estoque:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Editar Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Remover Produto");
            System.out.println("5. Buscar Produto");
            System.out.println("6. Verificar Estoque Mínimo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Categoria categoria = new Categoria(1, "Eletrônicos", "Dispositivos eletrônicos");
                    Fornecedor fornecedor = new Fornecedor(1, "Tech Delulu", "123456789", "contato@techdelulu.com", "Avenida Tecnologia, 101");
                    Produto produto = new Produto(1, "Xaiomi 99", "Celular", 1500.00, categoria, fornecedor);
                    produtoFuncs.adicionarProduto(produto);
                    break;
                case 2:
                    // edit
                    break;
                case 3:
                    produtoFuncs.listarProdutos();
                    break;
                case 4:
                    System.out.print("Informe o ID do produto para remover: ");
                    int id = scanner.nextInt();
                    produtoFuncs.removerProduto(id);
                    break;
                case 5:
                    System.out.print("Informe o ID do produto para buscar: ");
                    id = scanner.nextInt();
                    Produto prodBuscado = produtoFuncs.searchProduto(id);
                    System.out.println("Produto encontrado: " + prodBuscado);
                    break;
                case 6:
                    System.out.print("Informe a quantidade mínima: ");
                    int qtMinima = scanner.nextInt();
                    produtoFuncs.checkQtdMin(qtMinima);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
