CREATE TABLE produto (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255),
  preco DOUBLE,
  qt_estoque INT,
  id_categoria INT,
  id_fornecedor INT
  FOREIGN KEY (id_categoria) REFERENCES categoria (id),
  FOREIGN KEY (id_fornecedor) REFERENCES fornecedor (id),
);

CREATE TABLE fornecedor (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  telefone BIGINT,
  email VARCHAR(255),
  endereco VARCHAR(255)
);

CREATE TABLE categoria (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  descricao VARCHAR(255),
);
