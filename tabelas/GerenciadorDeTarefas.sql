DROP DATABASE IF EXISTS GerenciadorDeTarefas;
CREATE DATABASE GerenciadorDeTarefas DEFAULT CHARACTER SET UTF8;

USE GerenciadorDeTarefas;

CREATE TABLE usuario (
	id INT(11) AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    username VARCHAR(25) NOT NULL UNIQUE,
    email VARCHAR(25) NOT NULL UNIQUE,
    senha VARCHAR(25) NOT NULL
);

CREATE TABLE meta (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(25) NOT NULL,
	descricao VARCHAR(250),
	tags VARCHAR(200),
	prioridade INT(1) NOT NULL,
	estado BOOLEAN NOT NULL,
    id_usuario INT(11) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) 
);

CREATE TABLE tarefa (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(25) NOT NULL,
	descricao VARCHAR(250),
	tags VARCHAR(200),
	prioridade INT(1) NOT NULL,
	data_tarefa VARCHAR(10) NOT NULL,
	estado BOOLEAN NOT NULL,
    id_usuario INT(11) NOT NULL,
	FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);