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
import ma.enset.tpjdbc.doa.ProduitDaoImp;
import ma.enset.tpjdbc.doa.entities.Client;
import ma.enset.tpjdbc.doa.entities.Produit;
import ma.enset.tpjdbc.services.ProduitService;
import ma.enset.tpjdbc.services.ProduitServiceImp;

import javax.swing.plaf.synth.ColorType;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProduitController implements Initializable{
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;
    @FXML
    private TextField search;
    @FXML
    private TableView<Produit> tableP;
    @FXML
    private TableColumn<Produit,String> colNom;
    @FXML
    private TableColumn<Produit,String> colDes;
    @FXML
    private TableColumn<Produit,Float> colPrix;
    @FXML
    private TableColumn<Produit,Integer> colQua;
    ObservableList<Produit> produits = FXCollections.observableArrayList();
    private ProduitService service = new ProduitServiceImp(new ProduitDaoImp());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colQua.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableP.setItems(produits);
        loadProduits();
    }
    public void addProduit(){

        if(nom.getText().length()==0 || description.getText().length()==0 || prix.getText().length()==0 || quantite.getText().length() ==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuillez remplir tous les champs !!!!");
            alert.show();
        }else {
            String pNom = nom.getText();
            String pDescription = description.getText();
            float pPrix = Float.parseFloat(prix.getText());
            int pQuantite =Integer.parseInt(quantite.getText());
            Produit produit = new Produit();
            produit.setNom(pNom);
            produit.setDescription(pDescription);
            produit.setPrix(pPrix);
            produit.setStock(pQuantite);
            service.addProduit(produit);
            loadProduits();
            clearText();
        }
    }
    public void deleteProduit(){
        Produit p = tableP.getSelectionModel().getSelectedItem();
        service.deleteProduit(p);
        loadProduits();
    }
    public void searchProduit(){
        String mc = search.getText();
        List<Produit> produitList=service.getProduitMc(mc);
        produits.clear();
        produits.addAll(produitList);
    }
    public void loadProduits(){
        produits.clear();
        produits.addAll(service.getAllProduit());
    }
    public void clearText(){
        nom.setText("");
        description.setText("");
        prix.setText("");
        quantite.setText("");
    }
}
