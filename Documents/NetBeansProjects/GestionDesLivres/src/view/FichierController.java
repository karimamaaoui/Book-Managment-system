/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOLivre;
import DAO.LaConnexion;
import classes.Livres;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class FichierController implements Initializable {
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
    private TableView<?> tablelivres;

    @FXML
    private TableColumn<?, ?> coltitl;

    @FXML
    private TableColumn<?, ?> colauth;

    @FXML
    private TableColumn<?, ?> colyea;

    @FXML
    private TableColumn<?, ?> colpages;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private Button btnuP;
     ObservableList<Livres> observableList;

    
     
    @FXML
    void updateBook(ActionEvent event) {
        String text = this.txtid.getText();
        int id = Integer.parseInt(text);

        String text2 = this.txtpag.getText();
        int page = Integer.parseInt(text2);
        //if(!this.checkInputs())
        //{
            
        
        DAOLivre.Modifier(id, this.txttit.getText(), this.txtauth.getText(), this.txtye.getText(), page);
        Livres p = new Livres(id, this.txttit.getText(), this.txtauth.getText(), this.txtye.getText(), page);

            System.out.println(p.toString());
  
    }
  


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
      
}
