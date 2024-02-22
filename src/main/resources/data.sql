/* SUPPRESSION DES TABLES EXISTANTE */
DROP TABLE IF EXISTS hospital_speciality;
DROP TABLE IF EXISTS hospital;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS speciality;


/* 
*   Création des tables
*
*/

/* Table des villes*/
CREATE TABLE city(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);


/* Table des hospitaux */
CREATE TABLE hospital (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    bed_available INT NOT NULL,
    city_id INT NOT NULL CONSTRAINT FK_city REFERENCES city(id)
);

/* Table des spécialités */
CREATE TABLE speciality (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(500) NOT NULL
);

/* Ajout des jointures */
CREATE TABLE hospital_speciality (
    id_hospital INT NOT NULL REFERENCES hospital(id),
    id_speciality INT NOT NULL REFERENCES speciality(id)
);


/*
ALTER TABLE city ADD CONSTRAINT PK_city PRIMARY KEY CLUSTERED (id);
ALTER TABLE hospital ADD CONSTRAINT PK_hospital PRIMARY KEY CLUSTERED (id);

ALTER TABLE city ADD CONSTRAINT FK_hospital FOREIGN KEY (hospital_Id) REFERENCES hospital(id);
ALTER TABLE hospital ADD CONSTRAINT FK_city FOREIGN KEY (city_id) REFERENCES city(id);

*/



INSERT INTO speciality (id, name) VALUES
(1, 'Cardiologie'),
(2, 'Imunologie'),
(3, 'Neuropathologie'),
(4, 'Dagonosctif');

INSERT INTO city (id, name) VALUES
(1, 'PARIS'),
(2, 'BORDEAUX'),
(3, 'MARSEILLE');

/*

INSERT INTO hospital(name, bed_available, city_id) VALUES
('Hôpital Fred Brooks', 2, 1),
('Hôpital Julia Crusher', 0, 2),
('Hôpital Beverly Bashir', 5, 3);

INSERT INTO hospital_speciality (id_hospital, id_speciality) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 2),
(3, 3),
(3, 4);
*/