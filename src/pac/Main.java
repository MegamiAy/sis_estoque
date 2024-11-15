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
            System.out.println("\nEstoque:");
            System.out.println("1. Verificar Estoque de Prodtos atual"); //LIST
            System.out.println("2. Alterar estoque"); 
            System.out.println("3. Verificar Estoque Mínimo");
            System.out.println("\nProduto:");
            System.out.println("4. Adicionar Produto");
            System.out.println("5. Editar Produto"); 
            System.out.println("6. Listar Produtos");
            System.out.println("8. Remover Produto");
            System.out.println("\nOutros:");
            System.out.println("7. Listar Categorias");
            System.out.println("9. Listar Fornecedores");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
            	case 1:
            		estoqueFuncs.listEstoques();
            		break;
            	case 2:
            		estoqueFuncs.editEstoque();
                	break;
                case 3:
                	produtoFuncs.checkEstoqueMin();
                    break;
                case 4:
                	produtoFuncs.addProd();
                    break;
                case 5:
                	produtoFuncs.editProd();
                    break;
                case 6:
                	produtoFuncs.listProd();
                    break;
                case 7:
                	produtoFuncs.delProd();
                    break;
                case 8:
                	categoriaFuncs.listCategorias();
                    break;
                case 9:
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
