/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3layermvc.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author anton
 */
public class RatingsDAO {
    
    private static final String RATING_SOURCE = "data/ratings_rf.dat";
 
    public void CreateRating(int movieId, int userId, int rating) throws  IOException
    {
       File ratingsSource = new File(RATING_SOURCE);
       
       try(RandomAccessFile raf = new RandomAccessFile(ratingsSource , "rw")){
       
           raf.seek(raf.length());
            raf.write(movieId);
            raf.write(userId);
            raf.write(rating);

       }
    
    }
    
    
    public static void main(String[] args) {
        
        RatingsDAO r = new RatingsDAO();
        try {
            r.CreateRating(1, 2, 3);
            r.CreateRating(100, 200, 300);
        } catch (IOException ex) {
            
        }
        
    }
    
    public int GetRating(int userId, int movieId) throws FileNotFoundException, IOException{
    
        File ratingsSource = new File(RATING_SOURCE);
        
        try(RandomAccessFile raf = new RandomAccessFile(ratingsSource, "r")) {
            
            for (int i = 0; i < raf.length(); i += 12) {
                
                
               raf.seek(i);
               int mvid = raf.readInt();
               int usId = raf.readInt();
                if (userId==usId && mvid==movieId) {
                    
                    return raf.readInt();
                    
                }
                
            }
            
        }
        throw new IllegalArgumentException("no rating found for userid" + userId + "and movieId" + movieId);
        
    
    
    
    
    }
}
