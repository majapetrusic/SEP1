import java.util.ArrayList;
import java.io.Serializable;
public class Tour implements Serializable
{
   private String from;
   private String to;
   private MyDate[] travel;
   private MyDate[] back;
   private MyDate[] interval;
   private String type;
   private Bus bus;
   private Chauffeur chauffeur;
   private ArrayList<Reservation> reservations;
   private ArrayList<String> pickuplocations;


   public Tour(String type, String from, String to, MyDate date1, MyDate date2,
         MyDate date3, MyDate date4, Bus bus, Chauffeur chauffeur)
   {
      this.type = type;
      this.from = from;
      this.to = to;
      this.travel = new MyDate[] { date1, date2 };
      this.back = new MyDate[] { date3, date4 };
      this.interval = new MyDate[] { date1, date4 };
      this.bus = bus;
      
      this.chauffeur = chauffeur;
     
      this.reservations = new ArrayList<Reservation>();
      this.pickuplocations=new ArrayList<String>();
      
   }
   //public void removeReservation()

   public Tour(String from, String to, MyDate date1, MyDate date2,
         MyDate date3, MyDate date4, Bus bus, Chauffeur chauffeur,Reservation reservation)
   {
      this.from = from;
      this.to = to;
      this.travel = new MyDate[] { date1, date2 };
      this.back = new MyDate[] { date3, date4 };
      this.interval = new MyDate[] { date1, date4 };
      this.reservations = new ArrayList<Reservation>();
      this.reservations.get(0).getCustomer().increment();
      this.bus = bus;
      this.bus.notAvailable(interval);
      this.chauffeur = chauffeur;
      this.chauffeur.notAvailable(interval);
      this.reservations.add(reservation);
      this.type="Bus and chauffeur";

   }

   public void addReservation(Reservation reservation)
   {
      reservations.add(reservation);
   }

   public MyDate[] getInterval()
   {
      return interval;
   }

   public String getFrom()
   {
      return from;
   }
   public String getDestination(){
      return to;
   }

   public Chauffeur getChauffeur()
   {
      return chauffeur;
   }
   public Bus getBus(){
      return bus;
   }

   public String toString()
   {
      String s = "";
      s += "Travel \n\n";
      s += from + " - " + travel[0].toString() + "\n";
      s += to + " - " + travel[1].toString() + "\n\n";
      s += "Back \n\n";
      s += to + " - " + back[0].toString() + "\n";
      s += from + " - " + back[1].toString() + "\n\n";
      s += "Chauffeur:  " + chauffeur.getName() + "\n\n";
      s += "Passenger list: \n____________________________________";
      for (int i = 0; i < reservations.size(); i++)
      {
         s += "\n\n" + reservations.get(i).getCustomer().getName()
               + "\n---------------";
         for (int j = 0; j < reservations.get(i).numberOfPassengers(); j++)
         {
           // s += "\n" + reservations.get(i).getPassenger(j).getName();
         }
      }
      return s;

   }

}
