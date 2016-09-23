package com.lubricadora.yornel.lubrica;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lubricadora.yornel.lubrica.Model.Cliente;
import com.lubricadora.yornel.lubrica.Model.Publicidad;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int INTENT_LOGIN = 1;

    public static final Integer NAV_MIS_DATOS = 0;
    public static final Integer NAV_MIS_VEHICULOS = 1;
    public static final Integer NAV_MIS_CITAS = 2;
    public static final Integer NAV_MIS_MANTENIMIENTOS = 3;
    public static final Integer NAV_INGRESAR = 4;
    public static final Integer NAV_SALIR = 5;
    public static final Integer NAV_AUTOMERCADO_CERCA = 6;

    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(NAV_MIS_DATOS).setCheckable(false);
        navigationView.getMenu().getItem(NAV_MIS_VEHICULOS).setCheckable(false);
        navigationView.getMenu().getItem(NAV_MIS_CITAS).setCheckable(false);
        navigationView.getMenu().getItem(NAV_MIS_MANTENIMIENTOS).setCheckable(false);
        navigationView.getMenu().getItem(NAV_INGRESAR).setCheckable(false);
        navigationView.getMenu().getItem(NAV_SALIR).setCheckable(false);

        if (savedInstanceState == null) {
            disableClienteNav();
        }
    }

    private void enableClienteNav() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(NAV_MIS_DATOS).setEnabled(true);
        navigationView.getMenu().getItem(NAV_MIS_VEHICULOS).setEnabled(true);
        navigationView.getMenu().getItem(NAV_MIS_CITAS).setEnabled(true);
        navigationView.getMenu().getItem(NAV_MIS_MANTENIMIENTOS).setEnabled(true);
        navigationView.getMenu().getItem(NAV_INGRESAR).setVisible(false);
        navigationView.getMenu().getItem(NAV_SALIR).setVisible(true);
    }

    private void disableClienteNav() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(NAV_MIS_DATOS).setEnabled(false);
        navigationView.getMenu().getItem(NAV_MIS_VEHICULOS).setEnabled(false);
        navigationView.getMenu().getItem(NAV_MIS_CITAS).setEnabled(false);
        navigationView.getMenu().getItem(NAV_MIS_MANTENIMIENTOS).setEnabled(false);
        navigationView.getMenu().getItem(NAV_INGRESAR).setVisible(true);
        navigationView.getMenu().getItem(NAV_SALIR).setVisible(false);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("jsonCliente", cliente.toString());
            startActivity(intent);
        } else if (id == R.id.nav_vehicles) {

        } else if (id == R.id.nav_citas) {

        } else if (id == R.id.nav_maintenance) {

        } else if (id == R.id.nav_maps) {

        } else if (id == R.id.nav_in) {
            startActivityForResult(new Intent(MainActivity.this,
                    LoginActivity.class), INTENT_LOGIN);
        } else if (id == R.id.nav_out) {
            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Salir")
                .setMessage("¿Seguro que deseas cerrar tu usario?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Nothing to do
                    }
                })
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        cliente = null;
                        disableClienteNav();
                        Snackbar.make(findViewById(R.id.contenedor), "Usuario Cerrado", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }).show();
    }

    public ArrayList<Publicidad> getPublicidad() {

        ArrayList<Publicidad> publicidades = new ArrayList<>();

        Publicidad publicidad1 = new Publicidad();
        publicidad1.setTitulo("Automercado");
        publicidad1.setImagen(BitmapFactory.decodeResource(getResources(), R.drawable.automercado_a));
        publicidad1.setPie("Los Mejores Precios");

        Publicidad publicidad2 = new Publicidad();
        publicidad2.setTitulo("Leizer");
        publicidad2.setImagen(BitmapFactory.decodeResource(getResources(), R.drawable.automercado_b));
        publicidad2.setPie("Lo Mejor para tu auto");

        Publicidad publicidad3 = new Publicidad();
        publicidad3.setTitulo("Aditivos");
        publicidad3.setImagen(BitmapFactory.decodeResource(getResources(), R.drawable.automercado_c));

        publicidades.add(publicidad1);
        publicidades.add(publicidad2);
        publicidades.add(publicidad3);

        return publicidades;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == INTENT_LOGIN && resultCode == RESULT_OK) {
            cliente = new Gson().fromJson(data.getStringExtra("jsonCliente"), Cliente.class);
            enableClienteNav();
            Snackbar.make(findViewById(R.id.contenedor), "Usuario Ingresado", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }


}
