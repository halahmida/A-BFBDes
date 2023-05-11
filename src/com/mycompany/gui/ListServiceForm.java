/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import com.mycomany.entities.service;
import com.mycompany.services.Service;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public class ListServiceForm extends BaseForm {
    
      public ListServiceForm(Resources res)  {
        setTitle("Liste des service");
        setLayout(BoxLayout.y());

        ArrayList<service> service = Service.getInstance().affichageservice();

        for (service p : service)
        {
           Label nom= new Label("Type :"+p.getType());
          
           //Label nombre= new Label("nombre :"+p.getNombre());
          
           add(nom);
          
           //add(nombre);

            Button btnDelete = new Button("Supprimer");
            Button btnUpdate = new Button("Modifier");
            add(btnDelete);
            add(btnUpdate);

            // Delete button
            btnDelete.addActionListener(e -> {
                if (Dialog.show("Confirmation", "Voulez-vous vraiment supprimer ce cours ?", "Oui", "Non")) {
                    Service.getInstance().deleteReclamation(p.getId());
                    this.removeComponent(nom);
                    //this.removeComponent(nombre);
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
