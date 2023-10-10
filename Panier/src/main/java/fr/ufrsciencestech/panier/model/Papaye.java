package fr.ufrsciencestech.panier.model;

class Papaye implements Fruit {
    private double prix;
    private String origine;

    public Papaye(double prix, String origine) {
        this.prix = prix;
        this.origine = origine;
    }

    @Override
    public boolean isSeedless() {
        return true; // Papaye sans pépins
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public String getOrigine() {
        return origine;
    }

    @Override
    public String getNom() {
        return "Papaye";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Papaye papaye = (Papaye) o;

        if (Double.compare(papaye.prix, prix) != 0)
            return false;
        return origine != null ? origine.equals(papaye.origine) : papaye.origine == null;
    }

    @Override
    public String toString() {
        return "Papaye de " + origine + " a " + prix + " euros";
    }
}
