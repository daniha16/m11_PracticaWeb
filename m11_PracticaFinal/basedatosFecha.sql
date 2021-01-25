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
	nombre char(30),
	direccion char(50),
	codigo_postal integer,
	poblacion char(10),
	provincia char(10),
	telefono integer,
	CONSTRAINT empresa_pk PRIMARY KEY (cif)

);
-- ddl-end --

-- ddl-end --

-- object: public.proyecto | type: TABLE --
-- DROP TABLE IF EXISTS public.proyecto CASCADE;

CREATE TABLE IF NOT EXISTS proyecto(
	id char(30) NOT NULL,
	tiempo float,
	descripcion text,
	cif_empresa char(10),
	CONSTRAINT proyecto_pk PRIMARY KEY (id)
);
-- ddl-end --


-- object: empresa_fk | type: CONSTRAINT --
-- ALTER TABLE public.proyecto DROP CONSTRAINT IF EXISTS empresa_fk CASCADE;
ALTER TABLE m11practicafinal.proyecto ADD CONSTRAINT empresa_fk FOREIGN KEY (cif_empresa)
REFERENCES m11practicafinal.empresa (cif) MATCH FULL
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
	tipo char(20),
	CONSTRAINT trabajador_pk PRIMARY KEY (iden)

);
-- ddl-end --

-- object: public.vacaciones | type: TABLE --
-- DROP TABLE IF EXISTS public.vacaciones CASCADE;
CREATE TABLE IF NOT EXISTS vacaciones(
	inicio timestamp,
    fin timestamp,
	fecha date,
	iden_trabajador integer,
    tipo char(20)
);
-- ddl-end --
-- ddl-end --

-- object: trabajador_fk | type: CONSTRAINT --
-- ALTER TABLE public.vacaciones DROP CONSTRAINT IF EXISTS trabajador_fk CASCADE;
ALTER TABLE m11practicafinal.vacaciones ADD CONSTRAINT trabajador_fk FOREIGN KEY (iden_trabajador)
REFERENCES m11practicafinal.trabajador (iden) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."registroEmpleado" | type: TABLE --
-- DROP TABLE IF EXISTS public."registroEmpleado" CASCADE;
CREATE TABLE IF NOT EXISTS registroEmpleado(
	entrada timestamp,
	salida timestamp,
	iden_trabajador integer,
	fecha date
);
-- ddl-end --
-- ddl-end --

-- object: trabajador_fk | type: CONSTRAINT --
-- ALTER TABLE public."registroEmpleado" DROP CONSTRAINT IF EXISTS trabajador_fk CASCADE;
ALTER TABLE registroEmpleado ADD CONSTRAINT regtrabajador_fk FOREIGN KEY (iden_trabajador)
REFERENCES m11practicafinal.trabajador (iden) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public.proyecto_trabajadores | type: TABLE --
-- DROP TABLE IF EXISTS public.proyecto_trabajadores CASCADE;
CREATE TABLE m11practicafinal.proyecto_trabajadores(
	id_proyecto char(30) NOT NULL,
	iden_trabajador integer NOT NULL,
    horas float NOT NULL,
	CONSTRAINT proyecto_trabajadores_pk PRIMARY KEY (id_proyecto,iden_trabajador)

);
-- ddl-end --

-- object: proyecto_fk | type: CONSTRAINT --
-- ALTER TABLE public.proyecto_trabajadores DROP CONSTRAINT IF EXISTS proyecto_fk CASCADE;
ALTER TABLE m11practicafinal.proyecto_trabajadores ADD CONSTRAINT proyecto_fk FOREIGN KEY (id_proyecto)
REFERENCES m11practicafinal.proyecto (id) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --

-- object: trabajador_fk | type: CONSTRAINT --
-- ALTER TABLE public.proyecto_trabajadores DROP CONSTRAINT IF EXISTS trabajador_fk CASCADE;
ALTER TABLE m11practicafinal.proyecto_trabajadores ADD CONSTRAINT proyecto_trabajador_fk FOREIGN KEY (iden_trabajador)
REFERENCES m11practicafinal.trabajador (iden) MATCH FULL
ON DELETE RESTRICT ON UPDATE CASCADE;
-- ddl-end --


CREATE TABLE IF NOT EXISTS peticiones(
	reqid integer NOT NULL,
	iden integer,
	concepto text,
    resolucion char(20),
    fecha date,
    inicio time,
    fin time,
    tipo char(20),
    CONSTRAINT peticiones_pk PRIMARY KEY (reqid)
);
-- ddl-end --
