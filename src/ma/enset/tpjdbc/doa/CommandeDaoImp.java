package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Commande;
import ma.enset.tpjdbc.doa.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDaoImp implements CommandeDao{
    @Override
    public List<Commande> findByClient(Client cl) throws SQLException{
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Commande where ID_CLIENT = ?");
        stm.setInt(1,cl.getId());
        ResultSet rs = stm.executeQuery();
        List<Commande> commandes = new ArrayList<>();
        while (rs.next()){
            Commande c = new Commande();
            c.setId(rs.getInt("ID"));
            c.setQuantite(rs.getInt("QUANTITE"));
            ClientDaoImp client = new ClientDaoImp();
            ProduitDaoImp produit = new ProduitDaoImp();
            c.setClient(client.findById(rs.getInt("ID_CLIENT")));
            c.setProduit(produit.findById(rs.getInt("ID_PRODUIT")));
            commandes.add(c);
        }
        return commandes;
    }

    @Override
    public List<Commande> findByProduit(Produit p) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Commande where ID_PRODUIT = ?");
        stm.setInt(1,p.getId());
        ResultSet rs = stm.executeQuery();
        List<Commande> commandes = new ArrayList<>();
        while (rs.next()){
            Commande c = new Commande();
            c.setId(rs.getInt("ID"));
            c.setQuantite(rs.getInt("QUANTITE"));
            ClientDaoImp client = new ClientDaoImp();
            ProduitDaoImp produit = new ProduitDaoImp();
            c.setClient(client.findById(rs.getInt("ID_CLIENT")));
            c.setProduit(produit.findById(rs.getInt("ID_PRODUIT")));
            commandes.add(c);
        }
        return commandes;
    }

    @Override
    public List<Commande> findAll() throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Commande");
        ResultSet rs = stm.executeQuery();
        List<Commande> commandes = new ArrayList<>();
        while (rs.next()){
            Commande c = new Commande();
            c.setId(rs.getInt("ID"));
            c.setQuantite(rs.getInt("QUANTITE"));
            ClientDaoImp client = new ClientDaoImp();
            ProduitDaoImp produit = new ProduitDaoImp();
            c.setClient(client.findById(rs.getInt("ID_CLIENT")));
            c.setProduit(produit.findById(rs.getInt("ID_PRODUIT")));
            commandes.add(c);
        }
        return commandes;
    }

    @Override
    public Commande findById(int id) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Commande where ID=?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Commande c = new Commande();
        if (rs.next()){
            c.setId(rs.getInt("ID"));
            c.setQuantite(rs.getInt("QUANTITE"));
            ClientDaoImp client = new ClientDaoImp();
            ProduitDaoImp produit = new ProduitDaoImp();
            c.setClient(client.findById(rs.getInt("ID_CLIENT")));
            c.setProduit(produit.findById(rs.getInt("ID_PRODUIT")));
        }
        return c;
    }

    @Override
    public Commande save(Commande o) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into Commande(ID,QUANTITE,ID_CLIENT,ID_PRODUIT) " +
                "values (?,?,?,?)");
        stm.setInt(1,o.getId());
        stm.setInt(2,o.getQuantite());
        stm.setInt(3,o.getClient().getId());
        stm.setInt(4,o.getProduit().getId());
        stm.executeUpdate();
        return o;
    }

    @Override
    public boolean detete(Commande o) throws SQLException {
        try{
            Connection connection = singletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from Commande where ID = ?)");
            stm.setInt(1,o.getId());
            stm.executeUpdate();
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Commande update(Commande o) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update Commande set QUANTITE=?,ID_CLIENT=?,ID_PRODUIT=? where ID = ?");
        stm.setInt(1,o.getQuantite());
        stm.setInt(2,o.getClient().getId());
        stm.setInt(3,o.getProduit().getId());
        stm.setInt(4,o.getId());
        stm.executeUpdate();
        return o;
    }
}
