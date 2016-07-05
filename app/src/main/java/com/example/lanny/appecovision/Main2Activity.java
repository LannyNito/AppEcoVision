package com.example.lanny.appecovision;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    int preguntaActual = 0, esLaUltima = 0;
    String errados = "";

    Item actual;

    PreguntaSimple mifrag;

    PreguntaImagenTriple mifragTri;

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
                siguientePregunta();

            }
        });

        actual = new Item();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        mifrag = new PreguntaSimple();

        fragmentTransaction.add(R.id.container, mifrag, "hola");
        fragmentTransaction.commit();

    }


    public void siguientePregunta(){

        if(esLaUltima == 1){
            mifragTri.initPregunta("Seleccione la imagen con tonos rojos", R.drawable.eri_azulverde, R.drawable.eri_deuteranipia, R.drawable.eri_florblanca, R.drawable.eri_oso);
        }
        else {

            if (Item.numeroItems < 2) {

                RadioGroup opciones = (RadioGroup) findViewById(R.id.opciones);

                int elegida = opciones.getCheckedRadioButtonId();

                if (elegida != -1) {
                    RadioButton opcion = (RadioButton) findViewById(elegida);

                    String texto = opcion.getText().toString();

                    String[] array = actual.getOpciones();

                    String correcta = "";

                    for (String b : array) {
                        if (b.contains("c")) {
                            correcta = b.replace("c", "");
                            break;
                        }
                    }

                    if (correcta != texto) {
                        errados += texto + ",";
                    }


                    actual = new Item();

                    mifrag.initPregunta(actual.getImagen(), actual.getOpciones());

                    opciones.clearCheck();
                } else {
                    Toast.makeText(this, "Debe elegir una respuesta", Toast.LENGTH_SHORT).show();
                }


            } else {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                mifragTri = new PreguntaImagenTriple();

                fragmentTransaction.replace(R.id.container, mifragTri, "hola");
                fragmentTransaction.commit();

                esLaUltima = 1;

            }
        }

    }

}
