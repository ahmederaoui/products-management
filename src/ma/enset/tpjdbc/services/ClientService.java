package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.doa.entities.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client c);
    void deleteClient(Client c);
    List<Client> getAllClient();
    List<Client> getClientMc(String nom);
    Client getClientId(int id);
}
