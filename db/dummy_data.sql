-- Tablas de la base de datos

CREATE TABLE Ciudad (
    id VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL
);

CREATE TABLE Teatro (
    id VARCHAR(100) PRIMARY KEY,
    id_ciudad VARCHAR(100) NOT NULL,
    nombre VARCHAR(200) NOT NULL,
    direccion VARCHAR(200) NOT NULL,

    CONSTRAINT FK_Teatro_Ciudad 
        FOREIGN KEY (id_ciudad) REFERENCES Ciudad(id)
);

CREATE TABLE Usuario (
    id VARCHAR(100) PRIMARY KEY,
    nombres VARCHAR(500) NOT NULL,
    correo VARCHAR(500) NOT NULL,
    celular VARCHAR(100) NOT NULL,
    password VARCHAR(500) NOT NULL,
    activo BOOLEAN,
    tipo_usuario VARCHAR(100)
);

CREATE TABLE Pelicula (
    id VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(200) NOT NULL,
    duracion_min NUMERIC NOT NULL,
    url_imagen VARCHAR(500),
    cartelera BOOLEAN NOT NULL,
    genero VARCHAR(100) NOT NULL,
    clasificacion VARCHAR(50) NOT NULL,
    descripcion VARCHAR(2000)
);

CREATE TABLE Funcion (
    id VARCHAR(100) PRIMARY KEY,
    id_pelicula VARCHAR(100) NOT NULL,
    id_teatro VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    precio NUMERIC NOT NULL,
    sillas_disponibles NUMERIC NOT NULL,

    CONSTRAINT FK_Funcion_Pelicula 
        FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id),
    CONSTRAINT FK_Funcion_Teatro 
        FOREIGN KEY (id_teatro) REFERENCES Teatro(id)
);

CREATE TABLE Compras (
    id VARCHAR(100) PRIMARY KEY,
    id_usuario VARCHAR(100) NOT NULL,
    id_funcion VARCHAR(100) NOT NULL,
    cantidad_entradas NUMERIC NOT NULL,
    precio_total NUMERIC NOT NULL,
    fecha_compra DATE NOT NULL,
    metodo_pago VARCHAR(100) NOT NULL,
    info_pago VARCHAR(2000),

    CONSTRAINT FK_Compras_Usuario 
        FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    CONSTRAINT FK_Compras_Funcion 
        FOREIGN KEY (id_funcion) REFERENCES Funcion(id)
);

-- Datos de prueba para la tabla Pelicula
INSERT INTO Pelicula (id, nombre, duracion_min, url_imagen, cartelera, genero, clasificacion, descripcion) 
VALUES (
    'a1b2c3d4-e5f6-7g8h-9i0j-k1l2m3n4o5p6', 'Inception', 148, 
    'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_FMjpg_UX1000_.jpg', 
    true, 'Ciencia Ficción', 'PG-13', 
    'Un ladrón que posee la tecnología de meterse en los sueños de otros debe realizar la tarea inversa: implantar una idea.'
),
(
    'b2c3d4e5-f6g7-8h9i-0j1k-l2m3n4o5p6q7', 'Spider-Man: Across the Spider-Verse', 140, 
    'https://m.media-amazon.com/images/M/MV5BNThiZjA3MjItZGY5Ni00ZmJhLWEwN2EtOTBlYTA4Y2E0M2ZmXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', true, 'Animación', 
    'PG', 'Miles Morales se reencuentra con Gwen Stacy y es lanzado a través del Multiverso.'
),
(
    'c3d4e5f6-g7h8-9i0j-1k2l-m3n4o5p6q7r8', 'The Dark Knight', 152, 
    'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UX1000_.jpg', false, 'Acción', 
    'PG-13', 'Batman se enfrenta al Joker, una mente criminal que busca sumergir a Gotham en el caos.'
),
(
    'd4e5f6g7-h8i9-0j1k-2l3m-n4o5p6q7r8s9', 'Everything Everywhere All at Once', 139, 
    'https://m.media-amazon.com/images/M/MV5BOWNmMzAzZmQtNDQ1NC00Nzk5LTkyMmUtNGI2N2NkOWM4MzEyXkEyXkFqcGc@._V1_QL75_UY281_CR2,0,190,281_.jpg', true, 
    'Aventura', 'R', 'Una inmigrante china se ve envuelta en una aventura salvaje en la que solo ella puede salvar el mundo explorando otros universos.'
),
(
    'e5f6g7h8-i9j0-1k2l-3m4n-o5p6q7r8s9t0', 'The Super Mario Bros. Movie', 92, 
    'https://resizing.flixster.com/nQN8KYVFA4fD23Li3TCLwKYz8GA=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzL2JlYWVjZDdiLTMyYjMtNDgzNy1iN2M0LTgzYWZkODIzMmZmOS5qcGc=', true, 'Animación', 
    'G', 'Un fontanero llamado Mario viaja a través de un laberinto subterráneo con su hermano para salvar a una princesa capturada.'
);

-- 1. Ciudades
INSERT INTO Ciudad (id, nombre) VALUES 
('cali-01', 'Cali'),
('bog-02', 'Bogotá');

-- 2. Teatros
INSERT INTO Teatro (id, id_ciudad, nombre, direccion) VALUES 
('t-unicali', 'cali-01', 'Cine Colombia Unicentro', 'Calle 5 # 100-110'),
('t-andino', 'bog-02', 'Cine Andino', 'Carrera 11 # 82-71');

-- 3. Funciones (Relaciona Película + Teatro + Horario)
INSERT INTO Funcion (id, id_pelicula, id_teatro, fecha, hora, precio, sillas_disponibles) VALUES 
(
	'f-001', 
	'b2c3d4e5-f6g7-8h9i-0j1k-l2m3n4o5p6q7', 
	't-unicali', '2026-01-25', 
	'18:30:00', 
	15000, 
	50
),
(
	'f-002', 
	'e5f6g7h8-i9j0-1k2l-3m4n-o5p6q7r8s9t0', 
	't-unicali', '2026-01-25', 
	'18:30:00', 
	15000, 
	2
);

INSERT INTO Usuario (id, nombres, correo, celular, password, activo, tipo_usuario) 
VALUES (
    'u-001-test', 
    'Juan Pérez', 
    'juan.perez@email.com', 
    '3101234567', 
    '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.TVuHOnu', -- Esta es la clave: password123
    true, 
    'CLIENTE'
);