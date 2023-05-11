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
import com.mycomany.entities.type;
import com.mycompany.services.Servicetype;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public class ListTypeForm extends BaseForm {
    
      public ListTypeForm(Resources res)  {
        setTitle("Liste des types");
        setLayout(BoxLayout.y());

        ArrayList<type> type = Servicetype.getInstance().affichagetype();

        for (type p : type)
        {
           Label nom= new Label("Nom :"+p.getNom());
           Label description=new Label("description :"+p.getDescription());
          
           //Label nombre= new Label("nombre :"+p.getNombre());
          
           add(nom);
           add(description);
          
           //add(nombre);

            Button btnDelete = new Button("Supprimer");
            Button btnUpdate = new Button("Modifier");
            add(btnDelete);
            add(btnUpdate);

            // Delete button
            btnDelete.addActionListener(e -> {
                if (Dialog.show("Confirmation", "Voulez-vous vraiment supprimer ce cours ?", "Oui", "Non")) {
                    Servicetype.getInstance().deleteReclamation(p.getId());
                    this.removeComponent(nom);
                    this.removeComponent(description);
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
