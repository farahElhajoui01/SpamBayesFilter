/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spambayesfilter;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import service.MailTextFacade;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class MainViewController implements Initializable {
        @FXML
       private JFXTextArea mailinput;
        @FXML
       private Button  verifierbtn;
        @FXML
       private StackPane stackPane;
        
       private MailTextFacade mailTextService=new  MailTextFacade();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        verifierbtn.setOnAction((event) -> {
            

          String décision="";
            if(mailinput.getText()!=null && !mailinput.getText().equals("")){
         décision=mailTextService.ClassifieurBayes(mailinput.getText());

         
                      
         
                Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("spambayesfilter/DialogResultat.fxml"));
            root = loader.load();
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Resultat");
            
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);

            stage.show();
            DialogResultatController controller = loader.getController();
            controller.initData(décision);
        

        } catch (IOException e) {
            e.printStackTrace();
        }
         
            
            }else
          JOptionPane.showMessageDialog(null, "L'email est vide !", "Error", JOptionPane.ERROR_MESSAGE);

    });    
    
}
}