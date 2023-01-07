create database if not exists dbAppartement;
use dbAppartement;

create table Rue
(
  code_rue int primary key auto_increment,
  nom_rue varchar(20)
);

create table Immeuble
(
  num_immeuble int primary key auto_increment,
  nb_etage_total int,
 code_rue int,
  FOREIGN KEY (code_rue) REFERENCES Rue(code_rue)
);
create table Etage
(
  num_etage int primary key auto_increment,
  nb_appartement_tot int,
 num_immeuble int,
  FOREIGN KEY (num_immeuble) REFERENCES Immeuble(num_immeuble)
);
create table Appartement
(
  lettre_appartement varchar(20) primary key ,
  nb_pieces_total int,
 num_etage int,
  FOREIGN KEY (num_etage) REFERENCES Etage(num_etage));

insert into Rue values (1,'rueA');
insert into Rue values (2,'rueB');
insert into Rue values (3,'rueC');
insert into Rue values (4,'rueD');


insert into Immeuble values (1,4,2);
insert into Immeuble values (2,5,1);
insert into Immeuble values (3,4,4);
insert into Immeuble values (4,5,3);


insert into Etage values (1,5,2);
insert into Etage values (2,10,4);
insert into Etage values (3,7,1);
insert into Etage values (4,10,3);

insert into Appartement values ("k",7,1);
insert into Appartement values ("h",4,2);
insert into Appartement values ("l",8,3);
insert into Appartement values ("k",6,4);