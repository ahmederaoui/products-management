package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp implements ClientDao{
    public ClientDaoImp() {
    }

    @Override
    public List<Client> findByMc(String nom) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Client where NOM like ? or PRENOM like ?");
        stm.setString(1,"%"+nom+"%");
        stm.setString(2,"%"+nom+"%");
        ResultSet rs = stm.executeQuery();
        List<Client> clients = new ArrayList<>();
        while (rs.next()){
            Client c = new Client();
            c.setId(rs.getInt("ID"));
            c.setNom(rs.getString("NOM"));
            c.setPrenom(rs.getString("PRENOM"));
            c.setTele(rs.getString("TELE"));
            c.setEmail(rs.getString("EMAIL"));
            clients.add(c);
        }
        return clients;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Client");
        ResultSet rs = stm.executeQuery();
        List<Client> clients = new ArrayList<>();
        while (rs.next()){
            Client c = new Client();
            c.setId(rs.getInt("ID"));
            c.setNom(rs.getString("NOM"));
            c.setPrenom(rs.getString("PRENOM"));
            c.setTele(rs.getString("TELE"));
            c.setEmail(rs.getString("EMAIL"));
            clients.add(c);
        }
        return clients;
    }

    @Override
    public Client findById(int id) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Client where ID = ?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Client c = new Client();
        if (rs.next()){
            c.setId(rs.getInt("ID"));
            c.setNom(rs.getString("NOM"));
            c.setPrenom(rs.getString("PRENOM"));
            c.setTele(rs.getString("TELE"));
            c.setEmail(rs.getString("EMAIL"));
        }
        return c;
    }

    @Override
    public Client save(Client o) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into Client(NOM,PRENOM,TELE,EMAIL) " +
                "values (?,?,?,?)");
        stm.setString(1,o.getNom());
        stm.setString(2,o.getPrenom());
        stm.setString(3,o.getTele());
        stm.setString(4,o.getEmail());
        stm.executeUpdate();
        return o;
    }

    @Override
    public boolean detete(Client o) throws SQLException {
        try{
            Connection connection = singletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from Client where ID=?");
            stm.setInt(1,o.getId());
            stm.executeUpdate();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Client update(Client o) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update Client set NOM=? ,PRENOM =?,TELE=?,EMAIL=? where ID=?");
        stm.setString(1,o.getNom());
        stm.setString(2,o.getPrenom());
        stm.setString(3,o.getTele());
        stm.setString(4,o.getEmail());
        stm.setInt(5,o.getId());
        stm.executeUpdate();
        return o;
    }
}
