-- criados na ordem de necessidade
/* 
Produto precisa de categoria e de fornecedor
Estoque precisa de produto
*/
CREATE DATABASE EstoqueDB;
USE EstoqueDB;

CREATE TABLE fornecedor (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    fone VARCHAR(15),
    email VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE categoria (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255)
);

CREATE TABLE produto (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DOUBLE,
    id_cat INT,
    id_forn INT,
    FOREIGN KEY (id_cat) REFERENCES categoria(id),
    FOREIGN KEY (id_forn) REFERENCES fornecedor(id)
);

CREATE TABLE estoque (
    id INT PRIMARY KEY,
    id_prod INT,
    quantidade INT,
    FOREIGN KEY (id_prod) REFERENCES produto(id)
);
