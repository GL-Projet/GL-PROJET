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

    private Panier panier;
    private Orange orange;
    private int compteur;
    
    
   
    public Controller(){
        this.panier = new Panier("",5);
        this.compteur = 0;
    }
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
