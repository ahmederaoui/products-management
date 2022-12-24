package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Commande;
import ma.enset.tpjdbc.doa.entities.Produit;

import java.util.List;

public interface CommandeService {
    void addCommande(Commande c);
    void deleteCommande(Commande c);
    List<Commande> getAllCommande();
    Commande getCommandeId(int id);
    List<Commande> getClientCommande(Client cl);
    List<Commande> getProduitCommande(Produit pr);
}
