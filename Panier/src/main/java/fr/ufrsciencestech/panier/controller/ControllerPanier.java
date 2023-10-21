package fr.ufrsciencestech.panier.controller;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.ListePanier;
import fr.ufrsciencestech.panier.model.Panier;
import org.jetbrains.annotations.NotNull;

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

    public ArrayList<Panier> getListePanier() {
        return listePanier.getListePanier();
    }

    public void setListePanier(ListePanier listePanier) {
        this.listePanier = listePanier;
    }

    public void insertPanier(@NotNull Panier p){
        if (listePanier.getListePanier().isEmpty())
            listePanier.getListePanier().add(p);
        else {
            if (listePanierNom(p.getName()).isEmpty())
                listePanier.getListePanier().add(p);
            else
                throw new IllegalArgumentException("Le panier existe deja dans la liste");
        }
    }

    public void removePanier(String nomPanier){
        if (listePanier.getListePanier().isEmpty()){
            throw new ArrayStoreException("La liste des paniers est vide");
        }else
            if (listePanierNom(nomPanier).isEmpty())
                throw new IllegalArgumentException("Le panier nexiste pas");
            else
                listePanier.getListePanier().removeIf(panier -> panier.getName().equals(nomPanier));
    }

    public ArrayList<Panier> listePanierFruitOrigine(String origine){
        ArrayList<Panier> listeTemp=new ArrayList<Panier>();
        if (listePanier.getListePanier().isEmpty()){
            throw new ArrayStoreException("La liste des paniers est vide");
        }else {
            Stream<Panier> temp = listePanier.getListePanier()
                    .stream()
                    .filter(panier -> !filterOrigineFruitPanier(panier, origine).isEmpty());
            listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        }
        return listeTemp;
    }
    public ArrayList<Panier> listePanierNom(String nom){
        ArrayList<Panier> listeTemp=new ArrayList<Panier>();
        if (listePanier.getListePanier().isEmpty()){
            throw new ArrayStoreException("La liste des paniers est vide");
        }else {
            Stream<Panier> temp = listePanier.getListePanier()
                    .stream()
                    .filter(panier -> panier.getName().equals(nom));
            listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        }
        return listeTemp;
    }
    public ArrayList<Panier> listePanierFruit(String nom){
        ArrayList<Panier> listeTemp=new ArrayList<Panier>();
        if (listePanier.getListePanier().isEmpty()){
            throw new ArrayStoreException("La liste des paniers est vide");
        }else{
            Stream<Panier> temp = listePanier.getListePanier()
                    .stream()
                    .filter(panier -> !filterNomFruitPanier(panier, nom).isEmpty());
            listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        }
        return listeTemp;
    }
    public ArrayList<Fruit> filterOrigineFruitPanier(@NotNull Panier panier, String origine){
        ArrayList<Fruit> arrayList=new ArrayList<Fruit>();
        if (panier.getFruits().isEmpty()){
            throw new ArrayStoreException("Le panier est vide");
        }else {
            Stream<Fruit> stream = panier.getFruits()
                    .stream()
                    .filter(fruit -> fruit.getOrigine().equals(origine));
            arrayList = new ArrayList<Fruit>(stream.collect(Collectors.toList()));
        }
        return arrayList;
    }

    public ArrayList<Fruit> filterNomFruitPanier(@NotNull Panier panier, String nom){
        ArrayList<Fruit> arrayList=new ArrayList<Fruit>();
        if (panier.getFruits().isEmpty()){
            throw new ArrayStoreException("Le panier est vide");
        }else {
            Stream<Fruit> stream = (panier.getFruits())
                    .stream()
                    .filter(fruit -> fruit.getNom().equals(nom));
            arrayList = new ArrayList<Fruit>(stream.collect(Collectors.toList()));
        }
        return arrayList;
    }

    public ArrayList<Panier> filterPrixtotalePanier(double prix){
        ArrayList<Panier> listeTemp=new ArrayList<Panier>();
        if (listePanier.getListePanier().isEmpty()){
            throw new ArrayStoreException("La liste des paniers est vide");
        }else {
            Stream<Panier> temp = listePanier.getListePanier()
                    .stream()
                    .filter(panier -> panier.getPrixtotale() <= prix);
            listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        }
        return listeTemp;
    }

    public ArrayList<Panier> filterPanierType(String type){
        ArrayList<Panier> listeTemp=new ArrayList<Panier>();
        if (listePanier.getListePanier().isEmpty()){
            throw new ArrayStoreException("La liste des paniers est vide");
        }else {
            Stream<Panier> temp = listePanier.getListePanier()
                    .stream()
                    .filter(panier -> panier.getType().equals(type));
            listeTemp = new ArrayList<Panier>(temp.collect(Collectors.toList()));
        }
        return listeTemp;
    }

}
