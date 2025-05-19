package ec.edu.monster.Modelo;

public class LoginModelo {

    private String usuario;
    private String contrasena;

    public LoginModelo(String usuario, String contrasena){
        this.usuario=usuario;
        this.contrasena= contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String constrasena) {
        this.contrasena = contrasena;
    }
}
