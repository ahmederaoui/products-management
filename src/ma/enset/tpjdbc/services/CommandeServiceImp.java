package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.doa.CommandeDao;
import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Commande;
import ma.enset.tpjdbc.doa.entities.Produit;

import java.util.List;

public class CommandeServiceImp implements CommandeService{
    CommandeDao cDao;

    public CommandeServiceImp(CommandeDao cDao) {
        this.cDao = cDao;
    }

    @Override
    public void addCommande(Commande c) {
        try {
            cDao.save(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCommande(Commande c) {
        try {
            cDao.detete(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Commande> getAllCommande() {
        try {
            return cDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Commande getCommandeId(int id) {
        try {
            return cDao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Commande> getClientCommande(Client cl) {
        try {
            return cDao.findByClient(cl);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Commande> getProduitCommande(Produit pr) {
        try {
            return cDao.findByProduit(pr);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
