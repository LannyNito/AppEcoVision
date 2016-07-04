package com.example.lanny.appecovision;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaSimple extends Fragment {


    private static ImageView image;
    private static RadioButton r1;
    private static RadioButton r2;
    private static RadioButton r3;

    public PreguntaSimple() {
        // Required empty public constructor
    }

    public void initPregunta(int imagen, String opciones []){

        image.setImageResource(imagen);

        r1.setText(opciones[0].replace("c", ""));
        r2.setText(opciones[1].replace("c", ""));
        r3.setText(opciones[2].replace("c", ""));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pregunta_simple, container, false);

        image = (ImageView) view.findViewById(R.id.imageView);
        r1 = (RadioButton) view.findViewById(R.id.radio1);
        r2 = (RadioButton) view.findViewById(R.id.radio2);
        r3 = (RadioButton) view.findViewById(R.id.radio3);

        return view;
    }

}
