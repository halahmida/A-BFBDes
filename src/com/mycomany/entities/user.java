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
public class user {
    
    private int id;
    private String email,name,prenomc;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenomc() {
        return prenomc;
    }

    public void setPrenomc(String prenomc) {
        this.prenomc = prenomc;
    }

    @Override
    public String toString() {
        return "user{" + "email=" + email + ", name=" + name + ", prenomc=" + prenomc + '}';
    }

    public user() {
    }

    public user(String email) {
        this.email = email;
    }

    public user(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public user(String email, String name, String prenomc) {
        this.email = email;
        this.name = name;
        this.prenomc = prenomc;
    }
    
    
}
