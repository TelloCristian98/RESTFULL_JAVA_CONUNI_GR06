import React, { useState } from "react";
import LoginVista from "./ec.edu.monster.vista/LoginVista";
import ConversionVista from "./ec.edu.monster.vista/ConversionVista";

const App = () => {
  const [autenticado, setAutenticado] = useState(false);

  return (
    <div>
      {!autenticado ? (
        <LoginVista setAutenticado={setAutenticado} />
      ) : (
        <ConversionVista />
      )}
    </div>
  );
};

export default App;
