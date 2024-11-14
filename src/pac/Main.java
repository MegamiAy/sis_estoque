package pac;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // para interagir com as funções dentro dessas classes/interface
        ProdutoFuncs produtoFuncs = new ProdutoFuncs();
        CategoriaFuncs categoriaFuncs = new CategoriaFuncs();
        FornecedorFuncs fornecedorFuncs = new FornecedorFuncs();
        EstoqueFuncs estoqueFuncs = new EstoqueFuncs();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nSistema de Estoque:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Editar Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Remover Produto");
            System.out.println("5. Verificar Estoque Mínimo");
            System.out.println("6. Listar Categorias");
            System.out.println("7. Listar Fornecedores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                	produtoFuncs.addProd();
                    break;
                case 2:
                    produtoFuncs.editProd();
                    break;
                case 3:
                    produtoFuncs.listProd();
                    break;
                case 4:
                    produtoFuncs.delProd();
                    break;
                case 5:
                    produtoFuncs.checkEstoqueMin();
                    break;
                case 6:
                	categoriaFuncs.listCategorias();
                    break;
                case 7:
                	fornecedorFuncs.listFornecedores();
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
