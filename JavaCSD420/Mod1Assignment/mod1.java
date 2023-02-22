import java.util.*;
import java.io.*;

public class mod1
{
        public static void main(String[] args) throws Exception {
            Random rd = new Random(); 
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = rd.nextInt(); 
            System.out.println(arr[i]);
        }
                
        Date obj = new Date();
        System.out.println(obj.toString());
        
        double[] arr1 = new double[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = rd.nextDouble(); 
            System.out.println(arr1[i]);
        }
        
        FileWriter writer = new FileWriter("Carlos_datafile.dat");
        
        for (int i = 0; i < 5; i++) {
            writer.write(arr[i] + "\n");
        }
        writer.close();
        
        try
        {
            String filename= "Carlos_datafile.dat";
            FileWriter fw = new FileWriter(filename,true); 
            
            fw.write(obj.toString()+"\n");
            
            for (int i = 0; i < 5; i++) {
                fw.write(arr1[i] + "\n");
            }
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        }
}
