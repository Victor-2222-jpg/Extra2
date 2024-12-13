package com.example.extra2.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.extra2.Models.Operaciones;
import com.example.extra2.Network.ApiService;
import com.example.extra2.Network.OperacionesApi;
import com.example.extra2.Response.OperacionResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OperacionesViewModel extends ViewModel {
    private final MutableLiveData<List<Operaciones>> operacionesList = new MutableLiveData<>();
    private final Retrofit retrofit;

    public OperacionesViewModel() {

        retrofit = ApiService.getClient();
    }

    public LiveData<List<Operaciones>> getOperacionesList() {
        return operacionesList;
    }

    public void fetchOperaciones() {
        OperacionesApi api = retrofit.create(OperacionesApi.class);

        Call<List<OperacionResponse>> call = api.getOperaciones();
        call.enqueue(new Callback<List<OperacionResponse>>() {
            @Override
            public void onResponse(Call<List<OperacionResponse>> call, Response<List<OperacionResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Operaciones> operaciones = new ArrayList<>();
                    for (OperacionResponse operacionResponse : response.body()) {
                        // Crear objetos Operaciones con la respuesta del API
                        operaciones.add(new Operaciones(null, operacionResponse.getOperacion()));
                    }
                    operacionesList.setValue(operaciones);
                } else {
                    Log.e("OperacionesViewModel", "Error al obtener las operaciones. Código: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<OperacionResponse>> call, Throwable t) {
                Log.e("OperacionesViewModel", "Fallo en la conexión: " + t.getMessage(), t);
            }
        });
    }
}
