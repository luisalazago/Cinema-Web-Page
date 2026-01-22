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
