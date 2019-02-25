package com.cet23.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterAlumno.OnClickListener {
    List<Alumno> alumnos = new ArrayList<Alumno>();
    private RecyclerView rclvAlumnos;
    AdapterAlumno adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configDataSource();
        configRecyclerView();
    }

    private void configDataSource() {




    }

    private void configRecyclerView() {
        rclvAlumnos = findViewById(R.id.rclvAlumnos);
        adapter = new AdapterAlumno(alumnos, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rclvAlumnos.setLayoutManager(linearLayoutManager);
        rclvAlumnos.setAdapter(adapter);
    }

    public void onClickListener(Alumno alumno) {

        Misc.alumno = alumno;
        Misc.indexAlumno = alumnos.indexOf(alumno);
        Misc.modificado = false;
        Misc.nuevo=false;

        Intent intent = new Intent(getApplicationContext(), Detail_Activity.class);
        startActivity(intent);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.Agregar:
               Intent intent = new Intent(getApplicationContext(), Agregar_Nuevo.class);
               startActivity(intent);

               break;
       }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLongClickListenert(Alumno alumno) {
        alumnos.remove(alumnos.indexOf(alumno));
        adapter.notifyDataSetChanged();
    }


    protected void onStart() {
        super.onStart();
        if (Misc.modificado) {

            alumnos.set(Misc.indexAlumno, Misc.alumno);
            adapter.notifyDataSetChanged();
            Misc.modificado=false;
            Misc.nuevo=false;
        }if (Misc.nuevo){
            alumnos.add(new Alumno(Misc.a,Misc.b));
          Misc.nuevo=false;
        }

    }
}
