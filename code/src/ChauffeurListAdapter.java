import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ChauffeurListAdapter
{
   private FileIO fileio;
   private String filename;

   public ChauffeurListAdapter(String filename)
   {
      fileio = new FileIO();
      this.filename = filename;
   }
   
   
   public void saveChauffeurs(ChauffeurList chauffeurs)
   {
      
      try
      {
         fileio.writeToFile(filename,chauffeurs);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e){
         System.out.println("IO errrorr");
      }
      
   }
   public ChauffeurList getAllChauffeurs()
   {
      ChauffeurList chauffeurs = null;

      try
      {
         chauffeurs = (ChauffeurList) fileio.readObjectFromFile(filename);
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
      return chauffeurs;
   }
   
   
}



   


