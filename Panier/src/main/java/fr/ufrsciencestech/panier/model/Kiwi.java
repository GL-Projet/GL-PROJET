package fr.ufrsciencestech.panier.model;

public class Kiwi implements Fruit{
    private double prix;
    private String origine;

    public Kiwi()
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }

    public Kiwi(double prix, String origine)
    {
        if(prix < 0)
            this.prix = -prix;  //une solution possible pour interdire les prix negatifs
        else
            this.prix = prix;

        if(origine.isEmpty())
            this.origine = "Espagne";  //Espagne par défaut
        else
            this.origine = origine;
    }

    public double getPrix(){
        return prix;
    }

    public void setPrix(double prix){
        this.prix=prix;
    }

    public String getOrigine(){
        return origine;
    }

    @Override
    public String getNom() {
        return getClass().getName();
    }

    public void setOrigine(String origine){
        this.origine=origine;
    }

    @Override
    public String toString(){
        return "Banane de " + origine + " a " + prix + " euros";
    }

    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 Bananes sont equivalentes
        if(o != null && getClass() == o.getClass()){
            Kiwi kiwi = (Kiwi) o;
            return (prix == kiwi.prix && origine.equals(kiwi.origine));
        }
        return false;
    }

    public boolean isSeedless() {  //predicat indiquant qu'une Banane a des pepins
        return false;
    }

}
