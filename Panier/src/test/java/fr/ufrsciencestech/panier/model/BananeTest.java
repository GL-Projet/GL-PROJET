/**
 *
 * @author mehdi
 */

package fr.ufrsciencestech.panier.model;

import static org.junit.Assert.*;
import org.junit.Test;
import fr.ufrsciencestech.panier.model.Banane;

public class BananeTest {

    @Test
    public void testPrixPositif() {
        Banane banane = new Banane();
        banane.setPrix(-1.0); // Prix négatif
        assertEquals(1.0, banane.getPrix(), 0.001); // Le prix doit être positif
    }

    @Test
    public void testOrigineVide() {
        Banane banane = new Banane();
        banane.setOrigine(""); // Origine vide
        assertEquals("France", banane.getOrigine()); // L'origine doit être "France"
    }

    @Test
    public void testToString() {
        Banane banane = new Banane(1, 0.5, "Espagne");
        String expectedString = "1- Banane de Espagne à 0.5 €/kg";
        assertEquals(expectedString, banane.toString());
    }

    @Test
    public void testEquals() {
        Banane banane1 = new Banane(1, 0.5, "Espagne");
        Banane banane2 = new Banane(1, 0.5, "Espagne");

        assertTrue(banane1.equals(banane2));
    }

    @Test
    public void testNotEquals() {
        Banane banane1 = new Banane(1, 0.5, "Espagne");
        Banane banane2 = new Banane(2, 0.5, "Espagne");

        assertFalse(banane1.equals(banane2));
    }

    @Test
    public void testIsSeedless() {
        Banane banane = new Banane();
        assertFalse(banane.isSeedless()); // Une banane n'est pas sans pépins
    }
}
