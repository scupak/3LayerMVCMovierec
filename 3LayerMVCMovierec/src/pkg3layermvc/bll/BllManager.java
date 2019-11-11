/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3layermvc.bll;

import java.io.IOException;
import pkg3layermvc.be.Movie;
import pkg3layermvc.dal.MovieMockManager;
import java.util.List;
import pkg3layermvc.dal.MovieDAL;

/**
 *
 * @author anton
 */
public class BllManager {
    MovieMockManager manager = new MovieMockManager();
    MovieDAL dalmanager = new MovieDAL();
    
    public List<Movie>getAllMovies() throws IOException{
    
     return dalmanager.getAllMovies();
    
    
    }
    public void deleteMovie(Movie movie){
    
    dalmanager.deleteMovie(movie);
    
    
    
    }
    
}
