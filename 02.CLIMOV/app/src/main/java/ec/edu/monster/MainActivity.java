package ec.edu.monster;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Lanzar directamente LoginVista
        Intent intent = new Intent(this, ec.edu.monster.Vista.LoginVista.class);
        startActivity(intent);
        finish(); // Para que no se pueda regresar con el botón "atrás"
    }
}