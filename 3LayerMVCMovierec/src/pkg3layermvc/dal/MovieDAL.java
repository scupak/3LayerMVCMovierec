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
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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
    
        public void deleteMovie(Movie movie) 
    {
        try
        {
            File file = new File(MOVIE_SOURCE);
            List<Movie> movies = getAllMovies();
            OutputStream os = Files.newOutputStream(file.toPath(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
            try ( BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)))
            {
                for (Movie mov : movies)
                {
                    if (mov.getId() != movie.getId())
                    {
                        String line = mov.getId() + "," + mov.getYear() + "," + mov.getTitle();
                        bw.write(line);
                        bw.newLine();
                    }
                    else{
                        System.out.println(mov);
                        System.out.println("shit");
                    }
                }
            }
        } catch (IOException ex)
        {
            
        }
    }
        
          public void updateMovie(Movie movie) 
    {
        try
        {
            File file = new File(MOVIE_SOURCE);
            List<Movie> movies = getAllMovies();
            OutputStream os = Files.newOutputStream(file.toPath(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
            
                    try ( BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os)))
                    {
                        if(movies.remove(movie)){
                            
                            movies.add(movie);

                                for (Movie mov : movies)
                                {
                                        String line = mov.getId() + "," + mov.getYear() + "," + mov.getTitle();
                                        bw.write(line);
                                        bw.newLine();
                                }
                        }
                    }
                    
        } catch (IOException ex)
        {
            
        }
    }
          public void writeAllMovies(List<Movie> allMovies, String filename) throws IOException, ClassNotFoundException{
          
          File listFile = new File(filename);
          
              try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listFile))) {
                  
                  oos.writeObject(allMovies);
                  oos.flush();
              } 
          
               try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listFile))) {
                  
                  List<Movie> sameListAsMovie = (List<Movie>) ois.readObject();
                  
                   for (Movie movie : sameListAsMovie) {
                       
                       System.out.println(movie);
                       
                   }
              } 
          
          
          }
    

    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        MovieDAL dal = new MovieDAL();
        /*
        System.out.println(dal.getAllMovies().get(0));
        System.out.println();
        */
        dal.deleteMovie(dal.getAllMovies().get(0));
        dal.getAllMovies();
        
        dal.writeAllMovies(dal.getAllMovies(), "data/movie_objects.txt");
        
    /*    
        for (Movie movie : dal.getAllMovies()) {
            
            System.out.println(movie);
            
        }
       */
        
    }
   
}