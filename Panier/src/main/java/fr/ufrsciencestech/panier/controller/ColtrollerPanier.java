package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.ListePanier;
import fr.ufrsciencestech.panier.model.Panier;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColtrollerPanier {

    private ListePanier listePanier;

    public ColtrollerPanier() {
        this.listePanier=new ListePanier();
    }

    public ColtrollerPanier(ListePanier listePanier) {
        this.listePanier = listePanier;
    }

    public ListePanier getListePanier() {
        return listePanier;
    }

    public void setListePanier(ListePanier listePanier) {
        this.listePanier = listePanier;
    }

    public ArrayList<Panier> listePanirFruitOrigine(String origine){
        Stream<Panier> temp=listePanier.getListePanier()
                .stream()
                .filter(panier -> !filterOrigineFruitPanier(panier,origine).isEmpty());
        ArrayList<Panier> listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        return listeTemp;
    }
    public ArrayList<Panier> listePanirNom(String nom){
        Stream<Panier> temp=listePanier.getListePanier()
                .stream()
                .filter(panier -> panier.getName().equals(nom));
        ArrayList<Panier> listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        return listeTemp;
    }
    public ArrayList<Panier> listePanirFruit(String nom){
        Stream<Panier> temp=listePanier.getListePanier()
                .stream()
                .filter(panier -> !filterNomFruitPanier(panier,nom).isEmpty());
        ArrayList<Panier> listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        return listeTemp;
    }

    public ArrayList<Fruit> filterOrigineFruitPanier(Panier panier, String origine){
        Stream<Fruit> stream=panier.getFruits()
                .stream()
                .filter(fruit -> fruit.getOrigine().equals(origine));
        ArrayList<Fruit> arrayList = new ArrayList<Fruit>(stream.collect(Collectors.toList()));
        return arrayList;
    }

    public ArrayList<Fruit> filterNomFruitPanier(Panier panier,String nom){
        Stream<Fruit>stream=(panier.getFruits())
                .stream()
                .filter(fruit -> fruit.getNom().equals(nom));
        ArrayList<Fruit> arrayList = new ArrayList<Fruit>(stream.collect(Collectors.toList()));
        return arrayList;
    }

    public ArrayList<Panier> filterPrixtotalePanier(double prix){
        Stream<Panier> temp=listePanier.getListePanier()
                .stream()
                .filter(panier -> panier.getPrixtotale()<=prix);
        ArrayList<Panier> listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        return listeTemp;
    }

    public ArrayList<Panier> filterPanierType(String type){
        Stream<Panier> temp=listePanier.getListePanier()
                .stream()
                .filter(panier -> panier.getType().equals(type));
        ArrayList<Panier> listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        return listeTemp;
    }

}
