CREATE USER hard_name WITH PASSWORD 'strong_password';
CREATE DATABASE dbpersons;
\connect dbpersons
GRANT ALL PRIVILEGES ON DATABASE dbpersons TO hard_name;
