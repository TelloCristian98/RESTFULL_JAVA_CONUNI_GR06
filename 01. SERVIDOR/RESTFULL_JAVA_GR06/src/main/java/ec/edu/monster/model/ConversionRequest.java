package ec.edu.monster.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConversionRequest {
    @JsonProperty("valor")
    private double valor;

    public ConversionRequest() {
    }

    public ConversionRequest(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}