package ma.enset.tpjdbc.doa.entities;

import java.io.Serializable;

public class Commande implements Serializable {
    private int id;
    private int quantite;
    private float prix;
    private Client client;
    private Produit produit;
    private float total;
    public Commande(){}

    public Commande(int quantite, Client client, Produit produit) {
        this.quantite = quantite;
        this.client = client;
        this.produit = produit;
        this.prix= produit.getPrix();
        this.total=this.prix*this.quantite;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
        this.prix=produit.getPrix();
        this.total=this.prix*quantite;

    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
