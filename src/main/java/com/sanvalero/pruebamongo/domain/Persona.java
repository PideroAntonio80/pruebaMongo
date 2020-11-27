package com.sanvalero.pruebamongo.domain;

/**
 * Creado por @ author: Pedro Orós
 * el 21/11/2020
 */
public class Persona {

    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    Persona persona;
    String nombreAnterior;
    String apellidoAnterior;
    int edadAnterior;

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(Persona persona, String nombre, String apellidos, int edad) {
        this.persona = persona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(String nombreAnterior, String apellidoAnterior, int edadAnterior, String nombre, String apellidos, int edad) {
        this.nombreAnterior = nombreAnterior;
        this.apellidoAnterior = apellidoAnterior;
        this.edadAnterior = edadAnterior;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;

    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombreAnterior() {
        return nombreAnterior;
    }

    public void setNombreAntrior(String nombreAnterior) {
        this.nombreAnterior = nombreAnterior;
    }

    public String getApellidoAnterior() {
        return apellidoAnterior;
    }

    public void setApellidoAnterior(String apellidoAnterior) {
        this.apellidoAnterior = apellidoAnterior;
    }

    public int getEdadAnterior() {
        return edadAnterior;
    }

    public void setEdadAnterior(int edadAnterior) {
        this.edadAnterior = edadAnterior;
    }

    public String toString() {
        return this.nombre + this.apellidos + ", Edad: " + this.edad;
    }



}
