package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitDao extends Dao<Produit> {
    List<Produit> findByMc(String nom) throws SQLException;
}
