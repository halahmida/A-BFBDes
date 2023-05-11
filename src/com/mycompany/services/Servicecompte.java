
package com.mycompany.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
//import com.mycomany.entities.Reclamation;
import com.mycomany.entities.comptebancaire;
import com.mycomany.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Lenovo
 */
public class Servicecompte {
    
    //singleton 
    public static Servicecompte instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static Servicecompte getInstance() {
        if(instance == null )
            instance = new Servicecompte();
        return instance ;
    }
    
    
    
    public Servicecompte() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajoutReclamation(comptebancaire reclamation) {
        
        String url =Statics.BASE_URL+"/comptebancaire/addcomptesJSON?nom="+reclamation.getNom()+"&prenom="+reclamation.getPrenom()+"&email="+reclamation.getEmail()+"&num_tlfn="+reclamation.getNum_tlfn()+"&solde_initial="+reclamation.getSolde_initial(); // aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    //affichage
    
    public ArrayList<comptebancaire>affichageCompte() {
        ArrayList<comptebancaire> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/allcomptebancaire";
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp ;
            jsonp = new JSONParser();
            
            try {
                Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");
                
                for(Map<String, Object> obj : listOfMaps) {
                    comptebancaire re = new comptebancaire();
                    
                    //dima id fi codename one float 5outhouha
                    //float id = Float.parseFloat(obj.get("id").toString());
                    
                    String nom = obj.get("nom").toString();
                    
                    String prenom = obj.get("prenom").toString();
                    String email = obj.get("email").toString();
                   // float solde_initial = Float.parseFloat(obj.get("solde_initial").toString());
                   // int num_tlfn = Integer.parseInt(obj.get("num_tlfn").toString());
                    
                    //re.setId((int)id);
                    re.setNom(nom);
                    re.setPrenom(prenom);
                    re.setEmail(email);
                   // re.setNum_tlfn((int)num_tlfn);
                    //re.setSolde_initial((float)solde_initial);
                    

                    
                    
                    //insert data into ArrayList result
                    result.add(re);
                    
                    
                }
            
            }catch(Exception ex) {
                
                ex.printStackTrace();
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    
    
   
    
    
    //Delete 
    public boolean deleteReclamation(int id ) {
        String url = Statics.BASE_URL +"/deletecomptebancaireJSON/"+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    
    //Update 
    public boolean modifierReclamation(comptebancaire reclamation) {
        String url = Statics.BASE_URL +"/updatecomptesJSON?id="+reclamation.getId()+"&nom="+reclamation.getNom()+"&prenom="+reclamation.getPrenom()+"&email="+reclamation.getEmail()+"&num_tlfn="+reclamation.getNum_tlfn()+"&solde_initial="+reclamation.getSolde_initial();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    

    
}