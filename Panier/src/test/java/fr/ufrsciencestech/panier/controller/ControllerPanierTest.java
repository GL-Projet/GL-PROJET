package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.controller.ControllerPanier;
import fr.ufrsciencestech.panier.model.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerPanierTest {
    private ControllerPanier cp;
    @Before
    public void setUp(){
        cp=new ControllerPanier();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInsertPanierIntoListe(){
        Panier p1=new Panier("Test1",5);
        try {
            p1.ajout(new Banane());
        } catch (Panier.PanierPleinException e) {
            throw new RuntimeException(e);
        }
        Panier p2=new Panier("Test1",5);
        cp.insertPanier(p1);
        cp.insertPanier(p2);
    }
    

}
