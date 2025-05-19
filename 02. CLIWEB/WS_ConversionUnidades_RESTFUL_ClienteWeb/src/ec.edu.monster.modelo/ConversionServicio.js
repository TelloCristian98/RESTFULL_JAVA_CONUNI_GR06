const BASE_URL = "http://localhost:8080/WS_ConversionUnidades_REST/webresources";

export const login = async (usuario, clave) => {
  try {
    const response = await fetch(`${BASE_URL}/conversion/login/${usuario}/${clave}`);
    if (!response.ok) throw new Error("Error en las credenciales.");
    const data = await response.text();
    return data === "true";
  } catch (error) {
    throw new Error(error.message);
  }
};

export const convertirPulgadasACm = async (pulgadas) => {
  try {
    const response = await fetch(`${BASE_URL}/conversion/pulgadas-a-cm/${pulgadas}`);
    if (!response.ok) throw new Error("Error en la conversión.");
    const data = await response.text();
    return parseFloat(data);
  } catch (error) {
    throw new Error(error.message);
  }
};

export const convertirCmAPulgadas = async (cm) => {
  try {
    const response = await fetch(`${BASE_URL}/conversion/cm-a-pulgadas/${cm}`);
    if (!response.ok) throw new Error("Error en la conversión.");
    const data = await response.text();
    return parseFloat(data);
  } catch (error) {
    throw new Error(error.message);
  }
};
