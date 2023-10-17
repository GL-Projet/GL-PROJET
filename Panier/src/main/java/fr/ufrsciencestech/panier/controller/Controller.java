/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;


/**
 *
 * @author HP
 */
public class Controller {
    
<<<<<<< Updated upstream
    //private VueGSwing vgs;
    private VueGSwing vgs;
    private VueConsole vc;
=======
    private ConnexionBDD cnxdb;
    private InterfaceCreerFruit cf;
    private InterfaceFruit fr;
    private InterfaceCreerPanier cp;
    private InterfacePanier ip;
    private Fruit fruit;
>>>>>>> Stashed changes
    private Panier panier;
    

    
    
    
   
<<<<<<< Updated upstream
    public Controller(VueGSwing viewgs, VueConsole viewc){
        this.vgs = viewgs;
        this.vc = viewc;
        this.panier = new Panier("",5);
        this.compteur = 0;
        
        //pour initialiser le jlabel compteur
        vgs.setCompteur(String.valueOf(getCompteur()));
        
        //l'action du clic sur le bouton plus
        viewgs.addButtonPlusListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                increment();
                if(panier.estPlein()){
                    vgs.desactiverButtonPlus();
                    setCompteur(5);
                }
                vgs.setCompteur(String.valueOf(getCompteur()));
                if(getCompteur() == 1){
                    vgs.activerButtonMoins();
                }
                
                //l'ajout du fruit au panier
                try{
                    panier.ajout(new Orange());
                }catch (Panier.PanierPleinException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                vc.setPanier(panier.toString());
                if(getCompteur() == 5){
                    vc.setInfoLabel("Le panier est plein!!");
                }else {
                    vc.setInfoLabel("Fruit ajouté au panier avec succés!");
                }
            }
        });
        
        //l'action du clic sur le bouton moins
        viewgs.addButtonMoinsListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                decrement();
                if(panier.estVide()){
                    vgs.desactiverButtonMoins();
                    setCompteur(0);
                }
                vgs.setCompteur(String.valueOf(getCompteur()));
                if(getCompteur() == 4){
                    vgs.activerButtonPlus();
                }
                
                //retrait
                try{
                    panier.retrait();
                }catch (Panier.PanierVideException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                vc.setPanier(panier.toString());
                if(getCompteur()==0){
                    vc.setInfoLabel("Le panier est vide!!!");
                }else {
                    vc.setInfoLabel("Le fruit a été retiré avec succés!!");
                }
            }
        });
    }
    
    public VueGSwing getVGS(){
        return this.vgs;
    }
    
    public VueConsole getVC(){
        return this.vc;
    }
    
    public Panier getPanier(){
        return this.panier;
=======
    public Controller(InterfaceCreerFruit viewCF, InterfaceFruit viewIF, InterfaceCreerPanier viewCP, InterfacePanier viewIP){
        this.cf = viewCF;
        this.fr = viewIF;
        this.cp = viewCP;
        this.ip = viewIP;
        
        
        //pour remplir la liste du fruit proposée
        remplirLF();
        //pour remplir la liste des paniers disponibles
        remplirLP();
        
        //l'action sur le bouton valider pour creer un fruit
        viewCF.buttonValiderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                fruit = new Fruit(cf.getNom(), cf.getPrix(), cf.getOrigine(), cf.gettype());
                cnxdb.insertFruit(fruit.getName(), fruit.getPrice(), fruit.getOrigin(), fruit.getType());
                cnxdb.closeConnection();
                fr.ecraserLF();
                remplirLF();
            }
        });
        
        //l'action sur le bouton valider pour creer un panier
        viewCP.buttonValiderListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cnxdb = new ConnexionBDD();
                panier = new Panier(cp.getNom(), cp.gettype(), cp.getCapacite());
                cnxdb.insertPanier(panier.getName(), panier.getType(), panier.getContenanceMax(), panier.getPrixtotale());
                cnxdb.closeConnection();
                ip.ecraserLP();
                remplirLP();
            }
        });
        
        
        //l'action sur le bouton modifier dans l'interface du panier
        viewIP.buttonModifierListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fr.setVisible(true);
            }
        });
        
        //l'action sur le bouton (jmenu) creer fruit dans l'interface du panier
        viewIP.buttonCreerFruitListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cf.setVisible(true);
            }
        });
        
        //l'action sur le bouton (jmenu) creer panier dans l'interface du panier
        viewIP.buttonCreerPanierListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cp.setVisible(true);
            }
        });
        
        //l'action sur le bouton recherche fruit avec filtre
        viewIF.buttonRechercherListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               String filter = fr.getFilter();
               switch (filter){
                    case "Fruit":{
                        fr.ecraserLF();
                        remplirLFbyname(fr.getFilterText(), filter);
                    } break;
                    case "Origine":{
                        fr.ecraserLF();
                        remplirLFbyname(fr.getFilterText(), filter);
                    } break;
                    case "Type":{
                        fr.ecraserLF();
                        remplirLFbyname(fr.getFilterText(), filter);
                    } break;
                }
           }
        });
        
        //l'action sur le bouton d'ajouter et supprimer un pays à boycotter dans classe InterfaceFruit
        viewIF.buttonAjoutBoycottListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                DefaultListModel<String> listPays = fr.getListeBoycott();
                cnxdb = new ConnexionBDD();
                List<Fruit> fruits;
                fruits = cnxdb.listeFruit();
                
                for(String pays : Collections.list(listPays.elements())){
                    Iterator<Fruit> it = fruits.iterator();
                    while(it.hasNext()){
                        Fruit fruit = it.next();
                        if(fruit.getOrigin().equals(pays)){
                            it.remove();
                        }
                    }
                }
                fr.ecraserLF();
                for (Fruit f : fruits){
                    fr.remplirComboBox(f.toString());
                }
                cnxdb.closeConnection();
            }
        });
        
>>>>>>> Stashed changes
    }
    

   
    //recuperer la liste du fruit depuis la bdd et remplir la liste proposée dans InterfaceFruit
    public void remplirLF(){
        this.cnxdb = new ConnexionBDD();
        List<Fruit> fruits;
        fruits = cnxdb.listeFruit();
        for (Fruit f : fruits){
            fr.remplirComboBox(f.toString());
        }
        cnxdb.closeConnection();
        
    }
    
    //recuperer la liste du fruit depuis la bdd en utilisant le filtre du nom
    public void remplirLFbyname(String text, String filter){
        this.cnxdb = new ConnexionBDD();
        List<Fruit> fruits;
        fruits = cnxdb.getFruitByName(text, filter);
        for (Fruit f : fruits){
            fr.remplirComboBox(f.toString());
        }
        cnxdb.closeConnection();
    }
    
    //recuperer la liste des paniers depuis la bdd et remplir la liste des paniers disponibles dans InterfacePanier
    public void remplirLP(){
        this.cnxdb = new ConnexionBDD();
        List<String> panier;
        panier = cnxdb.listePanier();
        for (String name : panier){
            ip.remplirListPanier(name);
        }
        cnxdb.closeConnection();
    }
}
