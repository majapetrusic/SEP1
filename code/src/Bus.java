import java.util.ArrayList;
import java.io.Serializable;
public class Bus implements Serializable
{
   private String model;
   private String type;
   private int seats;
   private ArrayList<MyDate[]> dates;

   public Bus(String model, String type, int seats)
   {
      this.model = model;
      this.type = type;
      this.seats = seats;
      dates = new ArrayList<MyDate[]>();
   }
   public void setType(String type){
      this.type=type;
   }
   public void notAvailable(MyDate[] interval)
   {
      dates.add(interval);
   }

   public boolean isAvailable(MyDate from, MyDate to)
   {
      for (int i = 0; i < dates.size(); i++)
      {
         if ((from.isBetween(dates.get(i)[0], dates.get(i)[1]))
               || (to.isBetween(dates.get(i)[0], dates.get(i)[1]))
               || (from.equals(dates.get(i)[0]))
               || (from.equals(dates.get(i)[1]))
               || (to.equals(dates.get(i)[0])) || (to.equals(dates.get(i)[1]))
               || (dates.get(i)[0].isBetween(from, to))
               || (dates.get(i)[1].isBetween(from, to)))
         {
            return false;
         }
      }
      return true;
   }

   public boolean equals(Bus bus){
      
      return this.getModel().equals(bus.getModel())
            &&this.getType().equals(bus.getType())
            &&this.seats==bus.getSeats();
   }
   public String getModel()
   {
      return model;
   }

   public String getType()
   {
      return type;
   }

   public int getSeats()
   {
      return seats;
   }
   
   public String toString(){
      String s="";
      s+=model+" - "+type+" - "+seats;
      return s;
   }
   
   //public ArrayList<MyDate[]> getOccupied(){
    //  return dates;
   //}

}
