import React, { useState } from "react";
import { manejarConversion } from "../ec.edu.monster.controlador/ConversionControlador";
import './styles.css';
import monstruoImage from '../assets/monstruo.jpg';

const ConversionVista = () => {
  const [valor, setValor] = useState("");
  const [tipoConversion, setTipoConversion] = useState("pulgadasACm");
  const [resultado, setResultado] = useState(null);
  const [error, setError] = useState("");

  const handleConversion = () => {
    setError(null);
    setResultado(null);
    manejarConversion(tipoConversion, valor, setResultado, setError);
  };

  const handleTipoConversionChange = (e) => {
    setTipoConversion(e.target.value);
    setValor("");
    setResultado(null);
    setError(null);
  };

  const getUnidad = () => {
    return tipoConversion === "pulgadasACm" ? "centímetros" : "pulgadas";
  };

  return (
    <div className="conversion-container">
      <div className="form-container">
        <h2>Conversión de Unidades</h2>
        <div>
          <label>Valor a Convertir:</label>
          <input
            type="number"
            placeholder="Valor"
            value={valor}
            onChange={(e) => setValor(e.target.value)}
          />
        </div>
        <div>
          <label>Tipo de Conversión:</label>
          <select
            value={tipoConversion}
            onChange={handleTipoConversionChange}
          >
            <option value="pulgadasACm">Pulgadas a Centímetros</option>
            <option value="cmAPulgadas">Centímetros a Pulgadas</option>
          </select>
        </div>
        <button onClick={handleConversion}>Convertir</button>

        {resultado !== null && <h3>Resultado: {resultado} {getUnidad()}</h3>}
        {error && <p style={{ color: 'red' }}>{error}</p>}
      </div>
      <div className="image-container">
        <img src={monstruoImage} alt="Monstruo" />
      </div>
    </div>
  );
};

export default ConversionVista;