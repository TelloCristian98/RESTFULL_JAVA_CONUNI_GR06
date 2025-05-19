package ec.edu.monster.Servicio;

import ec.edu.monster.Modelo.ConversionModelo;
import ec.edu.monster.Modelo.LoginModelo;
import ec.edu.monster.Modelo.RespuestaConversionModelo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.Call;

public interface ConversionServicio {
    @POST("conversion/cmToInches")
    Call<RespuestaConversionModelo> autorizacionServicio(@Body ConversionModelo ConversionModelo);

    @POST("conversion/inchesToCm")
    Call<RespuestaConversionModelo> autorizacionServicio1(@Body ConversionModelo ConversionModelo);

}