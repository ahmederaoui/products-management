package ma.enset.tpjdbc.doa;

import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Commande;

import java.util.List;

public class application {
    public static void main(String[] args) {
        try {
            CommandeDao commande = new CommandeDaoImp();
            List<Commande> commandes = commande.findAll();
            for (Commande c:
                 commandes) {
                System.out.println(c.getQuantite()+" "+c.getId());
                System.out.println(c.getClient().getNom());
                System.out.println(c.getProduit().getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
