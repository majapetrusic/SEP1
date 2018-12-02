import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TourListAdapter
{
   private FileIO fileio;
   private String filename="tourlist.bin";

   public TourListAdapter()
   {
      fileio = new FileIO();
     // this.filename = filename;
   }
   
   
   public void saveTours(TourList tours)
   {
      
      try
      {
         fileio.writeToFile(filename,tours);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e){
         System.out.println("IO errrorr");
      }
      
   }
   public TourList getAllTours()
   {
      TourList tours = null;

      try
      {
         tours = (TourList) fileio.readObjectFromFile(filename);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return tours;
   }
   
   
}



   


