import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { api } from '../api/axiosConfig';

export default function DetallePelicula() {
    const { id } = useParams(); // Se obtiene el id de la URL
    const navigate = useNavigate();

    const [pelicula, setPelicula] = useState(null);
    const [funciones, setFunciones] = useState([]);
    const [cantidad, setCantidad] = useState(1);
    const [funcionSeleccionada, setFuncionSeleccionada] = useState(null);

    useEffect(() => {
        // Se cargan los datos de la película.
        api.get(`/peliculas/${id}`).then(res => setPelicula(res.data));

        // Cargar las funciones disponibles para le pelicula
        api.get(`/funciones/pelicula/${id}`).then(res => setFunciones(res.data));
    }, [id]);

    const handleCompra = async () => {
        if (!funcionSeleccionada) return alert("Selecciona una función.");

        const compraData = {
            // Se envia solamente el id
            funcion: { id: funcionSeleccionada },
            usuario: { id: "u-001-test" },
            cantidadEntradas: parseInt(cantidad),
            fechaCompra: new Date().toISOString().split('T')[0],
            metodoPago: "EFECTIVO",
            infoPago: "Se paga en taquilla al momento de la función"
        };

        try {
            await api.post('/compras', compraData);
            alert("Compra exitosa. Disfruta la película!");
            navigate('/');
        }
        catch (error) {
            alert("Error en la compra: " + (error.response?.data || "Revisa los datos"));
        }
    };

    if (!pelicula) return <div className="text-center mt-5">Cargando...</div>

    return (
        <div className='container'>
            <div className='row'>
                {/* Poster */}
                <div className='col-md-4'>
                    <img src={pelicula.urlImagen} className='mg-fluid rounded shadow-lg' alt={pelicula.nombre} />
                </div>

                {/* Info y Funciones */}
                <div className="col-md-8">
                    <h1 className="display-4 fw-bold text-warning">{pelicula.nombre}</h1>
                    <p className="lead">{pelicula.descripcion}</p>
                    <div className="mb-4">
                        <span className="badge badge-clasificacion me-2">{pelicula.clasificacion}</span>
                        <span className="">{pelicula.genero} | {pelicula.duracionMin} min</span>
                    </div>

                    <hr className="border-secondary" />

                    <h4 className="mb-3">Funciones Disponibles</h4>
                    <div className="d-flex flex-wrap gap-2 mb-4">
                        {funciones.length === 0 ? <p>No hay funciones programadas.</p> : null}
                        {funciones.map(func => (
                            <button
                                key={func.id}
                                className={`btn ${funcionSeleccionada === func.id ? 'btn-cine-primary' : 'btn-outline-light'}`}
                                onClick={() => setFuncionSeleccionada(func.id)}
                            >
                                {func.hora} <br />
                                <small>${func.precio}</small>
                            </button>
                        ))}
                    </div>

                    {funcionSeleccionada && (
                        <div className="card card-cine p-3 border-warning">
                            <h5>Confirmar Compra</h5>
                            <div className="mb-3">
                                <label>Cantidad de Boletos:</label>
                                <input
                                    type="number"
                                    min="1" max="10"
                                    className='form-control bg-dark text-white border-secondary w-25'
                                    value={cantidad}
                                    onChange={e => setCantidad(e.target.value)}
                                />
                            </div>
                            <button
                                onClick={handleCompra}
                                className='btn btn-warning w-100 fw-bold'
                            >
                                PAGAR y RESERVAR
                            </button>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
}