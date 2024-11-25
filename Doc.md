## Quais são e onde ficam as regras de negócio:

- Verificação de estoque: ver se está a baixo do minimo...
- Todos os produtos devem ter Fornecedor e Categoria associados

- função: checkEstoqueMin() em ProdutoFuncs. Acessado pela op 3 da main.
- função: addProd(), onde pede para digitar o número(id) da categoria e do fornecedor, só então adiciona o produto. Acessado pela op 4 da main.

## Funçõe e Classes
### Main
Função principal que exibe o menu e permite ao usuário acessar as funcionalidades do sistema. A escolha do usuário é interpretada por meio de um switch.

### Produto
Classe Produto -> declara as variáveis/atributos, getters e o toString 

ProdutoFuncs -> implementa um conjunto de funcionalidades para gerenciar produtos no banco de dados.
  - **Categorias** e **Fornecedores**: As funções interagem com as classes `CategoriaFuncs` e `FornecedorFuncs`.

### métodos de prod

addProd -> Recebe os dados do usuário. Valida o formato dos dados. Busca a categoria e o fornecedor para verificar se existem. Insere o novo produto no banco de dados.

editProd -> Lista os produtos existentes. Solicita o ID do produto. Permite ao usuário alterar (mantendo os antigos atributos, se não fornecidos). Valida e atualiza o registro no banco.

listProd -> Consulta todos os produtos no banco de dados e imprime suas informações na tela. Função usada no edit prod por exemplo.

delProd -> Pergunta o ID do produto. Remove um produto e suas referências no banco.

checkEstoqueMin -> Como dito anteriormente, verificar se o estoque de um produto está abaixo do mínimo (20 unidades).

### Helper
A classe Helper foi criada para realizar operações repetidas em vários ponto do sistema. Ela inclui:
- Métodos para aplicar máscaras (formatações e validações) em valores.
- Um método para fechar conexões com o banco de dados de maneira segura.

### Categorias e Fornecedores
Ambas tem as mesmas funções.

List -> Listar todas as categorias registradas.

buscarID -> Buscar uma categoria específica pelo ID.

### Estoque
EstoqueFuncs -> gerencia o estoque de produtos em um banco de dados. 

listEstoques-> Exibe todos os estoques registrados e suas quantidades. Usada dentro da função de editar.

editEstoque -> Permite alterar a quantidade de produtos no estoque (adicionando ou removendo). Lista os estoques atuais. Solicita o ID do produto e a quantidade a ser ajustada (positiva ou negativa). Valida. Garante que a quantidade ajustada não resulte em um estoque negativo. Recupera a quantidade atual do produto. Atualiza o valor no banco se todas as condições forem atendidas. 

## Geralzão - Tem em quase todas

package pac -> Define o pacote `pac`, que agrupa as classes relacionadas. 

import java.util.Scanner; -> Importação de Scanner.

Instância de objetos -> para acessar as funções e variáveis de dentro de cada classe

- ProdutoFuncs produtoFuncs = new ProdutoFuncs(); 
- CategoriaFuncs categoriaFuncs = new CategoriaFuncs();
- FornecedorFuncs fornecedorFuncs = new FornecedorFuncs();
- EstoqueFuncs estoqueFuncs = new EstoqueFuncs();
- Helper helper = new Helper();

connect = ConexaoMySQL.getConexaoMySQL(); -> Estabelece uma conexão com o banco de dados usando a classe ConexaoMySQL.

- **Conexão com o banco** -> Feita via `ConexaoMySQL`.
- **Validações** -> Realizadas com a ajuda da classe `Helper`.

Scanner scanner = new Scanner(System.in); -> é a criação do scanner importado.

Construtor da classe: Método especial usado para inicializar objetos.
