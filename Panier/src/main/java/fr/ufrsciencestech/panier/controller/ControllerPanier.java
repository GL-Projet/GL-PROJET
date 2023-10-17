package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.model.IFruit;
import fr.ufrsciencestech.panier.model.ListePanier;
import fr.ufrsciencestech.panier.model.Panier;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerPanier {

    private ListePanier listePanier;

    public ControllerPanier() {
        this.listePanier=new ListePanier();
    }

    public ControllerPanier(ListePanier listePanier) {
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

    public ArrayList<IFruit> filterOrigineFruitPanier(Panier panier, String origine){
        Stream<IFruit> stream=panier.getFruits()
                .stream()
                .filter(fruit -> fruit.getOrigine().equals(origine));
        ArrayList<IFruit> arrayList = new ArrayList<IFruit>(stream.collect(Collectors.toList()));
        return arrayList;
    }

    public ArrayList<IFruit> filterNomFruitPanier(Panier panier,String nom){
        Stream<IFruit>stream=(panier.getFruits())
                .stream()
                .filter(fruit -> fruit.getNom().equals(nom));
        ArrayList<IFruit> arrayList = new ArrayList<IFruit>(stream.collect(Collectors.toList()));
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

    public void CreatePanier(String nom,int capmax){
        listePanier.getListePanier().add(new Panier(nom,capmax));
    }

    public void RemovePanier(String nom){
        listePanier.getListePanier().removeIf(panier -> panier.getName().equals(nom));
    }

//    public void ModifPanier(){}

}
