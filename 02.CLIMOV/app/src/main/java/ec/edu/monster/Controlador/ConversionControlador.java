package ec.edu.monster.Controlador;

import ec.edu.monster.Modelo.ConversionModelo;
import ec.edu.monster.Modelo.RespuestaConversionModelo;
import ec.edu.monster.Servicio.ConversionServicio;
import retrofit2.Call;

public class ConversionControlador {

    private final ConversionServicio conversionServicio;
    public ConversionControlador (ConversionServicio conversionServicio) {
        this.conversionServicio = conversionServicio;
    }

    public Call<RespuestaConversionModelo> convertirCentimetrosAPulgadas (ConversionModelo conversionModelo){
        return conversionServicio.autorizacionServicio(conversionModelo);
    }

    public  Call<RespuestaConversionModelo> convertirPulgadasACentimetros(ConversionModelo conversionModelo){
        return conversionServicio.autorizacionServicio1(conversionModelo);
    }
}
