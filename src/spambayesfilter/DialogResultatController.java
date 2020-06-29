/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spambayesfilter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author farah
 */
public class DialogResultatController implements Initializable {
private String resultat;
@FXML
private Label  label;
@FXML
private Button button;
@FXML
private ImageView imageView;
    /**
     * Initializes the controller class.
     */

    public void handlebutton(MouseEvent event) throws IOException {
  
               ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 Platform.runLater(() -> {
     
     if(resultat.equals("spam")){
              label.setText("Attention cet email est un SPAM !!!");
   /* File f = new File("spambayesfilter/test.jpg");
    Image img = new Image(f.toURI().toString());
     imageView = new ImageView(img);
*/
       label.setTextFill(Color.web("#ce1313"));

     }
     else if (resultat.equals("ham")){
       label.setText("Cet email n'est pas un SPAM ");
       label.setTextFill(Color.web("white"));

     }
     else{
     label.setText("Le classifieur de Bayes n'a pu décider");

     }
     
     
     
     
      
          button.setOnMouseClicked(( e ) ->
            {
         try {
             handlebutton(e);
         } catch (IOException ex) {
             Logger.getLogger(DialogResultatController.class.getName()).log(Level.SEVERE, null, ex);
         }
            });
     
     
     
     
 });
          
    }    

    void initData(String décision) {
        this.resultat=décision;
        System.out.println("in result controller "+resultat);
    }
    
}
