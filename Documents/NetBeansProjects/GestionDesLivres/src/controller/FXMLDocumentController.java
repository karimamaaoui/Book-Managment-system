/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOLivre;
import DAO.LaConnexion;
import classes.Livres;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import view.Main;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField txtid;
    @FXML
    private TextField txttit;
    @FXML
    private TextField txtauth;
    @FXML
    private TextField txtye;
    @FXML
    private TextField txtpag;
    @FXML
    private TableView<Livres> tablelivres;
    @FXML
    private TableColumn<Livres, String> coltitl;
    @FXML
    private TableColumn<Livres, String> colauth;
    @FXML
    private TableColumn<Livres, String> colyea;
    @FXML
    private TableColumn<Livres, Integer> colpages;
    @FXML
    private TableColumn<Livres, Integer> colid;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnedit;
    @FXML
    private Button btndel;

    LaConnexion cn;
    int index=-1;
     ObservableList<Livres> observableList;
    private Object primaryStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.showBooks();
        this.tablelivres.setEditable(true);
    }    

    
      
    
    @FXML
    private void addBook(ActionEvent event) {
        
    if(this.checkInputs()){
        this.showErrorAlert("Remplir tous les champs!! ");}
    else{
        
    
        String text = this.txtid.getText();
        int id = Integer.parseInt(text);

        String text2 = this.txtpag.getText();
        int page = Integer.parseInt(text2);

        
        DAOLivre.ajouter(id, this.txttit.getText(), this.txtauth.getText(), this.txtye.getText(), page);
        this.showAlert("Ajout avec succees");
                this.remiseAZero();

        this.showBooks();
        
    }
    }
    @FXML
    private void edit(MouseEvent event)
    {
        this.getSelected(event);
        
             if(   event.getClickCount()==2)
             {
                 
        String text = this.txtid.getText();
        int id = Integer.parseInt(text);

        String text2 = this.txtpag.getText();
        int page = Integer.parseInt(text2);
        if(!this.checkInputs())
        {
            
        
        DAOLivre.Modifier(id, this.txttit.getText(), this.txtauth.getText(), this.txtye.getText(), page);
    
        this.showAlert("Modification  avec succees");
        this.showBooks();
       }
    }}
      
    @FXML
    private void delBook(ActionEvent event) {

        Livres p = this.tablelivres.getSelectionModel().getSelectedItem();
        System.out.println(p.getId()); 
        
       // DAOLivre.delete(Integer.parseInt(this.txtid.getText()));
       this.showAlert("do you really want to delete it");

         DAOLivre.delete(p.getId());

        this.showBooks();
        
    }
    
  
    
    public ObservableList<Livres> getBookList()
    {
        this.observableList=FXCollections.observableArrayList();
        Connection cn=LaConnexion.seConnecter();
        
                try{
            ResultSet res= cn.createStatement().executeQuery("select * from Livre");
            while(res.next())
            {
                this.observableList.add(new Livres(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5)));
                
            }
        }catch(SQLException throwables)
        {
           throwables.printStackTrace();
        }
         return observableList;
        
        

    }
    
    public void showBooks ()
    {
     ObservableList<Livres> list=this.getBookList();
        this.colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.coltitl.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.colauth.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.colyea.setCellValueFactory(new PropertyValueFactory<>("year"));
        this.colpages.setCellValueFactory(new PropertyValueFactory<>("pages"));
        this.tablelivres.getItems().clear();
        this.tablelivres.setItems(list);

        
    }
    

    @FXML
    void remiseAZero()  {
        
        this.txtid.setText(null);
        this.txttit.setText(null);
        this.txtauth.setText(null);
        this.txtye.setText(null);
        this.txtpag.setText(null);
       
    }
    
    @FXML
    private boolean checkInputs()
    {
        return (this.txtid.getText().equals("") ||this.txttit.getText().equals("") ||this.txtauth.getText().equals("")||this.txtye.getText().equals("")||this.txtpag.getText().equals(""));
    }
    
    
    
    public void showErrorAlert(String mes){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(mes);
            alert.showAndWait();
    }
    
    public void showAlert(String mes){
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information");
        alert2.setContentText(mes);
        alert2.showAndWait();
        }
    
    
    @FXML
    void getSelected (MouseEvent event)
    {
        this.index=this.tablelivres.getSelectionModel().getSelectedIndex();
        if(index <=-1)
        {
            return ;
        }
    
        this.txtid.setText(this.colid.getCellData(index).toString());
        this.txttit.setText(this.coltitl.getCellData(index).toString());
        this.txtauth.setText(this.colauth.getCellData(index).toString());
        this.txtye.setText(this.colyea.getCellData(index).toString());
        this.txtpag.setText(this.colpages.getCellData(index).toString());
        
        
    }
}
