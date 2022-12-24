package ma.enset.tpjdbc.doa.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private int id;
    private String nom;
    private String Description;
    private float prix;
    private int stock;

    public Produit(){}

    public void setId(int id) {
        this.id = id;
    }

    public Produit(String nom, String description, float prix, int stock) {
        this.nom = nom;
        Description = description;
        this.prix = prix;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return Description;
    }

    public float getPrix() {
        return prix;
    }

    public int getStock() {
        return stock;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
