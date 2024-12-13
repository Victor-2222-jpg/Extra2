package com.example.extra2.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.extra2.R;

public class DetalleOperaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_operaciones);

        TextView resultadoTextView = findViewById(R.id.res);
        int resultado = getIntent().getIntExtra("resultado", 0);
        resultadoTextView.setText(String.valueOf(resultado));
    }
}