import java.io.Serializable;
import java.util.ArrayList;

public class BusList implements Serializable
{
   private ArrayList<Bus> buses;

   public BusList()
   {
      buses = new ArrayList<Bus>();
   }

   // Add a Bus to the list
   public void addBus(Bus bus)
   {
      buses.add(bus);
   }
   
   public ArrayList<Bus> getList(){
      return buses;
   }

   // Replace the Room object at index with student
   public void setBus(Bus bus, int index)
   {
      buses.set(index, bus);
   }

   // Return the Room object at index if one exists,
   // else return null
   public Bus getBus(int index)
   {
      if (index < buses.size())
      {
         return buses.get(index);
      }
      else
      {
         return null;
      }
   }

   public void removeBus(int index)
   {
      buses.remove(index);
   }

   public boolean contains(Bus bus)
   {
      return buses.contains(bus);

   }

   // Get the Room object with the given roomNumber
   // if one exists, else return null
   public Bus getBySeats(int seats)
   {
      for (int i = 0; i < buses.size(); i++)
      {
         Bus temp = buses.get(i);

         if (temp.getSeats() == seats)
         {
            return temp;
         }
      }

      return null;
   }

   public BusList getAvailableBuses(MyDate from, MyDate to)
   {
      BusList available = new BusList();
      for (int i = 0; i < buses.size(); i++)
      {
         if (buses.get(i).isAvailable(from, to))
         {
            available.addBus(buses.get(i));
         }
      }
      return available;
   }

   public BusList getBusOfType(String type)
   {
      BusList thattype = new BusList();
      for (int i = 0; i < buses.size(); i++)
      {
         if (buses.get(i).getType().equalsIgnoreCase(type))
            thattype.addBus(buses.get(i));
      }
      return thattype;
   }

   // Return how many buses objects are in the list

   // The toString method in ArrayList doesn't give a good result
   // with many Room objects, so I make my own toString and
   // manually add a newline after each room

   public String toString()
   {
      String s = "";
      s +="1.   "+buses.get(0).toString();
      for (int i = 1; i < buses.size(); i++)
      {
         s += "\n"+(i+1)+".   " + buses.get(i).toString();

      }
      return s;
   }

}
