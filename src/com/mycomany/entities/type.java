/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomany.entities;

/**
 *
 * @author USER
 */
public class type {
    private int id,nombre;
    private String nom,description;

    public type() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "type{" + "id=" + id + ", nombre=" + nombre + ", nom=" + nom + ", description=" + description + '}';
    }

    public type(int id, int nombre, String nom, String description) {
        this.id = id;
        this.nombre = nombre;
        this.nom = nom;
        this.description = description;
    }

    public int getNombre() {
        return nombre;
    }

    public type(int nombre, String nom, String description) {
        this.nombre = nombre;
        this.nom = nom;
        this.description = description;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
