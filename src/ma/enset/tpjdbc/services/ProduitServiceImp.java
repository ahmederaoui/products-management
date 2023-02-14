package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.doa.ProduitDao;
import ma.enset.tpjdbc.doa.entities.Produit;

import java.util.List;

public class ProduitServiceImp implements ProduitService{
    ProduitDao pDao;

    public ProduitServiceImp(ProduitDao pDao) {
        this.pDao = pDao;
    }

    @Override
    public void addProduit(Produit p) {
        try{
            pDao.save(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduit(Produit p) {
        try{
            pDao.detete(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> getAllProduit() {

        try{
            return pDao.findAll();

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<Produit> getProduitMc(String nom) {
        try{
            return  pDao.findByMc(nom);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Produit getProduitId(int id) {
        try{
            return  pDao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
