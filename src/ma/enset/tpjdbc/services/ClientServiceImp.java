package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.doa.ClientDao;
import ma.enset.tpjdbc.doa.entities.Client;

import java.util.List;

public class ClientServiceImp implements ClientService{
    ClientDao cDao;

    public ClientServiceImp(ClientDao cDao) {
        this.cDao = cDao;
    }

    @Override
    public void addClient(Client c) {
        try{
            cDao.save(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(Client c) {
        try{
            cDao.detete(c);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAllClient() {
        try{
            return cDao.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Client> getClientMc(String nom) {
        try{
            return cDao.findByMc(nom);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Client getClientId(int id) {
        try{
            return cDao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
