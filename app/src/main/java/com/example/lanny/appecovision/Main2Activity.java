package com.example.lanny.appecovision;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    int preguntaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        PreguntaSimple mifrag = new PreguntaSimple();
        fragmentTransaction.add(R.id.container, mifrag, "hola");
        fragmentTransaction.commit();
    }


    public void siguientePregunta(){

        RadioGroup opciones = (RadioGroup) findViewById(R.id.opciones);

        int elegida =  opciones.getCheckedRadioButtonId();

        if(elegida != -1){
            RadioButton opcion = (RadioButton) findViewById(elegida);

            String texto = opcion.getText().toString();
        }




    }

}
