package com.example.extra2.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.extra2.Adapters.OperacionesAdapter;
import com.example.extra2.Models.Operaciones;
import com.example.extra2.R;
import com.example.extra2.ViewModels.OperacionesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OperacionesViewModel operacionesViewModel;
    private OperacionesAdapter operacionesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclesumas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        operacionesViewModel = new ViewModelProvider(this).get(OperacionesViewModel.class);
        operacionesAdapter = new OperacionesAdapter(null, operacionesViewModel);
        recyclerView.setAdapter(operacionesAdapter);

        operacionesViewModel.getOperacionesList().observe(this, new Observer<List<Operaciones>>() {
            @Override
            public void onChanged(List<Operaciones> operaciones) {
                operacionesAdapter.updateOperacionesList(operaciones);
            }
        });

        operacionesViewModel.fetchOperaciones();
    }
}