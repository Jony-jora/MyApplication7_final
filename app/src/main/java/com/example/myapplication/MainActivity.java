package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaracion de variables
    EditText editTextNombre, editTextContraseña;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asigna el valor a las variables obteniendo estos valores desde el activity

        editTextNombre = findViewById(R.id.userText);
        editTextContraseña = findViewById(R.id.passwordText);
        btnEnviar = findViewById(R.id.loginButton);

        //declara el onClick para que al oprimir el boton ejecute la condicional y si la verificaciond de datos
        //es valida envia los datos a traves de un intent a la segunda actividad

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNombre.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                if ("Jony".equals(nombre) && "abc".equals(contraseña)) {
                    enviarDatos(nombre, contraseña);
                } else {
                    Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //esta funcion es la que genera el intent y envia los datos ya validados a la segunda actividad
    public void enviarDatos(String nombre, String contraseña) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("contraseña", contraseña);
        startActivity(intent);
    }
}