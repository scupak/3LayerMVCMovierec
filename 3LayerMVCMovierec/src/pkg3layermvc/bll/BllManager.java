/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3layermvc.bll;

import pkg3layermvc.be.Movie;
import pkg3layermvc.dal.MovieMockManager;
import java.util.List;

/**
 *
 * @author anton
 */
public class BllManager {
    MovieMockManager manager = new MovieMockManager();
    
    public List<Movie>getAllMovies(){
    
     return manager.getAllMovies();
    
    
    }
    
}
