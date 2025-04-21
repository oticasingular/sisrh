
DROP TABLE IF EXISTS solicitacao;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS empregado;

CREATE TABLE empregado (
    matricula VARCHAR(10) NOT NULL,
    nome VARCHAR(256),
    admissao DATE,
    desligamento DATE,
    salario FLOAT,
    PRIMARY KEY (matricula)
);

CREATE TABLE usuario (
    nome VARCHAR(256),    
    perfil INTEGER,
    senha VARCHAR(256),  
    matricula VARCHAR(10),
    PRIMARY KEY (nome)
);

CREATE TABLE solicitacao (
    id INTEGER NOT NULL,
    data TIMESTAMP WITHOUT TIME ZONE,
    descricao VARCHAR(256),
    situacao INTEGER,
    matricula VARCHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (matricula) REFERENCES empregado(matricula)
);
