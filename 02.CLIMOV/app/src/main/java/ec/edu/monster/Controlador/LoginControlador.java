package ec.edu.monster.Controlador;

import ec.edu.monster.ClienteWeb.ApiCliente;
import ec.edu.monster.Modelo.LoginModelo;
import ec.edu.monster.Modelo.RespuestaLoginModelo;
import ec.edu.monster.Servicio.LoginServicio;
import retrofit2.Call;

public class LoginControlador {

    private final LoginServicio loginServicio;

    public LoginControlador() {
        loginServicio = ApiCliente.getClient().create(LoginServicio.class);
    }

    public Call<RespuestaLoginModelo> iniciarSesion(LoginModelo loginModelo) {
        return loginServicio.autorizacionServicio(loginModelo);
    }

}
