/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycomany.entities.comptebancaire;
import com.mycompany.services.Servicecompte;
import java.util.ArrayList;

/**
 *
 * @author ANAS
 */


public class ListCompteForm extends BaseForm {

    public ListCompteForm(Resources res)  {
        setTitle("Liste des comptes");
        setLayout(BoxLayout.y());

        ArrayList<comptebancaire> comptebancaire = Servicecompte.getInstance().affichageCompte();

        for (comptebancaire p : comptebancaire)
        {
           Label nom= new Label("Nom :"+p.getNom());
           Label prenom=new Label("prenom :"+p.getPrenom());
           Label num_tlfn=new Label("num_tlfn :"+p.getNum_tlfn());
           Label email= new Label("email :"+p.getEmail());
           Label solde_initial= new Label("solde_initial :"+p.getSolde_initial());
           add(nom);
           add(prenom);
           add(num_tlfn);
           add(email);
           add(solde_initial);

            Button btnDelete = new Button("Supprimer");
            Button btnUpdate = new Button("Modifier");
            add(btnDelete);
            add(btnUpdate);

            // Delete button
            btnDelete.addActionListener(e -> {
                if (Dialog.show("Confirmation", "Voulez-vous vraiment supprimer ce cours ?", "Oui", "Non")) {
                    Servicecompte.getInstance().deleteReclamation(p.getId());
                    this.removeComponent(nom);
                    this.removeComponent(prenom);
                    this.removeComponent(num_tlfn);
                    this.removeComponent(email);
                    this.removeComponent(solde_initial);
                    this.removeComponent(btnDelete);
                    this.removeComponent(btnUpdate);
                    this.refreshTheme();
                }
            });

            // Update button
            btnUpdate.addActionListener(e -> {
              //new EditCompteForm(c).show();
            });

            add(createSeparator());
        }
    }

    private Component createSeparator() {
        Label separator = new Label(" ");
        separator.setUIID("Separator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

}

