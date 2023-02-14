package ma.enset.tpjdbc.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.tpjdbc.doa.ClientDaoImp;
import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.services.ClientService;
import ma.enset.tpjdbc.services.ClientServiceImp;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField tele;
    @FXML
    private TableView<Client> tableC;
    @FXML
    private TableColumn<Client,String> colNom;
    @FXML
    private TableColumn<Client,String> colPrenom;
    @FXML
    private TableColumn<Client,String> colEmail;
    @FXML
    private TableColumn<Client,String> colTele;
    @FXML
    private TextField search;
    ObservableList<Client> clients = FXCollections.observableArrayList();
    private ClientService service = new ClientServiceImp(new ClientDaoImp());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTele.setCellValueFactory(new PropertyValueFactory<>("tele"));
        tableC.setItems(clients);
        loadClients();
    }

    public void addClient(){
        String cNom = nom.getText();
        String cPrenom = prenom.getText();
        String cEmail = email.getText();
        String cTele = tele.getText();
        if(cNom.length()==0 || cPrenom.length()==0 || cEmail.length()==0 || cTele.length() ==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez remplir tous les champs !!!!");
            alert.show();
        }else {
            Client cl = new Client();
            cl.setNom(cNom);
            cl.setPrenom(cPrenom);
            cl.setEmail(cEmail);
            cl.setTele(cTele);
            service.addClient(cl);
            loadClients();
            clearText();
        }

    }

    public void deleteClient(){
        Client c = tableC.getSelectionModel().getSelectedItem();
        service.deleteClient(c);
        loadClients();
    }

    public void chercherClient(){
        clients.clear();
        clients.addAll(service.getClientMc(search.getText()));
    }

    public void loadClients(){
        clients.clear();
        clients.addAll(service.getAllClient());
    }
    public void clearText(){
        nom.setText("");
        prenom.setText("");
        email.setText("");
        tele.setText("");
    }
}
