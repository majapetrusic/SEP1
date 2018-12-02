import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
   private ArrayList<Customer> customers;

   public CustomerList()
   {
      customers = new ArrayList<Customer>();
   }

   // Add a customer to the list
   public void addCustomer(Customer customer)
   {
      customers.add(customer);
   }
   
   public ArrayList<Customer> getList(){
      return customers;
   }

   // Replace the Room object at index with student
   public void setCustomer(Customer customer, int index)
   {
      customers.set(index, customer);
   }

   // Return the Room object at index if one exists,
   // else return null
   public Customer getCustomer(int index)
   {
      if (index < customers.size())
      {
         return customers.get(index);
      }
      else
      {
         return null;
      }
   }

   public void removeCustomer(int index)
   {
      customers.remove(index);
   }

   public boolean contains(Customer customer)
   {
      return customers.contains(customer);

   }

   // Get the Room object with the given roomNumber
   // if one exists, else return null
   

  

   public CustomerList getCustomerByName(String name)
   {
      CustomerList thattype = new CustomerList();
      for (int i = 0; i < customers.size(); i++)
      {
         if (customers.get(i).getName().equalsIgnoreCase(name))
            thattype.addCustomer(customers.get(i));
      }
      return thattype;
   }

   // Return how many customeres objects are in the list

   // The toString method in ArrayList doesn't give a good result
   // with many Room objects, so I make my own toString and
   // manually add a newline after each room

   public String toString()
   {
      String s = "";

      for (int i = 0; i < customers.size(); i++)
      {
         s += "\n" + customers.get(i).toString();

      }
      return s;
   }

}
