package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.doa.entities.Produit;

import java.util.List;

public interface ProduitService {
    void addProduit(Produit p);
    void deleteProduit(Produit p);
    List<Produit> getAllProduit();
    List<Produit> getProduitMc(String nom);
    Produit getProduitId(int id);
}
