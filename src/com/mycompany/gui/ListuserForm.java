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
import com.mycomany.entities.user;
import com.mycompany.services.Servicecompte;
import com.mycompany.services.Serviceuser;
import java.util.ArrayList;

/**
 *
 * @author ANAS
 */


public class ListuserForm extends BaseForm {

    public ListuserForm(Resources res)  {
        setTitle("Liste des comptes");
        setLayout(BoxLayout.y());

        ArrayList<user> user = Serviceuser.getInstance().affichageuser();

        for (user p : user)
        {
           Label name= new Label("Nom :"+p.getName());
           Label prenom=new Label("prenom :"+p.getPrenomc());
           Label email=new Label("email :"+p.getEmail());
           
           add(name);
           add(prenom);
           
           add(email);
          

            Button btnDelete = new Button("Supprimer");
            Button btnUpdate = new Button("Modifier");
            add(btnDelete);
            add(btnUpdate);

            // Delete button
            btnDelete.addActionListener(e -> {
                if (Dialog.show("Confirmation", "Voulez-vous vraiment supprimer ce cours ?", "Oui", "Non")) {
                    Servicecompte.getInstance().deleteReclamation(p.getId());
                    this.removeComponent(name);
                    this.removeComponent(prenom);
                    
                    this.removeComponent(email);
                    
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

