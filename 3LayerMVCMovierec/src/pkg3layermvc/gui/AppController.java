package pkg3layermvc.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import pkg3layermvc.be.Movie;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author anton
 */
public class AppController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private ListView<Movie> inmateList;

    private AppModel model = new AppModel();
    @FXML
    private Button RemoveSelected;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inmateList.setItems(model.getInmates());
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        try {
            model.fetchData();
        } catch (IOException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RemoveSelected(ActionEvent event) {
        
        inmateList.getItems().remove(inmateList.getSelectionModel().getSelectedIndex());
        
        inmateList.getSelectionModel().getSelectedItem().getId();
        
    }
    
}
