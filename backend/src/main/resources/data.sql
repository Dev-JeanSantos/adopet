INSERT INTO tb_tutor( name, email, password, cpf, address,city,uf,phone,image)VALUES ('Jean Santos', 'jeancbsan@email.com','$2a$12$d8ppSn9Hn9YBGXDNVNJQhOTuTpbEgNdR5H4Kk4D2RCngUNFg6bsQq','000000000-01','Rua Sete de Maio, S/N Vila Madalena','Sorocoba','SP','12-699667738','www.imagem-1.com.br')
INSERT INTO tb_tutor( name, email, password, cpf, address,city,uf,phone,image)VALUES ('Paulo Pedro', 'paulinho@gmail.com','$2a$12$d8ppSn9Hn9YBGXDNVNJQhOTuTpbEgNdR5H4Kk4D2RCngUNFg6bsQq','000000000-00','Rua Sete de Maio, S/N Vila Madalena','Sorocoba','SP','12-699667738','www.imagem-1.com.br')
INSERT INTO tb_tutor( name, email, password, cpf, address,city,uf,phone,image)VALUES ('Marta França', 'martinha@gmail.com','losoos22','111111111-11','Rua F, 200 Centro','Abatuba','SP','13-699667738','www.imagem-2.com.br')
INSERT INTO tb_tutor( name, email, password, cpf, address,city,uf,phone,image)VALUES ('Deise Alcantara', 'deisinha@gmail.com','22d993%%','222222222-22','Rua Flamengo, 89200 Gavea','Rio de Janeiro','RJ','21-699667738','www.imagem-3.com.br')
INSERT INTO tb_tutor( name, email, password, cpf, address,city,uf,phone,image)VALUES ('Felipe José', 'felipinho@gmail.com','00od99','333333333-33','Rua Mario Quintana, 899 Centro','Friburgo','RJ','22-699667738','www.imagem-4com.br')

INSERT INTO tb_shelter( name, email, cnpj, address,city,uf,phone,image,responsible_id)VALUES ('Canil dos Amigos', 'canil@gmail.com','75.980.748/0001-06','Rua Francisco Toledo, 99 Centro','Friburgo','RJ','22-27475548','www.canilamigos-1-com.br',4)
INSERT INTO tb_shelter( name, email, cnpj, address,city,uf,phone,image,responsible_id)VALUES ('veterinaria Barreto', 'vetbarreto@gmail.com','88.980.748/0001-12','Rua Francisco Toledo, 99 Centro','São Paulo','SP','22-27475548','www.canilamigos-1-com.br',1)
INSERT INTO tb_shelter( name, email, cnpj, address,city,uf,phone,image,responsible_id)VALUES ('Veterinaria Caes e Gatos', 'veterinariaceg@gmail.com','95.980.748/0001-85','Rua Francisco Toledo, 99 Centro','Goiania','GO','22-27475548','www.canilamigos-1-com.br',2)
INSERT INTO tb_shelter( name, email, cnpj, address,city,uf,phone,image,responsible_id)VALUES ('Casa de Animais Brasil', 'cab@gmail.com','82.980.748/0001-52','Rua Francisco Toledo, 99 Centro','Natal','RN','22-27475548','www.canilamigos-1-com.br',1)
INSERT INTO tb_shelter( name, email, cnpj, address,city,uf,phone,image,responsible_id)VALUES ('Abrigo dos Pets', 'abrigodospets@gmail.com','66.980.748/0001-00','Rua Francisco Toledo, 99 Centro','Pirai','RJ','22-27475548','www.canilamigos-1-com.br',3)
INSERT INTO tb_shelter( name, email, cnpj, address,city,uf,phone,image,responsible_id)VALUES ('Abrigo dos Pets II', 'abrigodospetsii@gmail.com','77.980.748/0001-00','Rua Amaral Peixoto, 2009 Vila Mirian','Pirai','RJ','22-27475548','www.canilamigos-1-com.br',3)

INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Thorzinho', 3,10,'MONTH', 'AVAILABLE','LARGE','DOG','AGGRESSIVE','late muito e estranha as crianças','www.imagemcachorro-1-com.br','FEMALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Barão', 3,12,'YEAR', 'AVAILABLE','SMALL','DOG','PASSIVE','late muito e estranha as crianças','www.imagemcachorro-3-com.br','MALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Nucita',4,8,'MONTH', 'AVAILABLE','GIANT','CAT','PASSIVE','late muito e estranha as crianças','www.imagemcachorro-4-com.br','FEMALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Mickey',2,4,'YEAR', 'AVAILABLE','MINI','DOG','ASSERTIVE','late muito e estranha as crianças','www.imagemcachorro-5-com.br','MALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Barao', 1,11,'MONTH', 'AVAILABLE','SMALL','DOG','ASSERTIVE','late muito e estranha as crianças','www.imagemcachorro-6-com.br','FEMALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Todynho',2,16,'YEAR', 'AVAILABLE','MINI','CAT','PASSIVE','late muito e estranha as crianças','www.imagemcachorro-7-com.br','FEMALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Marry', 3,1,'YEAR', 'AVAILABLE','LARGE','CAT','ASSERTIVE','late muito e estranha as crianças','www.imagemcachorro-2-com.br','FEMALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Mauricio',1,5,'YEAR', 'AVAILABLE','MEDIUM','CAT','AGGRESSIVE','late muito e estranha as crianças','www.imagemcachorro-8-com.br','MALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Chokito',3,8,'YEAR', 'AVAILABLE','MEDIUM','CAT','ASSERTIVE','late muito e estranha as crianças','www.imagemcachorro-9-com.br','MALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')
INSERT INTO tb_pet( name,  shelter_id, age, age_month_or_year,status,carrying,specie,personality,description,image,genre, date_create)VALUES ('Baby',5,1,'MONTH', 'AVAILABLE','SMALL','DOG','PASSIVE','late muito e estranha as crianças','www.imagemcachorro-10-com.br','FEMALE', TIMESTAMP WITH TIME ZONE '2023-04-12T21:00:00Z')

INSERT INTO role( id, name)VALUES (1 , 'READ_WRITE')
INSERT INTO tb_tutor_role( tutor_id, role_id)VALUES ( 1, 1)


--Queries para Implementar
--Devolve nome e cidade do shelter e a quantidades (count)de pets que cada um possui?
--SELECT s.name Nome_do_Abrigo, s.city Cidade_do_Abrigo, count(*) Quantidade_de_Pets FROM tb_shelter s INNER JOIN tb_pet p ON s.id = p.shelter_id GROUP BY s.name, s.city