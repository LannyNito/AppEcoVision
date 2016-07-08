package com.example.lanny.appecovision;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Diagnostico extends Fragment {

    public static String resultado = "";

    public Diagnostico() {
        // Required empty public constructor
    }

    static TextView texto;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diagnostico, container, false);

        texto = (TextView) view.findViewById(R.id.resultado);

        texto.setText(resultado);

        view.findViewById(R.id.salir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.exit(0);

            }
        });


        return view;
    }

}
