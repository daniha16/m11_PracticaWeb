-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.1
-- PostgreSQL version: 10.0
-- Project Site: pgmodeler.io
-- Model Author: ---


-- Database creation must be done outside a multicommand file.
-- These commands were put in this file only as a convenience.
-- -- object: new_database | type: DATABASE --
-- -- DROP DATABASE IF EXISTS new_database;
-- CREATE DATABASE new_database;
-- -- ddl-end --
-- 

-- object: public.empresa | type: TABLE --
-- DROP TABLE IF EXISTS public.empresa CASCADE;
CREATE DATABASE IF NOT EXISTS m11practicafinal;
USE m11practicafinal;
CREATE TABLE IF NOT EXISTS empresa(
	cif char(10) NOT NULL,
	nombre char(20),
	direccion char(50),
	codigo_postal char(10),
	poblacion char(10),
	provincia char(10),
	telefono integer,
	CONSTRAINT empresa_pk PRIMARY KEY (cif)

);
-- ddl-end --

-- object: public.proyecto | type: TABLE --
-- DROP TABLE IF EXISTS public.proyecto CASCADE;
CREATE TABLE IF NOT EXISTS proyecto(
	id char(5) NOT NULL,
	tiempo integer,
	descripcion text,
	cif_empresa char(10),
	CONSTRAINT proyecto_pk PRIMARY KEY (id)

);
-- ddl-end --

-- object: empresa_fk | type: CONSTRAINT --
-- ALTER TABLE public.proyecto DROP CONSTRAINT IF EXISTS empresa_fk CASCADE;
ALTER TABLE proyecto ADD CONSTRAINT empresa_fk FOREIGN KEY (cif_empresa)
REFERENCES empresa (cif) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.trabajador | type: TABLE --
-- DROP TABLE IF EXISTS public.trabajador CASCADE;
CREATE TABLE IF NOT EXISTS trabajador(
	iden integer NOT NULL,
	dni char(10),
	nombre char(10),
	apellidos char(25),
	correo char(20),
	contrasena char(40),
	telefono integer,
	id_proyecto char(5),
	horas float,
	tipo char(20),
	CONSTRAINT trabajador_pk PRIMARY KEY (iden)

);
-- ddl-end --

-- object: proyecto_fk | type: CONSTRAINT --
-- ALTER TABLE public.trabajador DROP CONSTRAINT IF EXISTS proyecto_fk CASCADE;
ALTER TABLE trabajador ADD CONSTRAINT proyecto_fk FOREIGN KEY (id_proyecto)
REFERENCES proyecto (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.vacaciones | type: TABLE --
-- DROP TABLE IF EXISTS public.vacaciones CASCADE;
CREATE TABLE IF NOT EXISTS vacaciones(
	startdate timestamp,
	enddate timestamp,
	iden_trabajador integer
);
-- ddl-end --

-- object: trabajador_fk | type: CONSTRAINT --
-- ALTER TABLE public.vacaciones DROP CONSTRAINT IF EXISTS trabajador_fk CASCADE;
ALTER TABLE vacaciones ADD CONSTRAINT trabajador_fk FOREIGN KEY (iden_trabajador)
REFERENCES trabajador (iden) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."registroEmpleado" | type: TABLE --
-- DROP TABLE IF EXISTS public."registroEmpleado" CASCADE;
CREATE TABLE IF NOT EXISTS registroEmpleado(
	entrada timestamp,
	salida timestamp,
	iden_trabajador integer
);
-- ddl-end --

-- object: trabajador_fk | type: CONSTRAINT --
-- ALTER TABLE public."registroEmpleado" DROP CONSTRAINT IF EXISTS trabajador_fk CASCADE;
ALTER TABLE registroEmpleado ADD CONSTRAINT regtrabajador_fk FOREIGN KEY (iden_trabajador)
REFERENCES trabajador (iden) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --



