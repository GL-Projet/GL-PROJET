package fr.ufrsciencestech.panier.model;


import java.util.ArrayList;

public class ListePanier {
    private ArrayList<Panier> listePanier;

    public ListePanier() {
        this.listePanier=new ArrayList<>();
    }

    public ListePanier(ArrayList<Panier> listePanier) {
        this.listePanier = listePanier;
    }

    public ArrayList<Panier> getListePanier() {
        return listePanier;
    }

    public void setListePanier(ArrayList<Panier> listePanier) {
        this.listePanier = listePanier;
    }
}
