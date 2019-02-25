package com.cet23.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Detail_Activity extends AppCompatActivity {
    private EditText txtnombre;
    private EditText txtnocontrol;
    private Button OK;
    private Button cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        configUI();
        inicializar();
        configListeners();

    }

    private void configListeners() {

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ban=false;
                if (txtnombre.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_LONG).show();

                }else {
                    ban= true;
                }if (txtnocontrol.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"null",Toast.LENGTH_LONG).show();
ban= false;
                }else{
                    ban= true;
                }

if (ban){
    Misc.alumno.setNombre(txtnombre.getText().toString());
    Misc.alumno.setNo_control(txtnocontrol.getText().toString());
    Misc.modificado=true;
    finish();
}


            }
        });

    }

    private void configUI(){
        txtnombre = findViewById(R.id.nombre);
        txtnocontrol= findViewById(R.id.nocontrol);
        OK = findViewById(R.id.OK);
        cancelar = findViewById(R.id.Cancelar);
    }

    private void inicializar() {

        txtnombre.setText(Misc.alumno.getNombre());
        txtnocontrol.setText(Misc.alumno.getNo_control());

    }
}
