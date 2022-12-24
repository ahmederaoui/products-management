package ma.enset.tpjdbc.doa.entities;

import java.io.Serializable;

public class Commande implements Serializable {
    private int id;
    private int quantite;



    private Client client;
    private Produit produit;
    public Commande(){}

    public Commande(int quantite, Client client, Produit produit) {
        this.quantite = quantite;
        this.client = client;
        this.produit = produit;
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
    }
}
