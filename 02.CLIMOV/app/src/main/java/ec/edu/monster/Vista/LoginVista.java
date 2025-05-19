package ec.edu.monster.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import ec.edu.monster.Controlador.LoginControlador;
import ec.edu.monster.Modelo.LoginModelo;
import ec.edu.monster.Modelo.RespuestaLoginModelo;
import ec.edu.monster.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginVista extends AppCompatActivity {
    private EditText etUsuario, etContrasena;
    private Button btnLogin;
    private LoginControlador loginControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnLogin = findViewById(R.id.btnLogin);
        loginControlador = new LoginControlador();

        btnLogin.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa usuario y contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            LoginModelo loginModelo = new LoginModelo(usuario, contrasena);

            loginControlador.iniciarSesion(loginModelo).enqueue(new Callback<RespuestaLoginModelo>() {
                @Override
                public void onResponse(Call<RespuestaLoginModelo> call, Response<RespuestaLoginModelo> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        RespuestaLoginModelo respuesta = response.body();
                        Toast.makeText(LoginVista.this, respuesta.getMensaje(), Toast.LENGTH_LONG).show();

                        if (respuesta.getMensaje().equals("Login exitoso")) {
                            startActivity(new Intent(LoginVista.this, ConversionVista.class));
                        }
                    } else {
                        try {
                            String errorBody = response.errorBody() != null ? response.errorBody().string() : "Sin cuerpo de error";
                            Log.e("LoginVista", "Respuesta error: " + errorBody);
                        } catch (Exception e) {
                            Log.e("LoginVista", "Error al leer cuerpo error: " + e.getMessage());
                        }
                        Toast.makeText(LoginVista.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<RespuestaLoginModelo> call, Throwable t) {
                    Log.e("LoginVista", "Error de conexión", t);
                    Toast.makeText(LoginVista.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
