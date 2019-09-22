CREATE TABLE Persons(
  perId serial primary key not null,
  perNombre varchar,
  perApellido varchar,
  perFechaNacimiento date,
  perNumeroDocumento bigint,
  perTipoDocumento varchar
);

CREATE TABLE DocTypes(
  Id serial primary key not null,
  TextType varchar,
  Enabled boolean default true
);

INSERT INTO DocTypes
(TextType)
VALUES
('DNI'),
 ('PASAPORTE'),
 ('CEDULA');

 INSERT INTO Persons
 (perNombre, perApellido, perFechaNacimiento, perNumeroDocumento, perTipoDocumento)
 VALUES
 ('Matias', 'Rivero', to_date('18/09/1992', 'DD/MM/YYYY'), 36133395, 'DNI'),
 ('Angel', 'Zimmerman', to_date('25/04/2000', 'DD/MM/YYYY'), 28499511, 'PASAPORTE'),
 ('Cintia', 'Rosales', to_date('23/12/1995', 'DD/MM/YYYY'), 74852963, 'DNI'),
 ('Mariano', 'Cordoba', to_date('10/08/1993', 'DD/MM/YYYY'), 14258369, 'DNI'),
 ('Vanesa', 'Grumelli', to_date('03/03/1997', 'DD/MM/YYYY'), 78456123, 'DNI'),
 ('Martin', 'Gonzalez', to_date('17/01/1990', 'DD/MM/YYYY'), 45123789, 'DNI');

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO hard_name
