package ec.edu.monster.Vista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ec.edu.monster.ClienteWeb.ApiCliente;
import ec.edu.monster.Controlador.ConversionControlador;
import ec.edu.monster.Modelo.ConversionModelo;
import ec.edu.monster.Modelo.RespuestaConversionModelo;
import ec.edu.monster.R;
import ec.edu.monster.Servicio.ConversionServicio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversionVista extends AppCompatActivity{

    private EditText etValor;
    private Button btnCmToIn, btnInToCm;
    private TextView tvResultado;
    private ConversionControlador conversionControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion); // Este debe ser el nombre correcto de tu layout XML

        etValor = findViewById(R.id.etValor);
        btnCmToIn = findViewById(R.id.btnCmToIn);
        btnInToCm = findViewById(R.id.btnInToCm);
        tvResultado = findViewById(R.id.tvResultado);

        conversionControlador = new ConversionControlador(ApiCliente.getClient().create(ConversionServicio.class));

        btnCmToIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir(true);
            }
        });

        btnInToCm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertir(false);
            }
        });
    }

    private void convertir(boolean cmToIn) {
        String input = etValor.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            return;
        }

        double valor = Double.parseDouble(input);
        ConversionModelo conversionModelo = new ConversionModelo(valor);
        Call<RespuestaConversionModelo> llamada = cmToIn
                ? conversionControlador.convertirCentimetrosAPulgadas(conversionModelo)
                : conversionControlador.convertirPulgadasACentimetros(conversionModelo);

        llamada.enqueue(new Callback<RespuestaConversionModelo>() {
            @Override
            public void onResponse(Call<RespuestaConversionModelo> call, Response<RespuestaConversionModelo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RespuestaConversionModelo resultado = response.body();
                    tvResultado.setText("Tipo: " + resultado.getResultado());
                } else {
                    tvResultado.setText("Error en la conversión");
                }
            }

            @Override
            public void onFailure(Call<RespuestaConversionModelo> call, Throwable t) {
                tvResultado.setText("Fallo de conexión: " + t.getMessage());
            }
        });
    }
}
