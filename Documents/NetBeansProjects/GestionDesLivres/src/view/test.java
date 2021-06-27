package view;

import DAO.DAOLivre;
import DAO.LaConnexion;


public class test {

    public static void main(String[] args) {
        LaConnexion c=new LaConnexion();
        DAOLivre.Modifier(4, "ahemd","ahemd", "ahemd", 66);

        /*
    @FXML
    private void editBook(ActionEvent event) {
       
       this.showAlert("connexion  avec succees");
       Livres p = this.tablelivres.getSelectionModel().getSelectedItem(); 
       //this.Consulter();
       this.txttit.setText(p.getTitle());
       this.txtauth.setText(p.getAuthor());
       this.txtye.setText(p.getYear());
       this.txtpag.setText(Integer.toString(p.getPages()));
       this.txtid.setText(Integer.toString(p.getId()));

     //  this.txtid.setDisable(false);
       
       
        String text = this.txtid.getText();
        int id = Integer.parseInt(text);

        String text2 = this.txtpag.getText();
        int page = Integer.parseInt(text2);
       /* if(!this.checkInputs())
        {
            
        
        DAOLivre.Modifier(id, this.txttit.getText(), this.txtauth.getText(), this.txtye.getText(), page);

        this.showAlert("Modification  avec succees");
        this.showBooks();
        this.remiseAZero();
       }
        
        
        public void update(ActionEvent ae) throws IOException{
            String sceneFile = "view/fichier.fxml";
                                System.out.println( "  fxmlResource = " + sceneFile );

			Stage primaryStage= new Stage();
			Parent root =FXMLLoader.load(
                        getClass().getClassLoader().getResource(sceneFile));


//			Parent root = FXMLLoader.load(getClass().getResource(arg0))
			
                        primaryStage=(Stage)((Node)ae.getSource()).getScene().getWindow();
                        
                        Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
                        
                        
                        
                        primaryStage.setScene(scene);
			primaryStage.show();
                        
                        
                        
        
        
                                }

    }*/

        
        
    }

}
