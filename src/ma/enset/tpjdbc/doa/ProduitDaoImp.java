package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImp implements ProduitDao{
    public ProduitDaoImp() {
    }

    @Override
    public List<Produit> findAll() throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Produit");
        ResultSet rs = stm.executeQuery();
        List<Produit> produits = new ArrayList<>();
        while (rs.next()){
            Produit produit = new Produit();
            produit.setId(rs.getInt("ID"));
            produit.setNom(rs.getString("NOM"));
            produit.setDescription(rs.getString("DESCRIPTION"));
            produit.setPrix(rs.getFloat("PRIX"));
            produit.setStock(rs.getInt("STOCK"));
            produits.add(produit);
        }
        return produits;
    }

    @Override
    public Produit findById(int id) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select  * from Produit where ID = ?");
        stm.setInt(1,id);
        ResultSet rs = stm.executeQuery();
        Produit produit = new Produit();
        if (rs.next()){
            produit.setId(rs.getInt("ID"));
            produit.setNom(rs.getString("NOM"));
            produit.setDescription(rs.getString("DESCRIPTION"));
            produit.setPrix(rs.getFloat("PRIX"));
            produit.setStock(rs.getInt("STOCK"));
        }
        return produit;
    }

    @Override
    public Produit save(Produit o) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("insert into Produit(NOM,DESCRIPTION,PRIX,STOCK) " +
                "values (?,?,?,?)");
        stm.setString(1,o.getNom());
        stm.setString(2,o.getDescription());
        stm.setFloat(3,o.getPrix());
        stm.setInt(4,o.getStock());
        stm.executeUpdate();
        return o;
    }

    @Override
    public boolean detete(Produit o){
        try{
            Connection connection = singletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from Produit where ID = ?");
            stm.setInt(1,o.getId());
            stm.executeUpdate();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Produit update(Produit o) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("update Produit set NOM=? ,DESCRIPTION =?," +
                "PRIX=?,STOCK=? where ID=?");
        stm.setString(1,o.getNom());
        stm.setString(2,o.getDescription());
        stm.setFloat(3,o.getPrix());
        stm.setInt(4,o.getStock());
        stm.setInt(5,o.getId());
        stm.executeUpdate();
        return o;
    }

    @Override
    public List<Produit> findByMc(String nom) throws SQLException {
        Connection connection = singletonConnexionDB.getConnection();
        PreparedStatement stm = connection.prepareStatement("select * from Produit where NOM like ?");
        stm.setString(1,"%"+nom+"%");
        ResultSet rs= stm.executeQuery();
        List<Produit> produits = new ArrayList<>();
        while (rs.next()){
            Produit produit = new Produit();
            produit.setId(rs.getInt("ID"));
            produit.setNom(rs.getString("NOM"));
            produit.setDescription(rs.getString("DESCRIPTION"));
            produit.setPrix(rs.getFloat("PRIX"));
            produit.setStock(rs.getInt("STOCK"));
            produits.add(produit);
        }
        return produits;
    }
}
