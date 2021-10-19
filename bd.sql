-- Creacion de la base de datos

create database webservice;

use webservice;

create table monstruos(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    especie VARCHAR(255) NOT NULL,
    habitat VARCHAR(255) NOT NULL,
    debilidades VARCHAR(255) NOT NULL
);
