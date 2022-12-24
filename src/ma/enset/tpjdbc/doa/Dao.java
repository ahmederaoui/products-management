package ma.enset.tpjdbc.doa;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> findAll() throws SQLException;
    T findById(int id) throws SQLException;
    T save(T o) throws SQLException;
    boolean detete(T o) throws SQLException;
    T update(T o) throws SQLException;
}
