/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
//import com.mycomany.entities.comptebancaire;
import com.mycomany.entities.service;
import com.mycomany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class Service {
     //singleton 
    public static Service instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static Service getInstance() {
        if(instance == null )
            instance = new Service();
        return instance ;
    }
    
    
    
    public Service() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajoutReclamation(service reclamation) {
        
        String url =Statics.BASE_URL+"/addserviceJSON/new?type="+reclamation.getType(); // aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation
        System.out.println("HOOOUUUUNI ");
        System.out.println(url);
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    //affichage
    
    public ArrayList<service>affichageservice() {
        ArrayList<service> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/allsevice";
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp ;
            jsonp = new JSONParser();
            
            try {
                Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");
                
                for(Map<String, Object> obj : listOfMaps) {
                    service re = new service();
                    
                    //dima id fi codename one float 5outhouha
                    //float id = Float.parseFloat(obj.get("id").toString());
                    
                    String type = obj.get("type").toString();
                    
                    
                   // float solde_initial = Float.parseFloat(obj.get("solde_initial").toString());
                   // int num_tlfn = Integer.parseInt(obj.get("num_tlfn").toString());
                    
                    //re.setId((int)id);
                    re.setType(type);
                   
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
//    public boolean modifierReclamation(comptebancaire reclamation) {
//        String url = Statics.BASE_URL +"/updatecomptesJSON?id="+reclamation.getId()+"&nom="+reclamation.getNom()+"&prenom="+reclamation.getPrenom()+"&email="+reclamation.getEmail()+"&num_tlfn="+reclamation.getNum_tlfn()+"&solde_initial="+reclamation.getSolde_initial();
//        req.setUrl(url);
//        
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
//                req.removeResponseListener(this);
//            }
//        });
//        
//    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
//    return resultOk;
//        
//    }
    
}
