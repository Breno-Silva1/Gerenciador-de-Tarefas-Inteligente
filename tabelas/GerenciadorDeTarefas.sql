DROP DATABASE IF EXISTS GerenciadorDeTarefas;
CREATE DATABASE GerenciadorDeTarefas DEFAULT CHARACTER SET UTF8;

USE GerenciadorDeTarefas;

CREATE TABLE usuario (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(200),
    username VARCHAR(25),
    email VARCHAR(25),
    senha VARCHAR(25)
);

CREATE TABLE meta (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(25) NOT NULL,
	descricao VARCHAR(250),
	tags VARCHAR(200),
	prioridade INT(1),
	estado BOOLEAN

);

CREATE TABLE tarefa (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(25) NOT NULL,
	descricao VARCHAR(250),
	tags VARCHAR(200),
	prioridade INT(1),
	data_tarefa VARCHAR(10),
	estado BOOLEAN,
    id_usuario INT,
	FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);