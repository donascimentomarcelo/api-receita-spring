INSERT INTO usuario (id, email, nome, senha) 
	VALUES 
	('1', 'crane@gmail.com', 'Crane', '123');

INSERT INTO endereco (id, bairro, cep, complemento, localidade, logradouro, uf, usuario_id) 
	VALUES 
	('1', 'Braz de pina', '21012409', 'Rua Trinta e Seis - Braz de Pina', 'Quadra C9', NULL, 'RJ', '1');
INSERT INTO receita (id, titulo, descricao)
	VALUES
	('1', 'Bolo de Maracuja', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit');
INSERT INTO engrediente (id, descricao, medida, quantidade, id_receita) 
	VALUES 
	('1', 'Leite moça', '3', '2', '1');
INSERT INTO engrediente (id, descricao, medida, quantidade, id_receita) 
	VALUES	
	('2', 'Fubá', '4', '3', '1');
INSERT INTO engrediente (id, descricao, medida, quantidade, id_receita) 
	VALUES	
	('3', 'Leite', '2', '8', '1');