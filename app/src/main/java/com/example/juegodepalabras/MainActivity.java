package com.example.juegodepalabras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public VistaJuego juego;
    public LinearLayout lv;
    Button btnTry;
    EditText txtCaracter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.mi_view_layout);
        btnTry = findViewById(R.id.btnIntento);

        txtCaracter = findViewById(R.id.txtCaracter);

        btnTry.setOnClickListener(this);

        juego = new VistaJuego(this);

        lv.addView(juego);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //  Inflamos el menu
        getMenuInflater().inflate(R.menu.manu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuNuevo) {
            juego.init_juego();
        }else if(item.getItemId() == R.id.menuSalir) {
            finish();
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        if(v == btnTry) {
            juego.comporbar(txtCaracter.getText().charAt(0));
        }
    }
}
