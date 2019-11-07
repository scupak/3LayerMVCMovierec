/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3layermvc.gui;

import pkg3layermvc.be.Movie;
import pkg3layermvc.bll.BllManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author anton
 */
public class AppModel {
    
   private BllManager bll =  new BllManager();
    private ObservableList<Movie> inmates = FXCollections.observableArrayList();
    
    public void fetchData(){
    
    inmates.clear();
    inmates.addAll(bll.getAllMovies());
    
    
    }

    public ObservableList<Movie> getInmates() {
        return inmates;
    }
    
   
    
    
}
