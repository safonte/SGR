-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sgr_simple
-- -----------------------------------------------------
-- Base de dados do Sistema Gerenciador de Restaurantes (SGR)

-- -----------------------------------------------------
-- Schema sgr_simple
--
-- Base de dados do Sistema Gerenciador de Restaurantes (SGR)
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sgr_simple` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `sgr_simple` ;

-- -----------------------------------------------------
-- Table `sgr_simple`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`pedido` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`pedido` (
  `idpedido` INT NOT NULL AUTO_INCREMENT,
  `mesa` INT NOT NULL,
  `proteina` VARCHAR(45) NULL,
  `acompanhamento1` VARCHAR(45) NULL,
  `acompanhamento2` VARCHAR(45) NULL,
  `bebida` VARCHAR(45) NULL,
  `sobremesa` VARCHAR(45) NULL,
  `garcon` VARCHAR(45) NOT NULL,
  `data_e_hora` DATETIME NOT NULL,
  `valor_pedido` DECIMAL(6,2) NOT NULL,
  `forma_pagamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpedido`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgr_simple`.`proteina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`proteina` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`proteina` (
  `idproteina` INT NOT NULL AUTO_INCREMENT,
  `nome_proteina` VARCHAR(45) NOT NULL,
  `preco_custo` DECIMAL(6,2) NOT NULL COMMENT 'preço de venda ao cliente final com margens já calculadas',
  PRIMARY KEY (`idproteina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgr_simple`.`acompanhamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`acompanhamento` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`acompanhamento` (
  `idacompanhamento` INT NOT NULL AUTO_INCREMENT,
  `nome_porcao` VARCHAR(45) NOT NULL,
  `preco_custo` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`idacompanhamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgr_simple`.`sobremesa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`sobremesa` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`sobremesa` (
  `idsobremesa` INT NOT NULL AUTO_INCREMENT,
  `nome_sobremesa` VARCHAR(45) NOT NULL,
  `preco_custo` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`idsobremesa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgr_simple`.`fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`fornecedor` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`fornecedor` (
  `idfornecedor` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(90) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `Cidade` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(2) NOT NULL,
  `contato` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idfornecedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgr_simple`.`bebida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`bebida` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`bebida` (
  `idbebida` INT NOT NULL AUTO_INCREMENT,
  `nome_bebida` VARCHAR(45) NOT NULL,
  `preco_custo` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`idbebida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgr_simple`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sgr_simple`.`usuario` ;

CREATE TABLE IF NOT EXISTS `sgr_simple`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `data_hora` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




-- Script para popular tabelas

use sgr_simple;
insert into usuario(nome,senha,tipo,data_hora) values('admin','1234','gerente',now());
insert into usuario(nome,senha,tipo,data_hora) values('carlos','1234','caixa',now());

INSERT INTO fornecedor (razao_social, cnpj, logradouro, cidade, estado, contato, telefone) VALUES
('Distribuidora Alimentos LTDA', '12345678000195', 'Rua das Flores, 123', 'Rio de Janeiro', 'RJ', 'João Silva', 21998765432),
('Bebidas e Companhia', '98765432000123', 'Avenida Central, 456', 'São Paulo', 'SP', 'Maria Oliveira', 11987654321),
('Carnes Premium LTDA', '45678912000167', 'Praça das Palmeiras, 789', 'Belo Horizonte', 'MG', 'Carlos Sousa', 31976543210),
('Doces & Sobremesas ME', '32198765000144', 'Travessa Alegre, 321', 'Curitiba', 'PR', 'Ana Lima', 41965432109),
('Peixes do Atlântico', '56789023000189', 'Rua do Mar, 555', 'Salvador', 'BA', 'Pedro Rocha', 71954321098);

INSERT INTO proteina (nome_proteina, preco_custo) VALUES
(' ',0.00),
('Filé-Mignon', 25.00),
('Frango Grelhado', 12.50),
('Costela Bovina', 18.00),
('Picanha', 30.00),
('Peixe Tilápia', 15.00),
('Carne Suína', 14.00),
('Camarão VG', 40.00),
('Alcatra', 20.00);

INSERT INTO acompanhamento (nome_porcao, preco_custo) VALUES
(' ',0.00),
('Arroz', 5.00),
('Feijão', 4.50),
('Farofa', 3.00),
('Batata Frita', 6.50),
('Salada', 4.00);

INSERT INTO bebida (nome_bebida, preco_custo) VALUES
(' ',0.00),
('Coca-Cola 350ml', 4.50),
('Coca-Cola 600ml', 6.00),
('Pepsi 350ml', 4.00),
('Pepsi 600ml', 5.50),
('Cerveja Heineken 355ml', 7.50),
('Cerveja Brahma 350ml', 6.00),
('Água Mineral 500ml', 2.50),
('Suco Del Valle 1L', 8.00);

INSERT INTO sobremesa (nome_sobremesa, preco_custo) VALUES
(' ',0.00),
('Pudim', 8.00),
('Mousse de Chocolate', 6.50),
('Torta de Limão', 7.00),
('Brigadeiro', 2.50),
('Sorvete de Baunilha', 5.00),
('Cheesecake', 10.00),
('Bolo de Cenoura', 6.00),
('Cocada', 4.00);


