import { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import { api } from './api/axiosConfig';
import Navbar from './components/Navbar';
import DetallePelicula from './pages/DetallePelicula';
import './App.css';

function Home({ cityId }) {
    const [peliculas, setPeliculas] = useState([]);

    useEffect(() => {
        api.get('/peliculas/cartelera')
            .then(res => setPeliculas(res.data))
            .catch(err => console.error(err));
    }, [cityId]);

    return (
        <div className='container'>
            <h2 className="text-white mb-4 border-start border-4 border-danger ps-3">En Cartelera</h2>
            <div className='row'>
                {peliculas.map((peli) => (
                    <div className="col-md-3 mb-4" key={peli.id}>
                        <div className="card card-cine h-100">
                            <img
                                src={peli.urlImagen}
                                className='card-img-top'
                                style={{ height: '350px', objectFit: 'cover' }}
                                alt={peli.nombre}
                                referrerPolicy="no-referrer"
                            />
                            <div className="card-body d-flex flex-column">
                                <h5 className="card-title text-truncate">{peli.nombre}</h5>
                                <Link to={`/pelicula/${peli.id}`} className="btn btn-cine-primary mt-auto">
                                    Ver Funciones
                                </Link>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}

function App() {
    const [cityId, setCityId] = useState('');

    return (
        <BrowserRouter>
            <div className="min-vh-100 d-flex flex-column">
                <Navbar onCityChange={setCityId} />

                <Routes>
                    <Route path="/" element={<Home cityId={cityId} />} />
                    <Route path="/pelicula/:id" element={<DetallePelicula />} />
                </Routes>

                <footer className="mt-auto py-3 text-center border-top border-secondary">
                    <small>© 2026 Cine Digital - Todos los derechos reservados</small>
                </footer>
            </div>
        </BrowserRouter>
    );
}

export default App;