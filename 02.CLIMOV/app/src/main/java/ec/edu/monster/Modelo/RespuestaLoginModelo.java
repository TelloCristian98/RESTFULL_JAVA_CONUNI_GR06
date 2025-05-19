package ec.edu.monster.Modelo;

public class RespuestaLoginModelo {
    private String mensaje;

    public RespuestaLoginModelo(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
