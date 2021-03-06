package com.example.lanny.appecovision;


import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntaImagenTriple extends Fragment {

    private static ImageView image1, image2, image3, image4;
    private static TextView text;
    public static int click1 = 0, click2 = 0, click3 = 0, click4 = 0;
    public static int marcadas = 0;


    public PreguntaImagenTriple() {
        // Required empty public constructor
    }

    public void resetClicks(){
        click1 = click2 = click3 = click4 = 0;
        marcadas = 0;
    }


    public void initPregunta(String titulo, int img1, int img2, int img3, int img4){

        text.setText(titulo);

        image1.setImageResource(img1);
        image2.setImageResource(img2);
        image3.setImageResource(img3);
        image4.setImageResource(img4);

        image1.setBackground(null);
        image2.setBackground(null);
        image3.setBackground(null);
        image4.setBackground(null);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pregunta_imagen_triple, container, false);


        image1 = (ImageView) view.findViewById(R.id.imagen1);
        image2 = (ImageView) view.findViewById(R.id.imagen2);
        image3 = (ImageView) view.findViewById(R.id.imagen3);
        image4 = (ImageView) view.findViewById(R.id.imagen4);
        text = (TextView) view.findViewById(R.id.tituloImagenes);

        final Drawable highlight = getResources().getDrawable( R.drawable.highlight );

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image1.isSelected() == false) {
                    image1.setSelected(true);

                    image1.setBackground(highlight);

                    click1 = 1;

                    marcadas++;
                }
                else {
                    image1.setSelected(false);

                    image1.setBackground(null);

                    click1 = 0;

                    marcadas--;
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image2.isSelected() == false) {
                    image2.setSelected(true);

                    image2.setBackground(highlight);

                    click2 = 1;

                    marcadas++;
                }
                else {
                    image2.setSelected(false);

                    image2.setBackground(null);

                    click2 = 0;

                    marcadas--;
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (image3.isSelected() == false) {
                    image3.setSelected(true);

                    image3.setBackground(highlight);

                    click3 = 1;

                    marcadas++;
                }
                else {
                    image3.setSelected(false);

                    image3.setBackground(null);

                    click3 = 0;

                    marcadas--;
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(image4.isSelected() == false) {
                    image4.setSelected(true);

                    image4.setBackground(highlight);

                    click4 = 1;

                    marcadas++;
                }
                else {
                    image4.setSelected(false);

                    image4.setBackground(null);

                    click4 = 0;

                    marcadas--;
                }
            }
        });

        return view;
    }


}
