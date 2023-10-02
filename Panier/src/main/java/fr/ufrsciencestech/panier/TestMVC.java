package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.view.*;
import fr.ufrsciencestech.panier.controller.*;

/**
 * Hello world!
 *
 */

public class TestMVC
{
    public static void main( String[] args )
    {
        //VueGSwing vue = new VueGSwing();
        VueGSwing vueG = new VueGSwing();
        VueConsole vueP = new VueConsole();
        Controller ctrl = new Controller(vueG, vueP);
        
        vueG.setVisible(true);
        vueP.setVisible(true);
    }
}
