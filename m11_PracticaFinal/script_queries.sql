
USE m11practicafinal;

drop table vacaciones;
drop table registroempleado;
drop table proyecto_trabajadores;
drop table trabajador;
drop table proyecto;
drop table empresa;

select * from m11practicafinal.trabajador;
insert into m11practicafinal.trabajador values(3,"9234572A","Eren","Jeager","erenj@gmail.com","12345",23398498,"RRHH");
insert into m11practicafinal.trabajador values(1,"1234567G","Dani","Hernandez Arcos","daniha@gmail.es","12345",123456789,"Empleado");
insert into m11practicafinal.trabajador values(2,"5125231H","William","Wallace","wwallace@gmail.com","12345",543216879,"Empleado");
insert into m11practicafinal.trabajador values(4,"1111111A","Prueba","Prueba","prueba@gmail.com","12345",111111111,"Empleado");
select * from trabajador;
ALTER TABLE m11practicafinal.trabajador 
DROP COLUMN id_proyecto;

select * from proyecto_trabajadores;
select id_proyecto from proyecto_trabajadores where iden_trabajador=1;
insert into proyecto values("Proyecto1",0,"Hello there","A71356125");
insert into proyecto values("Proyecto2",0,"Nuevo proyecto","A71356125");
insert into proyecto_trabajadores values("Proyecto1",1,0);
insert into proyecto_trabajadores values("Proyecto2",2,0);
select * from proyecto_trabajadores;
select * from proyecto;

delete from proyecto where id="Proyecto2";

delete from proyecto_trabajadores where id_proyecto = "Proyecto2";
select * from proyecto_trabajadores;

select * from empresa;
insert into m11practicafinal.proyecto values("Proyecto2",0,"Nuevo proyecto","A71356125");

insert into peticiones values(1,1,"Vacaciones","Pendiente",'2021-12-24');
select * from peticiones;
delete from peticiones where reqid=1;
update peticiones set resolucion="Pendiente" where reqid=1;
drop table peticiones;

insert into empresa values("A71356125","Empresa1","C\Mar cantabrico 5, 102",28921,"Rivas","Madrid",217418123);
insert into empresa values("A11111111","Empresa2","C\unisiona 1, 111",11111,"Madrid","Madrid",111111111);
select * from empresa;