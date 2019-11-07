/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3layermvc.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg3layermvc.be.Movie;

/**
 *
 * @author anton
 */
public class MovieDAL {
    
    private static final String MOVIE_SOURCE = "data/movie_titles.txt";
    
    
    public List<Movie> getAllMovies() throws FileNotFoundException, IOException{
        ArrayList<Movie> movies = new ArrayList<>();
        File file = new File(MOVIE_SOURCE);
        
        FileReader fr = new FileReader(file);
        BufferedReader br =  new BufferedReader(fr);
       
        while (true) {            
            
            String alineoftext = br.readLine();
            if (alineoftext == null) {
                break;
            }
            else{
            System.out.println(br.readLine());
            }
            
        }
        
        
        
        return null;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        MovieDAL dal = new MovieDAL();
        
        
            dal.getAllMovies();
        
        
    }
   
}