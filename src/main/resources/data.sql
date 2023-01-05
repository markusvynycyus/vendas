create table categoria(
        id int auto_increment,
            nome varchar(100),
            primary key (id)
);


insert into categoria (nome) values ('Informática');
insert into categoria (nome) values ('Eletrodomésticos');
insert into categoria (nome) values ('Esporte e Lazer');
insert into categoria (nome) values ('ELetrônicos');


create table vendedor(
      id int auto_increment,
      nome varchar(100),
      primary key (id)

);

insert into vendedor (nome) values ('Antonio Carlos ');
insert into vendedor (nome) values ('Maria Claudia');
insert into vendedor (nome) values ('Julliana Oliveira');
insert into vendedor (nome) values ('João Francisco');


create table usuario(
        id int auto_increment,
            nome varchar(100),
            email varchar(100),
            senha varchar(50),
            dataCadastro DATE,
            primary key (id)
);


insert into usuario (nome,email,senha,dataCadastro) values ('Marcos Venicios','marcos@gmail.com','123','2023-01-01');
insert into usuario (nome,email,senha,dataCadastro) values ('Carla Alves','carla@gmail.com','123','2023-01-01');
insert into usuario (nome,email,senha,dataCadastro) values ('Teresa Cristina','teresa@gmail.com','123','2023-01-01');


create table produto(
        id int auto_increment,
            nome varchar(100),
            descricao varchar(100),
            preco DECIMAL(15,2),
            primary key (id)
);


insert into produto (nome,descricao,preco) values ('Notebook Samsung Book Intel Core i5','Esse modelo de computador portátil, tem design discreto e elegante','1.000');
insert into produto (nome,descricao,preco) values ('Notebook Dell','Esse modelo de computador portátil, tem design discreto e elegante','2.000');
insert into produto (nome,descricao,preco) values ('Monitor 22" ','Esse modelo de computador portátil, tem design discreto e elegante','500.00');
insert into produto (nome,descricao,preco) values ('Notebook Samsung Book Intel Core i5','Esse modelo de computador portátil, tem design discreto e elegante','6.00');
insert into produto (nome,descricao,preco) values ('Notebook Samsung Book Intel Core i5','Esse modelo de computador portátil, tem design discreto e elegante','6.00');
insert into produto (nome,descricao,preco) values ('Notebook Samsung Book Intel Core i5','Esse modelo de computador portátil, tem design discreto e elegante','6.00');