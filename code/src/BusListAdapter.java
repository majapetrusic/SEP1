import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BusListAdapter 
{
   private FileIO fileio;
   private String filename;

   public BusListAdapter(String filename)
   {
      fileio = new FileIO();
      this.filename = filename;
   }
   
   
   public void saveBuses(BusList buses)
   {
      
      try
      {
         fileio.writeToFile(filename,buses);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e){
         System.out.println("IO errrorr");
      }
      
   }
   public int getSize(){
      BusList buses = new BusList();

      try
      {
         buses = (BusList) fileio.readObjectFromFile(filename);
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
      ArrayList<Bus> list=buses.getList();
      return list.size();
      
   }
   public BusList getAllBuses()
   {
      BusList buses = new BusList();

      try
      {
         buses = (BusList) fileio.readObjectFromFile(filename);
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
      return buses;
   }
   
   
}



   


