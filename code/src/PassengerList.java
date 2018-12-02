import java.util.ArrayList;
import java.io.Serializable;

public class PassengerList implements Serializable
{
   private ArrayList<Passenger> list;

   public PassengerList()
   {
      list = new ArrayList<Passenger>();
   }

   public void addPassenger(Passenger passenger)
   {
      list.add(passenger);

   }
   

   public Passenger getPassenger(int index)
   {
      return list.get(index);
   }

   public int getNumberOfPassengers()
   {
      return list.size();
   }

   public double getTotalPrice()
   {
      double price = 0;
      for (int i = 0; i < list.size(); i++)
      {
         price += list.get(i).getPrice();
      }
      return price;
   }

}
