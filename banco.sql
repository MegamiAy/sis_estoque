-- criados na ordem de necessidade
/* 
Produto precisa de categoria e de fornecedor
Estoque precisa de produto
*/
CREATE DATABASE EstoqueDB;
USE EstoqueDB;

-- Tabela Marca
CREATE TABLE Marca (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    origem VARCHAR(255)
);

-- Tabela Categoria
CREATE TABLE Categoria (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255)
);

-- Tabela Fornecedor
CREATE TABLE Fornecedor (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(15),
    email VARCHAR(255),
    endereco VARCHAR(255)
);

-- Tabela Produto
CREATE TABLE Produto (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DOUBLE,
    id_marca INT,
    id_categoria INT,
    id_fornecedor INT,
    FOREIGN KEY (id_marca) REFERENCES Marca(id),
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id),
    FOREIGN KEY (id_fornecedor) REFERENCES Fornecedor(id)
);

-- Tabela Estoque
CREATE TABLE Estoque (
    id INT PRIMARY KEY,
    id_produto INT,
    quantidade INT,
    FOREIGN KEY (id_produto) REFERENCES Produto(id)
);
