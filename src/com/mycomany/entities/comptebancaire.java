/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomany.entities;

/**
 *
 * @author ANAS
 */
public class comptebancaire {
    private int id,num_tlfn;
    private String nom,prenom,email;
    private float solde_initial;

    public comptebancaire(int id, int num_tlfn, String nom, String prenom, String email, float solde_initial) {
        this.id = id;
        this.num_tlfn = num_tlfn;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.solde_initial = solde_initial;
    }

    public comptebancaire() {
    }

    public comptebancaire(int num_tlfn, String nom, String prenom, String email, float solde_initial) {
        this.num_tlfn = num_tlfn;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.solde_initial = solde_initial;
    }

    public int getId() {
        return id;
    }

    public int getNum_tlfn() {
        return num_tlfn;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public float getSolde_initial() {
        return solde_initial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_tlfn(int num_tlfn) {
        this.num_tlfn = num_tlfn;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "comptebancaire{" + "id=" + id + ", num_tlfn=" + num_tlfn + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", solde_initial=" + solde_initial + '}';
    }
    

   /* @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
*/
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSolde_initial(float solde_initial) {
        this.solde_initial = solde_initial;
    }
    
    
}
