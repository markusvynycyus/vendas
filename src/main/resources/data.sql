create table categoria(
        id int auto_increment,
            nome varchar(100),
            primary key (id)
);
insert into categoria (nome) values ('Informática');
insert into categoria (nome) values ('Eletrodomésticos');
insert into categoria (nome) values ('Esporte e Lazer');
insert into categoria (nome) values ('ELetrônicos');


--insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 0, 1);
--insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
