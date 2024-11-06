-- criados na ordem de necessidade
/* 
Produto precisa de categoria e de fornecedor
Estoque precisa de produto
*/

CREATE TABLE fornecedor (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  fone BIGINT,
  email VARCHAR(255),
  endereco VARCHAR(255)
);

CREATE TABLE categoria (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255),
);

CREATE TABLE produto (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255),
  preco DECIMAL(10, 2),
  id_cat INT,
  id_forn INT,
  FOREIGN KEY (id_cat) REFERENCES categoria (id),
  FOREIGN KEY (id_forn) REFERENCES fornecedor (id)
);

CREATE TABLE estoque (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  id_prod INT,
  quantidade BIGINT,
  FOREIGN KEY (id_prod) REFERENCES produto (id)
);
