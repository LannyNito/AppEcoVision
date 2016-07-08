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

    boolean hayProtanopia, hayDeuteranopia, hayTritanopia, esDicromatico, hayEritropsia, hayAcromatico;

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
                
                if(esLaUltima == 2) {
                    presentaDiagnostico();
                    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                    fab.setVisibility(View.INVISIBLE);
                }
                else
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

    private void presentaDiagnostico() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (mifragTri.click1 == 1 && 1 == mifragTri.click2 && mifragTri.click3 == 1 && 1 == mifragTri.click4) {
            hayAcromatico = true;
        }

        if(esDicromatico){
            Diagnostico.resultado = "⇒ Usted presenta los 3 tipos de Daltonismo Dicromático: Deuteranopia, Protanopia y Tritanopia\n\n";
        }
        else if(hayDeuteranopia){
            Diagnostico.resultado = "⇒ Usted presenta un tipo de Daltonismo Dicromático: Deuteranopia\n\n";
        }

        else if(hayProtanopia){
            Diagnostico.resultado = "⇒ Usted presenta un tipo de Daltonismo Dicromático: Protanopia\n\n";
        }

        else if(hayTritanopia){
            Diagnostico.resultado = "⇒ Usted presenta un tipo de Daltonismo Dicromático: Tritanopia\n\n";
        }
        if(hayEritropsia){
            Diagnostico.resultado += "⇒ Usted presenta un tipo de Daltonismo al color llamado Eritropsia\n\n";
        }

        if(hayAcromatico){
            Diagnostico.resultado += "⇒ Usted presenta un tipo de Daltonismo al color llamado Acromático\n\n";
        }


        Diagnostico diag = new Diagnostico();

        fragmentTransaction.replace(R.id.container, diag, "hola");
        fragmentTransaction.commit();

        //diag.setTexto();

    }


    public void siguientePregunta(){

        if(esLaUltima == 1){

            if(mifragTri.marcadas > 0) {

                if (mifragTri.click1 == 1 && 1 == mifragTri.click2 && mifragTri.click3 == 1 && 1 == mifragTri.click4) {
                    hayEritropsia = true;
                }

                mifragTri.resetClicks();

                mifragTri.initPregunta("Seleccione la imagen con tonos rojos", R.drawable.eri_azulverde, R.drawable.eri_deuteranipia, R.drawable.eri_florblanca, R.drawable.eri_oso);

                esLaUltima = 2;
            }
            else
                Toast.makeText(this, "Debe seleccionar al menos una imagen", Toast.LENGTH_SHORT).show();

        }
        else {

            if (Item.numeroItems < 11) {

                RadioGroup opciones = (RadioGroup) findViewById(R.id.opciones);

                int elegida = opciones.getCheckedRadioButtonId();

                if (elegida != -1) {

                    guardaErrores();

                    actual = new Item();

                    mifrag.initPregunta(actual.getImagen(), actual.getOpciones());


                } else {
                    Toast.makeText(this, "Debe elegir una respuesta", Toast.LENGTH_SHORT).show();
                }


            } else {

                guardaErrores();

                esDicromatico = ("12,8,35,29,57,5,3,15,74,5,2,".equals(errados));
                
                if(!esDicromatico) {
                    hayDeuteranopia = ("12,8,35,29,57,2,".equals(errados));

                    hayProtanopia = ("5,3,15,74,".equals(errados));

                    hayTritanopia = estaEnErrados("5,3,15,74,5".split(","));
                }
                
                

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                mifragTri = new PreguntaImagenTriple();

                fragmentTransaction.replace(R.id.container, mifragTri, "hola");
                fragmentTransaction.commit();

                esLaUltima = 1;

            }
        }

    }

    public void guardaErrores() {

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

            if (!correcta.equals(texto)) {
                errados += correcta + ",";
            }

            opciones.clearCheck();

        }
    }

    public boolean estaEnErrados(String[] lista){

        for(String a: lista){

            if(!errados.contains(a))
                return false;

        }

        return true;
    }

}
