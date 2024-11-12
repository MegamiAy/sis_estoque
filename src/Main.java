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
            System.out.println("5. Verificar Estoque Mínimo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Produto:");
                    System.out.print("Informe o ID do Produto: ");
                    int idAdd = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Informe o Nome do Produto: ");
                    String nomeAdd = scanner.nextLine();
                    System.out.print("Informe a Descrição do Produto: ");
                    String descAdd = scanner.nextLine();
                    System.out.print("Informe o Preço do Produto: ");
                    double precoAdd = scanner.nextDouble();
                    System.out.print("Informe o ID da Categoria: ");
                    int idCatAdd = scanner.nextInt();
                    System.out.print("Informe o ID do Fornecedor: ");
                    int idFornAdd = scanner.nextInt();
            
                    Categoria categoriaAdd = new Categoria(idCatAdd, "Alimentos", "uiuiuiui");
                    Fornecedor fornecedorAdd = new Fornecedor(idFornAdd, "Fornecedor Aurora", "123456789", "email@fornecedor.com", "rua das serpentes largas");
                    Produto novoProduto = new Produto(idAdd, nomeAdd, descAdd, precoAdd, categoriaAdd, fornecedorAdd);
                    
                    produtoFuncs.addProd(novoProduto);
                    break;
                case 2:
                    System.out.println("Editar Produto:");
                    System.out.print("Informe o ID do Produto para editar: ");
                    int idEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe o Novo Nome do Produto: ");
                    String nomeEdit = scanner.nextLine();
                    System.out.print("Informe a Nova Descrição do Produto: ");
                    String descEdit = scanner.nextLine();
                    System.out.print("Informe o Novo Preço do Produto: ");
                    double precoEdit = scanner.nextDouble();
                    System.out.print("Informe o Novo ID da Categoria: ");
                    int idCatEdit = scanner.nextInt();
                    System.out.print("Informe o Novo ID do Fornecedor: ");
                    int idFornEdit = scanner.nextInt();
            
                    produtoFuncs.editProd(idEdit, nomeEdit, descEdit, precoEdit, idCatEdit, idFornEdit);
                    break;
                case 3:
                    produtoFuncs.listProd();
                    break;
                case 4:
                    List<Produto> produtos = produtoFuncs.listProd();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                    } else {
                        System.out.println("Lista de Produtos:");
                        for (Produto produto : produtos) {
                            System.out.printf("ID: %d, Nome: %s, Descrição: %s, Preço: %.2f, Categoria ID: %d, Fornecedor ID: %d%n",
                                    produto.getId(), produto.getNome(), produto.getDesc(), produto.getPreco(),
                                    produto.getCategoria().getId(), produto.getFornecedor().getId());
                        }
                    }
                    break;
                case 5:
                    System.out.print("Informe o ID do produto e a quantidade mínima para verificar: ");
                    id = scanner.nextInt();
                    int qtMinima = scanner.nextInt();
                    produtoFuncs.checkEstoqueMin(id, qtMinima);
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
