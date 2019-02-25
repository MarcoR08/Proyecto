package com.cet23.myapplication;

public class Alumno {
    private String nombre;
    private String no_control;


    public Alumno(String nombre, String no_control) {
        this.nombre = nombre;
        this.no_control = no_control;

    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNo_control() {
        return no_control;
    }

    public void setNo_control(String no_control) {
        this.no_control = no_control;
    }
}
