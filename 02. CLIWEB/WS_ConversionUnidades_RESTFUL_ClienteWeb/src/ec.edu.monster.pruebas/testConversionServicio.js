import { login, convertirPulgadasACm, convertirCmAPulgadas } from "../ec.edu.monster.modelo/ConversionServicio.js";

const testLogin = async () => {
  try {
    const result = await login("monster", "monster9");
    console.log("Login con credenciales válidas:", result);
  } catch (error) {
    console.error("Error en login con credenciales válidas:", error.message);
  }

  try {
    const result = await login("invalidUser", "invalidPassword");
    console.log("Login con credenciales inválidas:", result);
  } catch (error) {
    console.error("Error en login con credenciales inválidas:", error.message);
  }
};

const testConversion = async () => {
  try {
    const result = await convertirPulgadasACm(10);
    console.log("Convertir 10 pulgadas a cm:", result);
  } catch (error) {
    console.error("Error en convertir 10 pulgadas a cm:", error.message);
  }

  try {
    const result = await convertirCmAPulgadas(25.4);
    console.log("Convertir 25.4 cm a pulgadas:", result);
  } catch (error) {
    console.error("Error en convertir 25.4 cm a pulgadas:", error.message);
  }
};

const runTests = async () => {
  console.log("Iniciando pruebas...");

  await testLogin();
  await testConversion();

  console.log("Pruebas completadas.");
};

runTests();