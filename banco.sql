-- criados na ordem de necessidade
/* 
Produto precisa de categoria e de fornecedor
Estoque precisa de produto
*/
CREATE DATABASE EstoqueDB;
USE EstoqueDB;

CREATE TABLE fornecedor (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    fone VARCHAR(15),
    email VARCHAR(255),
    endereco VARCHAR(255)
);

CREATE TABLE categoria (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255)
);

CREATE TABLE produto (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    preco DOUBLE,
    id_cat INT,
    id_forn INT,
    FOREIGN KEY (id_cat) REFERENCES categoria(id),
    FOREIGN KEY (id_forn) REFERENCES fornecedor(id)
);

CREATE TABLE estoque (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_prod INT NOT NULL,
    quantidade INT,
    FOREIGN KEY (id_prod) REFERENCES produto(id)
);

-- Selecionamos o banco de dados criado
USE EstoqueDB;

-- Inserindo registros na tabela 'fornecedor'
INSERT INTO fornecedor (nome, fone, email, endereco) VALUES
('Tech Delulu', '123456789', 'contato@techdelulu.com', 'Avenida Tecnologia, 101'),
('Veste Bem', '987654321', 'contato@vestebem.com', 'Rua das Confecções, 202'),
('Alimentos Fast', '555444333', 'contato@alimentosfast.com', 'Praça das Frutas, 303'),
('Pao Velho', '11 9999-6666', 'distribuidora@paovelho.com.br', 'Rua da Cascavel, 123');

-- Inserindo registros na tabela 'categoria'
INSERT INTO categoria (nome, descricao) VALUES
('Eletrônicos', 'Dispositivos eletrônicos em geral'),
('Vestuário', 'Roupas e acessórios'),
('Alimentos', 'Produtos alimentícios e bebidas');

-- Inserindo registros na tabela 'produto'
-- Lembrando que a coluna id_cat refere-se à categoria e id_forn refere-se ao fornecedor
INSERT INTO produto (nome, descricao, preco, id_cat, id_forn) VALUES
('Xaiomi 99', 'Celular de última geração', 1500.00, 1, 1),
('Notebook Positivo', 'Notebook capenga', 3000.00, 1, 2),
('Camisa Preta', 'Camisa de algodão sem estampa de cor preta', 50.00, 2, 3),
('Dollynho Guarana', 'Refrigerante de 2 litros, o sabor brasileiro!', 5.00, 3, 1);

-- Inserindo registros na tabela 'estoque'
-- Utiliza o id dos produtos criados acima
INSERT INTO estoque (id_prod, quantidade) VALUES
(1, 100),  -- Estoque para o 'Celular'
(2, 50),   -- Estoque para o 'Notebook'
(3, 200),  -- Estoque para a 'Camisa'
(4, 500);  -- Estoque para o 'Refrigerante'
