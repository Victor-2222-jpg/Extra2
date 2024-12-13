package com.example.extra2.Response;

import java.util.List;

public class OperacionResponse {

    public String getOperacion() {
        return operacion;
    }


    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    private String operacion;


    public List<OperacionResponse> getResults() {
        return results;
    }

    public void setResults(List<OperacionResponse> results) {
        this.results = results;
    }

    List<OperacionResponse> results;


}
