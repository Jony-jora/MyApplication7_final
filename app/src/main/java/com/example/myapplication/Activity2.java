package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView textViewDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewDatos = findViewById(R.id.textViewDatos);

        //crea el Intent y lo guarda en una variable intent

        Intent intent = getIntent();

        //si los datos recibidos no son nulos, obtiene los datos del intent y los guarda en variables
        //si estos datos son validados correctamente se muestra en el text view si no se muestra un mensaje de error
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String contraseña = intent.getStringExtra("contraseña");

            if ("Jony".equals(nombre) && "abc".equals(contraseña)) {
                String mensaje = "Bienvenido/a " + nombre;
                textViewDatos.setText(mensaje);
            }else{
                textViewDatos.setText("Nombre o contraseña incorrectos");
            }
        }
    }
}