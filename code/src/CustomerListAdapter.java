import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerListAdapter
{
   private FileIO fileio;
   private String filename;

   public CustomerListAdapter(String filename)
   {
      fileio = new FileIO();
      this.filename = filename;
   }
   
   
   public void saveCustomers(CustomerList customers)
   {
      
      try
      {
         fileio.writeToFile(filename,customers);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch(IOException e){
         System.out.println("IO errrorr");
      }
      
   }
   public CustomerList getAllCustomers()
   {
      CustomerList customers = null;

      try
      {
         customers = (CustomerList) fileio.readObjectFromFile(filename);
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
      return customers;
   }
   
   
}



   


