package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Commande;
import ma.enset.tpjdbc.doa.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface CommandeDao extends Dao<Commande> {
    List<Commande> findByClient(Client c) throws SQLException;
    List<Commande> findByProduit(Produit p) throws SQLException;
}
