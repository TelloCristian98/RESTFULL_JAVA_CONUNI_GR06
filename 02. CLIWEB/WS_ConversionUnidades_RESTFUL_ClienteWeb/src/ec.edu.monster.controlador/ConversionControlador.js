import { login, convertirPulgadasACm, convertirCmAPulgadas } from "../ec.edu.monster.modelo/ConversionServicio";

export const manejarLogin = async (usuario, clave, setAutenticado, setError) => {
  try {
    const isValid = await login(usuario, clave);
    if (isValid) {
      setAutenticado(true);
    } else {
      throw new Error("Credenciales incorrectas. Intente nuevamente.");
    }
  } catch (error) {
    setError(error.message);
  }
};

export const manejarConversion = async (tipo, valor, setResultado, setError) => {
  try {
    let resultado;
    if (tipo === "pulgadasACm") {
      resultado = await convertirPulgadasACm(valor);
    } else if (tipo === "cmAPulgadas") {
      resultado = await convertirCmAPulgadas(valor);
    }
    setResultado(resultado);
  } catch (error) {
    setError(error.message);
  }
};

