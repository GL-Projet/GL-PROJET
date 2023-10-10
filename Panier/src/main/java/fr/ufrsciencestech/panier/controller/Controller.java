/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.model.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Controller {
    
    //private VueGSwing vgs;
//    private VueGSwing vgs;
//    private VueConsole vc;
    private Panier panier;
    private Orange orange;
    private int compteur;
    
    
   
    public Controller(){
//            (VueGSwing viewgs, VueConsole viewc){
//        this.vgs = viewgs;
//        this.vc = viewc;
        this.panier = new Panier("",5);
        this.compteur = 0;
        
        //pour initialiser le jlabel compteur
//        vgs.setCompteur(String.valueOf(getCompteur()));
//
//        //l'action du clic sur le bouton plus
////        viewgs.addButtonPlusListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                increment();
//                if(panier.estPlein()){
//                    vgs.desactiverButtonPlus();
//                    setCompteur(5);
//                }
//                vgs.setCompteur(String.valueOf(getCompteur()));
//                if(getCompteur() == 1){
//                    vgs.activerButtonMoins();
//                }
//
//                //l'ajout du fruit au panier
//                try{
//                    panier.ajout(new Orange());
//                }catch (Panier.PanierPleinException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                vc.setPanier(panier.toString());
//                if(getCompteur() == 5){
//                    vc.setInfoLabel("Le panier est plein!!");
//                }else {
//                    vc.setInfoLabel("Fruit ajouté au panier avec succés!");
//                }
//            }
//        });
        
        //l'action du clic sur le bouton moins
//        viewgs.addButtonMoinsListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                decrement();
//                if(panier.estVide()){
//                    vgs.desactiverButtonMoins();
//                    setCompteur(0);
//                }
//                vgs.setCompteur(String.valueOf(getCompteur()));
//                if(getCompteur() == 4){
//                    vgs.activerButtonPlus();
//                }
//
//                //retrait
//                try{
//                    panier.retrait();
//                }catch (Panier.PanierVideException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                vc.setPanier(panier.toString());
//                if(getCompteur()==0){
//                    vc.setInfoLabel("Le panier est vide!!!");
//                }else {
//                    vc.setInfoLabel("Le fruit a été retiré avec succés!!");
//                }
//            }
//        });
    }
    
//    public VueGSwing getVGS(){
//        return this.vgs;
//    }
//
//    public VueConsole getVC(){
//        return this.vc;
//    }
    
    public Panier getPanier(){
        return this.panier;
    }
    
    public Orange getOrange(){
        return this.orange;
    }
    
    public int getCompteur(){
        return this.compteur;
    }
    
    public void setCompteur(int cpt){
        this.compteur = cpt;
    }
    
    public void increment(){
        this.compteur++;
    }
    
    public void decrement(){
        this.compteur--;
    }
    
    
}
