package fr.ufrsciencestech.panier.controller;

//import fr.ufrsciencestech.panier.controller.ControllerPanier;
//import fr.ufrsciencestech.panier.model.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;

public class ControllerPanierTest {
//    private ControllerPanier cp;
//    @Before
//    public void setUp(){
//        cp=new ControllerPanier();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testInsertPanierIntoListe(){
//        Panier p1=new Panier("Test1",5);
//        Panier p2=new Panier("Test1",5);
//        cp.insertPanier(p1);
//        cp.insertPanier(p2);
//    }
//    @Test
//    public void testInsertPanierIntoListeEmpty(){
//        Panier p1=new Panier("Test1",5);
//        cp.insertPanier(p1);
//    }
//
//
//    @Test(expected = ArrayStoreException.class)
//    public void testRemovePanierFromListeVide(){
//        cp.removePanier("Test1");
//    }
//    @Test(expected = IllegalArgumentException.class)
//    public void testRemovePanierDoesntExistFromListe(){
//        Panier p1=new Panier("Test1",5);
//        Panier p2=new Panier("Test2",5);
//        cp.insertPanier(p1);
//        cp.insertPanier(p2);
//        cp.removePanier("Test3");
//    }
//    @Test(expected = IllegalArgumentException.class)
//    public void testRemovePanierFromListe(){
//        Panier p1=new Panier("Test1",5);
//        Panier p2=new Panier("Test2",5);
//        cp.insertPanier(p1);
//        cp.insertPanier(p2);
//        cp.removePanier("Test1");
//        cp.removePanier("Test1");
//    }
//
//    @Test(expected = ArrayStoreException.class)
//    public void testlistePanierFruitOrigineVide(){
//       cp.listePanierFruitOrigine("Espagne");
//    }
//
//    @Test
//    public void testlistePanierFruitOrigine(){
//        Panier p1=new Panier("Test1",5);
//        try {
//            p1.ajout(new Fraise());
//        }catch (Panier.PanierPleinException e){
//            System.err.println(e.getMessage());
//        }
//        cp.insertPanier(p1);
//        assertEquals(false, cp.listePanierFruitOrigine("Espagne").isEmpty());
//    }
//
//    @Test(expected = ArrayStoreException.class)
//    public void testlistePanierNomVide(){
//        cp.listePanierNom("Test1");
//    }
//
//    @Test
//    public void testlistePanierNom(){
//        Panier p1=new Panier("Espagne",5);
//        cp.insertPanier(p1);
//        assertEquals(false, cp.listePanierNom("Espagne").isEmpty());
//    }
//
//
//    @Test(expected = ArrayStoreException.class)
//    public void testlistePanierFruitVide(){
//        cp.listePanierFruit("Test1");
//    }
//    @Test
//    public void testlistePanierFruit(){
//        Panier p1=new Panier("Test1",5);
//        try {
//            p1.ajout(new Orange());
//        }catch (Panier.PanierPleinException e){
//            System.err.println(e.getMessage());
//        }
//        cp.insertPanier(p1);
//        assertEquals(false, cp.listePanierFruit("Orange").isEmpty());
//    }
//
//
//    @Test(expected = ArrayStoreException.class)
//    public void testfilterOrigineFruitPanierVide(){
//        cp.filterOrigineFruitPanier(new Panier("Panier1",5),"France");
//    }
//
//    @Test(expected = ArrayStoreException.class)
//    public void testfilterNomFruitPanierVide(){
//        cp.filterNomFruitPanier(new Panier("Panier1",5),"Orange");
//    }
//
//
//    @Test(expected = ArrayStoreException.class)
//    public void testfilterPrixtotalePanierVide(){
//        cp.filterPrixtotalePanier(10.5);
//    }
//    @Test
//    public void testfilterPrixtotalePanier(){
//        Panier p1=new Panier("Test1",5);
//        try {
//            p1.ajout(new Orange());
//            p1.ajout(new Orange());
//            p1.ajout(new Orange());
//        }catch (Panier.PanierPleinException e){
//            System.err.println(e.getMessage());
//        }
//        System.out.println(p1.getPrixtotale());
//        cp.insertPanier(p1);
//        assertEquals(false, cp.filterPrixtotalePanier(1.5).isEmpty());
//        assertEquals(false, cp.filterPrixtotalePanier(1.5).isEmpty());
//    }
//
//    @Test(expected = ArrayStoreException.class)
//    public void testfilterPanierTypeVide(){
//        cp.filterPanierType("Macedoine");
//    }
//    @Test
//    public void testfilterPanierType(){
//        Panier p1=new Panier("Test1",5);
//        p1.setType("Macedoine");
//        Panier p2=new Panier("Test2",5);
//        p2.setType("Salade");
//        cp.insertPanier(p1);cp.insertPanier(p2);
//        assertEquals(false, cp.filterPanierType("Salade").isEmpty());
//        assertEquals(true, cp.filterPanierType(" ").isEmpty());
//    }
//
//
//
//

}
