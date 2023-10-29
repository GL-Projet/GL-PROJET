
/**
 *
 * @author mehdi
 */
package fr.ufrsciencestech.panier.model;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class ConnexionBDDTest {

    private ConnexionBDD connexion;

    @Before
    public void setUp() {
        connexion = new ConnexionBDD();
        ajouterDonneesDeTest();
    }

    @After
    public void tearDown() {
        connexion.closeConnection();
    }

    private void ajouterDonneesDeTest() {
        connexion.insertFruit("Pomme", 1.0, "France");
        connexion.insertFruit("Mangue", 1.5, "Inde");
        connexion.insertPanier("Panier1", "Fruit", 3, 0);
        connexion.insertPanier("Panier2", "Légume", 5, 0);
        connexion.insertFruitToPanier("Panier1", 1, 1.0, 1.0);
        connexion.insertFruitToPanier("Panier2", 2, 1.5, 2.0);
    }

    @Test
    public void testVerifFruit() {
        assertTrue(connexion.verifFruit("Pomme", 1.0, "France"));
        assertFalse(connexion.verifFruit("Ananas", 2.0, "Costa Rica"));
    }

    @Test
    public void testInsertFruit() {
        assertTrue(connexion.insertFruit("Banane", 0.8, "Brésil"));
        assertFalse(connexion.insertFruit("Pomme", 1.0, "France")); 
    }

    @Test
    public void testListeFruit() {
        Object[][] fruits = connexion.listeFruit();
        assertNotNull(fruits);
        assertTrue(fruits.length > 0);
    }

    @Test
    public void testVerifPanier() {
        assertTrue(connexion.verifPanier("Panier1"));
        assertFalse(connexion.verifPanier("Panier3"));
    }

    @Test
    public void testInsertPanier() {
        assertTrue(connexion.insertPanier("Panier3", "Fruit", 10, 0));
        assertFalse(connexion.insertPanier("Panier1", "Fruit", 5, 0)); 
    }

    @Test
    public void testListePanier() {
        List<String> paniers = connexion.listePanier();
        assertNotNull(paniers);
        assertTrue(paniers.size() > 0);
    }

    @Test
    public void testTypePanier() {
        assertEquals("Fruit", connexion.typePanier("Panier1"));
        assertEquals("Légume", connexion.typePanier("Panier2"));
        assertEquals("", connexion.typePanier("PanierInexistant"));
    }

    @Test
    public void testGetFruitByName() {
        Object[][] pommes = connexion.getFruitByName("Pomme", "Fruit");
        assertNotNull(pommes);
        assertEquals(1, pommes.length);
        assertEquals("Pomme", pommes[0][1]);
    }

    @Test
    public void testGetPrixFruit() {
        double prixPomme = connexion.getPrixFruit(1);
        assertEquals(1.0, prixPomme, 0.01);
        double prixMangue = connexion.getPrixFruit(2);
        assertEquals(1.5, prixMangue, 0.01);
    }

    @Test
    public void testVerifFruitPanier() {
        assertTrue(connexion.verifFruitPanier("Pomme", 1));
        assertFalse(connexion.verifFruitPanier("Mangue", 1));
    }

    @Test
    public void testInsertFruitToPanier() {
        String result1 = connexion.insertFruitToPanier("Panier1", 2, 2.0, 3.0);
        assertEquals("", result1);
        String result2 = connexion.insertFruitToPanier("Panier1", 2, 1.0, 1.5);
        assertEquals("le fruit existe deja dans le panier", result2);
    }

    @Test
    public void testGetFruitFromPanier() {
        List<String> fruitsPanier1 = connexion.getFruitFromPanier("Panier1");
        assertNotNull(fruitsPanier1);
        assertTrue(fruitsPanier1.size() > 0);
        assertEquals("1- Pomme de France ---------- 1.0 Kg * 1.0€ = 1.0", fruitsPanier1.get(0));
    }

    @Test
    public void testMaxCapacity() {
        assertEquals(3, connexion.getMaxCapacity("Panier1"));
        assertEquals(5, connexion.getMaxCapacity("Panier2"));
        assertEquals(-1, connexion.getMaxCapacity("PanierInexistant"));
    }

    @Test
    public void testCout() {
        double coutPanier1 = connexion.getCout("Panier1");
        assertEquals(1.0, coutPanier1, 0.01);
        double coutPanier2 = connexion.getCout("Panier2");
        assertEquals(2.0, coutPanier2, 0.01);
    }

    @Test
    public void testCalculerCout() {
        double coutPanier1 = connexion.calculerCout("Panier1");
        assertEquals(1.0, coutPanier1, 0.01);
        double coutPanier2 = connexion.calculerCout("Panier2");
        assertEquals(2.0, coutPanier2, 0.01);
    }

    @Test
    public void testDeleteFruitFromPanier() {
        connexion.insertFruitToPanier("Panier1", 1, 0.5, 0.5);
        connexion.deleteFruitFromPanier("Panier1", 1);
        double coutPanier1 = connexion.getCout("Panier1");
        assertEquals(0.5, coutPanier1, 0.01); 
    }
}
