package ec.edu.monster.Servicio;

import ec.edu.monster.Modelo.LoginModelo;
import ec.edu.monster.Modelo.RespuestaLoginModelo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginServicio {
    @POST("login")
    Call<RespuestaLoginModelo> autorizacionServicio(@Body LoginModelo loginModelo);



}