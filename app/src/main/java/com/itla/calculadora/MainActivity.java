package com.itla.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String mostrar ="",operador="",anterior="";
    Button btncero,btnuno,btndos,btntres,btncuatro,btncinco,btnseis,btnsiete,btnocho,btnnueve,
    btnsuma,btnresta,btnmultiplicacion,btndivision,btnpunto,btnigual,btnclear,btnporciento;
    TextView tvresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncero=findViewById(R.id.btncero);
        btnuno=findViewById(R.id.btnuno);
        btndos=findViewById(R.id.btndos);
        btntres=findViewById(R.id.btntres);
        btncuatro=findViewById(R.id.btncuatro);
        btncinco=findViewById(R.id.btncinco);
        btnseis=findViewById(R.id.btnseis);
        btnsiete=findViewById(R.id.btnsiete);
        btnocho=findViewById(R.id.btnocho);
        btnnueve=findViewById(R.id.btnnueve);

        btnsuma=findViewById(R.id.btnsuma);
        btnresta=findViewById(R.id.btnresta);
        btnmultiplicacion=findViewById(R.id.btnmultiplicacion);
        btndivision=findViewById(R.id.btndivision);

        btnigual=findViewById(R.id.btnigual);
        btnpunto=findViewById(R.id.btnpunto);
        btnporciento=findViewById(R.id.btnporciento);
        btnclear=findViewById(R.id.btnclear);

        tvresultado=findViewById(R.id.tvresultado);

        btncero.setOnClickListener(this);
        btnuno.setOnClickListener(this);
        btndos.setOnClickListener(this);
        btntres.setOnClickListener(this);
        btncuatro.setOnClickListener(this);
        btncinco.setOnClickListener(this);
        btnseis.setOnClickListener(this);
        btnsiete.setOnClickListener(this);
        btnocho.setOnClickListener(this);
        btnnueve.setOnClickListener(this);

        btnsuma.setOnClickListener(this);
        btnresta.setOnClickListener(this);
        btnmultiplicacion.setOnClickListener(this);
        btndivision.setOnClickListener(this);

        btnpunto.setOnClickListener(this);
        btnigual.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnporciento.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button btnpresionado=(Button) v;
        String valorPresionado =btnpresionado.getText().toString().trim();
        boolean limpiar=false;

        switch (valorPresionado){
            case "+":
                operador=valorPresionado;
                limpiar=true;
                break;
            case "-":
                operador=valorPresionado;
                limpiar=true;
                break;
            case "x":
                operador=valorPresionado;
                limpiar=true;
                break;
            case "/":
                operador=valorPresionado;
                limpiar=true;
                break;
            case "=":
                double valor1=Double.parseDouble(anterior);
                double valor2 =Double.parseDouble(mostrar);
                double resultado=0;

                switch (operador){
                    case "+":
                        resultado=valor1+valor2;
                        break;
                    case "-":
                        resultado=valor1-valor2;
                        break;
                    case "x":
                        resultado=valor1*valor2;
                        break;
                    case "/":
                        if(valor2==0){
                           valor2=1;
                        }
                        resultado=valor1/valor2;
                        break;
                }
                mostrar=String.valueOf(resultado);
                int indexOfDecimal = mostrar.indexOf(".");
                if(Double.parseDouble(mostrar.substring(indexOfDecimal))==0){
                    mostrar=mostrar.substring(0,indexOfDecimal);
                }
                operador="";
                break;
            case "Clear":
                mostrar="";
                operador="";
                anterior="";
                break;
            case "%":
                mostrar=String.valueOf(Double.parseDouble(mostrar)/100);
                break;
            default:
                    mostrar+=valorPresionado;
                    break;
        }

        if(limpiar){
            anterior=mostrar;
            mostrar="";
        }

        tvresultado.setText(mostrar);
    }
}
