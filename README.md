# Sistema de Estoque
> Por: Gabrieli Lembeck e Laiz Detros

Um sistema projetado para gerenciar produtos e facilitar operações como adição, edição, listagem e verificação de itens em estoque. Ideal para pequenas e médias empresas que precisam manter um controle eficiente e organizado de seus produtos e fornecedores.

### Funcionalidades
- **Adicionar Produto**: Permite a inclusão de um novo produto ao sistema, especificando detalhes como fornecedor e categoria.
- **Editar Produto**: Atualiza informações de um produto existente, como quantidade e categoria.
- **Listar Produtos**: Exibe todos os produtos cadastrados no sistema, com informações detalhadas.
- **Deletar Produto**: Remove um produto do estoque.
- **Checar Estoque**: Verifica a quantidade de cada produto, alertando quando atingir o limite mínimo.

### Regras de Negócio
- **Quantidade Mínima no Estoque**: Cada produto tem uma quantidade mínima definida no sistema. Quando o estoque de um produto atinge ou fica abaixo desse valor, o sistema emite um alerta para reposição.
- **Associação de Produto**: Todos os produtos devem estar associados a um fornecedor e a uma categoria, facilitando a rastreabilidade e organização.

### Tecnologias Utilizadas
- **Java**: Linguagem principal para desenvolvimento do sistema.
- **MySQL**: Banco de dados utilizado para armazenar informações sobre produtos, fornecedores e categorias.
- **JDBC**: Biblioteca de conexão entre o Java e o MySQL.

### Configuração e Instalação
1. Clone o repositório: `git clone https://github.com/MegamiAy/sis_estoque.git`
2. Importe o banco de dados (`estoque.sql`) em seu sistema de gerenciamento de banco de dados.
3. Configure as credenciais de conexão no arquivo `ConexaoMySQL.java`:
   - Usuário do banco de dados: `root`
   - Senha: ``

### Banco de Dados
![image](https://github.com/user-attachments/assets/2dff072b-e3b3-4ab6-9585-3b0a7e8ccc6d)

### Diagrama de Classes
![image](https://github.com/user-attachments/assets/d8178735-1389-4359-a45a-87bc4e2943e5)
