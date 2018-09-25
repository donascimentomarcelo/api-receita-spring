delete from endereco;
delete from usuario;
delete from engrediente;
delete from receita;

ALTER SEQUENCE seq_id_endereco RESTART WITH 1;
ALTER SEQUENCE seq_id_engrediente RESTART WITH 1;
ALTER SEQUENCE seq_id_receita RESTART WITH 1;
ALTER SEQUENCE seq_id_usuario RESTART WITH 1;