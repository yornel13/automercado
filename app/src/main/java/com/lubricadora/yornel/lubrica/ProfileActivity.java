package com.lubricadora.yornel.lubrica;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lubricadora.yornel.lubrica.Model.Cliente;

public class ProfileActivity extends BaseActivity {

    private Cliente cliente;

    private TextView nombre;
    private TextView apellido;
    private TextView cedula;
    private TextView direccion;
    private TextView telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setUpToolbarWithTitle(true);

        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        cedula = (TextView) findViewById(R.id.cedula);
        direccion = (TextView) findViewById(R.id.direccion);
        telefono = (TextView) findViewById(R.id.telefono);

        String jsonCliente = getIntent().getExtras().getString("jsonCliente");
        cliente = new Gson().fromJson(jsonCliente, Cliente.class);

        nombre.setText(cliente.getNombre());
        apellido.setText(cliente.getApellido());
        cedula.setText(cliente.getCedula());
        direccion.setText(cliente.getDireccion());
        telefono.setText(cliente.getTelefono());
    }
}
