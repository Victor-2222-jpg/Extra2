package com.example.extra2.Network;

import com.example.extra2.Response.OperacionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OperacionesApi {
    @GET("/operaciones")
    Call<List<OperacionResponse>> getOperaciones();

}
