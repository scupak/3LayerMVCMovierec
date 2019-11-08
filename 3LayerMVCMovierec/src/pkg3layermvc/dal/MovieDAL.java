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
import java.io.*;
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
         
         
        // ArrayList<Movie> movies = new ArrayList<>();
         
        try(BufferedReader br = 
                new BufferedReader(
                new FileReader(
                new File(MOVIE_SOURCE))))
        {
        ArrayList<Movie> movies = new ArrayList<>();
        String alineoftekst;
        while ((alineoftekst = br.readLine()) != null) {            
               
              Movie movie = stringToMovie(alineoftekst);
          
                movies.add(movie);
                
               
            //System.out.println(alineoftext.substring(0, alineoftext.indexOf(",")));
            //System.out.println(alineoftext.substring(alineoftext.indexOf(","), alineoftext.indexOf(",", alineoftext.indexOf(","))));
            
            
        }
        return movies;
        }
        finally{
      
        }
    }
    private Movie stringToMovie(String text){
        
         int id;
         int year;
      
        String[] splitString = text.split(",");
                
                 id = Integer.parseInt(splitString[0]);
                 //ch
                if(!splitString[1].equalsIgnoreCase("NULL")){ 
                    
                     year = Integer.parseInt(splitString[1]);
                } else {
                     year = -1;
                    }
               
                
                //System.out.println(Integer.parseInt(splitString[1]));
                
        String title = splitString[2];
               
        Movie m = new Movie(id, year, title);
        
    
    return m;
    
    }
    /*
    public void removeFromList(int id) throws IOException{
        try(BufferedReader reader =new BufferedReader(new FileReader(new File(MOVIE_SOURCE))), BufferedWriter writer = new BufferedWriter(new FileWriter())) {
            
        } catch (Exception e) {
        }
    
    
    }
    */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        MovieDAL dal = new MovieDAL();
        
        dal.getAllMovies();
       
        
        for (Movie movie : dal.getAllMovies()) {
            
            System.out.println(movie);
            
        }
       
        
    }
   
}