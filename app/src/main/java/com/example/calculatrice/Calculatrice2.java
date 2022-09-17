package com.example.calculatrice;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculatrice2 extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText editText;
    TextView txt;
    float chiffre;
    private boolean clicOperateur = false, update = false;
    private String operateur = "";
    int favoriteColor;
    String name;
    boolean addition, subtraction, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.txt);
        txt.setText("hello "+name);

button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonDivision = (Button) findViewById(R.id.buttondiv);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        editText = (EditText) findViewById(R.id.edt1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                editText.setText(editText.getText() + "1");
            }
        });

        button2.setOnClickListener(new ChiffreListener() );

        button3.setOnClickListener(new ChiffreListener());

        button4.setOnClickListener(new ChiffreListener());

        button5.setOnClickListener(new ChiffreListener());

        button6.setOnClickListener(new ChiffreListener());

        button7.setOnClickListener(new ChiffreListener());

        button8.setOnClickListener(new ChiffreListener());

        button9.setOnClickListener(new ChiffreListener());

        button0.setOnClickListener(new ChiffreListener());


/*deux cas possibles
1- Premier click sur l'opérateur "+"
    1.1. récupérer la valeur
    1.2. clicOperateur =true
2- opérateur "+" joue le role de "=" si on va ajouter une autre opération
    2.1. calcul() cette méthode va retourner nouelle valeur de l'attribut global "chiffre"
    2.2. afficher le resultat intermediaire sur ecran
*/


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur="+";
                if (clicOperateur) {
            calcul();
            editText.setText(String.valueOf(chiffre));
                } else {
                    chiffre = Float.parseFloat(editText.getText() + "");
                    clicOperateur=true;
                    update=true;

                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur="-";
                if (clicOperateur) {
                    calcul();
                } else {
                    chiffre = Float.parseFloat(editText.getText() + "");
                    clicOperateur=true;
                    update=true;

                }

            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur="*";
                if (clicOperateur) {
                    calcul();
                } else {
                    chiffre = Float.parseFloat(editText.getText() + "");
                    clicOperateur=true;
                    update=true;

                }
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateur="/";
                if (clicOperateur) {
                    calcul();
                } else {
                    chiffre = Float.parseFloat(editText.getText() + "");
                    clicOperateur=true;
                    update=true;
                }

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcul();
                clicOperateur = false;
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicOperateur=false;
                chiffre=0;
                operateur="";
                editText.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + ".");
            }
        });
    }
    void calcul() {
        if (operateur.equals( "+")) {
            chiffre=chiffre+ Float.parseFloat(String.valueOf(editText.getText() ));
            editText.setText(chiffre+ "");
        }

        if (operateur.equals( "-")) {
            chiffre=chiffre- Float.parseFloat(String.valueOf(editText.getText() ));
            editText.setText(chiffre+ "");
        }

        if (operateur.equals( "*")) {
            chiffre=chiffre* Float.parseFloat(String.valueOf(editText.getText() ));
            editText.setText(chiffre+ "");
        }

        if (operateur.equals( "/")) {
            try {
                chiffre = chiffre / Float.parseFloat(String.valueOf(editText.getText()));
            }
            catch (ArithmeticException e){
                editText.setText("0");
            }
            editText.setText(chiffre+ "");
        }
    }


    private class ChiffreListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String str = ( (Button) v).getText().toString();

            if (update) {
                update = false;
            }else{
                if (!editText.getText().equals("0"))
                    str = editText.getText() + str;
            }

            editText.setText(str) ;

        }
    }
}