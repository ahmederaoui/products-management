package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao extends Dao<Client> {
    List<Client> findByMc(String nom) throws SQLException;
}
