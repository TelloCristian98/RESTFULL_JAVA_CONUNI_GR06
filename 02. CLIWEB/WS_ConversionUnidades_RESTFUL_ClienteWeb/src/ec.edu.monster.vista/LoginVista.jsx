import React, { useState } from "react";
import { manejarLogin } from "../ec.edu.monster.controlador/ConversionControlador";
import './styles.css';
import monstruoImage from '../assets/monster2.jpg';
const LoginVista = ({ setAutenticado }) => {
  const [usuario, setUsuario] = useState("");
  const [clave, setClave] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    manejarLogin(usuario, clave, setAutenticado, setError);
  };

  return (
    <div className="container">
              <div className="image-container">
        <img src={monstruoImage} alt="Monster2" />
      </div>
      <h2>Iniciar Sesión</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Usuario"
          value={usuario}
          onChange={(e) => setUsuario(e.target.value)}
        />
        <input
          type="password"
          placeholder="Clave"
          value={clave}
          onChange={(e) => setClave(e.target.value)}
        />
        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
};

export default LoginVista;
