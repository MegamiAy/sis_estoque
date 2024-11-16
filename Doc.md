## Quais são e onde ficam as regras de negócio:

- Verificação de estoque: ver se está a baixo do minimo...
- Todos os produtos devem ter Fornecedor e Categoria associados

- função: checkEstoqueMin() em ProdutoFuncs. Acessado pela op 3 da main.
- função: addProd(), onde pede para digitar o número(id) da categoria e do fornecedor, só então adiciona o produto. Acessado pela op 4 da main.

## Funções

Main - Função principal que exibe o menu e permite ao usuário acessar as funcionalidades do sistema. A escolha do usuário é interpretada por meio de um switch.

## Geralzão - Tem em quase todas

package pac -> Define o pacote `pac`, que agrupa as classes relacionadas. 

import java.util.Scanner; -> Importação de Scanner.

Instância de objetos -> para acessar as funções e variáveis de dentro de cada classe/interface

- ProdutoFuncs produtoFuncs = new ProdutoFuncs(); 
- CategoriaFuncs categoriaFuncs = new CategoriaFuncs();
- FornecedorFuncs fornecedorFuncs = new FornecedorFuncs();
- EstoqueFuncs estoqueFuncs = new EstoqueFuncs();

Scanner scanner = new Scanner(System.in); -> é a criação do scanner importado.
