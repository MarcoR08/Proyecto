package com.cet23.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;



public class Agregar_Nuevo extends AppCompatActivity {
    private EditText txtnombre;
    private EditText txtnocontrol;
    private Button OK;
    private Button cancelar;
    List<Alumno> alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__nuevo);
        configUI();
//        inicializar();
        configListeners();
    }

    private void configListeners() {

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Misc.modificado=false;
                finish();
            }
        });
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean XD =false;
                String a = txtnombre.getText().toString();
                String b = txtnocontrol.getText().toString();
                if (a.equals("")){
                    Toast.makeText(getApplicationContext(),"Null", Toast.LENGTH_LONG).show();
                    XD=false;

                }else {
                    XD=true;
                }if (b.equals("")){
                    Toast.makeText(getApplicationContext(),"Null", Toast.LENGTH_LONG).show();
                    XD=false;
                }else{
                    XD=true;
                }if (XD){
                    Misc.a=a;
                    Misc.b=b;
                    Misc.nuevo=true;
                    finish();
                }


            }
        });

    }

    private void configUI(){
        txtnombre = findViewById(R.id.nombrenuevo);
        txtnocontrol= findViewById(R.id.nocontrolnuevo);
        OK = findViewById(R.id.OKnuevo);
        cancelar = findViewById(R.id.Cancelarnuevo);
    }

   //private void enviar() {

     //alumnos.add();

    //}
}
