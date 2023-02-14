package ma.enset.tpjdbc.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.doa.ClientDaoImp;
import ma.enset.tpjdbc.doa.CommandeDaoImp;
import ma.enset.tpjdbc.doa.ProduitDaoImp;
import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Commande;
import ma.enset.tpjdbc.doa.entities.Produit;
import ma.enset.tpjdbc.services.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {
    @FXML
    private ComboBox<Client> comClient;
    @FXML
    private ComboBox<Produit> comProduit;
    @FXML
    private TextField quantite;
    @FXML
    private TextField search;
    @FXML
    private TableView<Commande> tableCm;
    @FXML
    private TableColumn<Commande,String> colC;
    @FXML
    private TableColumn<Commande,String> colP;
    @FXML
    private TableColumn<Commande,Integer> colQua;
    @FXML
    private TableColumn<Commande,Float> colTotal;
    @FXML
    private TableColumn<Commande,Float> colPrix;
    ObservableList<Commande> commandes = FXCollections.observableArrayList();
    private CommandeService service = new CommandeServiceImp(new CommandeDaoImp());
    private ClientService cService = new ClientServiceImp(new ClientDaoImp());
    private ProduitService pService = new ProduitServiceImp(new ProduitDaoImp());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colC.setCellValueFactory(new PropertyValueFactory<>("client"));
        colP.setCellValueFactory(new PropertyValueFactory<>("produit"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQua.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        tableCm.setItems(commandes);
        comClient.getItems().addAll(cService.getAllClient());
        comProduit.getItems().addAll(pService.getAllProduit());
        loadCommande();
    }
    public void addCommande(){
        Client client = comClient.getSelectionModel().getSelectedItem();
        Produit produit = comProduit.getSelectionModel().getSelectedItem();
        int quan = Integer.parseInt(quantite.getText());
        if(client==null || produit==null ||quantite.getText().length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez remplir tous les champs !!!!");
            alert.show();
        }else {
            Commande commande= new Commande();
            commande.setClient(client);
            commande.setQuantite(quan);
            commande.setProduit(produit);
            service.addCommande(commande);
            loadCommande();
        }
    }

    public void loadCommande(){
        commandes.clear();
        commandes.addAll(service.getAllCommande());
    }
}
