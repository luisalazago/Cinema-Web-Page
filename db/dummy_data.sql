-- Datos de prueba para la tabla Pelicula
INSERT INTO Pelicula (id, nombre, duracion_min, url_imagen, cartelera, genero, clasificacion, descripcion) 
VALUES (
    'a1b2c3d4-e5f6-7g8h-9i0j-k1l2m3n4o5p6', 'Inception', 148, 
    'https://image.tmdb.org/t/p/w500/edv5CZvNo0YFS1I69h6SSTpS5Z3.jpg', 
    true, 'Ciencia Ficción', 'PG-13', 
    'Un ladrón que posee la tecnología de meterse en los sueños de otros debe realizar la tarea inversa: implantar una idea.'
),
(
    'b2c3d4e5-f6g7-8h9i-0j1k-l2m3n4o5p6q7', 'Spider-Man: Across the Spider-Verse', 140, 
    'https://image.tmdb.org/t/p/w500/8VtptQCpS77An9uAI70Xn99o67.jpg', true, 'Animación', 
    'PG', 'Miles Morales se reencuentra con Gwen Stacy y es lanzado a través del Multiverso.'
),
(
    'c3d4e5f6-g7h8-9i0j-1k2l-m3n4o5p6q7r8', 'The Dark Knight', 152, 
    'https://image.tmdb.org/t/p/w500/qJ2tW6WMUDp9QmSbmM9pcejsfC6.jpg', false, 'Acción', 
    'PG-13', 'Batman se enfrenta al Joker, una mente criminal que busca sumergir a Gotham en el caos.'
),
(
    'd4e5f6g7-h8i9-0j1k-2l3m-n4o5p6q7r8s9', 'Everything Everywhere All at Once', 139, 
    'https://image.tmdb.org/t/p/w500/w3Lxi7vUvDyC0mB7O-- Accion -_r8j.jpg', true, 
    'Aventura', 'R', 'Una inmigrante china se ve envuelta en una aventura salvaje en la que solo ella puede salvar el mundo explorando otros universos.'
),
(
    'e5f6g7h8-i9j0-1k2l-3m4n-o5p6q7r8s9t0', 'The Super Mario Bros. Movie', 92, 
    'https://image.tmdb.org/t/p/w500/qNBAXBIQlnOzlqNB9vYvS6A7R_W.jpg', true, 'Animación', 
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
('f-001', 'b2c3d4e5-f6g7-8h9i-0j1k-l2m3n4o5p6q7', 't-unicali', '2026-01-25', '18:30:00', 15000, 50);