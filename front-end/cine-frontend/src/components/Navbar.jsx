import { useEffect, useState } from "react";
import { api } from '../api/axiosConfig';
import { FaTicketAlt } from 'react-icons/fa';
import { Link } from 'react-router-dom';

export default function Navbar({ onCityChange }) {
    const [ciudades, setCiudades] = useState([]);

    useEffect(() => {
        // Cargar las ciudades desde Java
        api.get('/ciudades')
            .then(res => setCiudades(res.data))
            .catch(err => console.error(err));
    }, []);

    return (
        <nav className="navbar navbar-expand-lg navbar-dark navbar-cine mb-4 px-4">
            <div className="container-fluid">
                <Link className="navbar-brand brand-text" to="/">
                    <FaTicketAlt className="me-2" /> CINE DIGITAL
                </Link>

                <div className="d-flex align-items-center">
                    <span className="text-white me-2">Tu Ciudad: </span>
                    <select
                        className="form-select form-select-sm bg-dark text-white border-warning"
                        style={{ width: '150px' }}
                        onChange={(e) => onCityChange(e.target.value)}
                    >
                        <option value="">Seleccionar...</option>
                        {ciudades.map(c => (
                            <option key={c.id} value={c.id}>{c.nombre}</option>
                        ))}
                    </select>
                </div>
            </div>
        </nav>
    );
}