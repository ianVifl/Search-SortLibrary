/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectbiblioteca;

/**
 *
 * @author ianvi
 */
public class Libro {
        private int ID;
    private int ISBN;
    private int anio;
    private String titulo;
    private String genero;
    private String autor;
    
    public int getID() {
    return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
   
    public int getanio() {
        return anio;
    }

    public void setanio(int anio) {
        this.anio = anio;
    
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    @Override
    public String toString(){
        return "ID: "+ID+"\nISBN: "+ ISBN +"\nTitulo: "+titulo+"\nTema: "+genero+"\nAutor: "+autor +"\nAño: " + anio   ;
    }
         }