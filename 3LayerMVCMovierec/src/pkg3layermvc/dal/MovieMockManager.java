/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3layermvc.dal;
import java.util.ArrayList;
import java.util.List;
import pkg3layermvc.be.Movie;

/**
 *
 * @author anton
 */
public class MovieMockManager {
    
    public List<Movie> getAllMovies(){
    
       Movie lotr = new Movie(1, 1980, "lotr");
       Movie mv2 = new Movie(2, 2004, "Dinosaur planet");
    
    ArrayList<Movie> movies = new ArrayList<>();
    
    movies.add(lotr);
    movies.add(mv2);
    
    return movies;
    
    
    
    }
    
    
}
