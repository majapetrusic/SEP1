import java.util.ArrayList;
import java.io.Serializable;

public class Chauffeur implements Serializable
{
   private String name;
   private String address;
   private int id;
   private String phonenum;
   private String email;
   private ArrayList<MyDate[]> dates;
   private String fulltimeorparttime;

   Chauffeur(String name, String address, int id, String phonenum, String email)
   {
      this.name = name;
      this.address = address;
      this.phonenum = phonenum;
      this.email = email;
      this.id = id;
      dates = new ArrayList<MyDate[]>();
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

   public String listOfTours()
   {
      String s = "";
      for (int i = 0; i < dates.size(); i++)
      {
         s += dates.get(i)[0].toString() + dates.get(i)[0].toStringTime()
               + " - " + dates.get(i)[1].toString()
               + dates.get(i)[1].toStringTime();
      }
      return s;
   }

   public String getName()
   {
      return name;
   }

   public String getAddress()
   {
      return address;
   }

   public String getPhoneNum()
   {
      return phonenum;
   }

   public String getEmail()
   {
      return email;
   }

   public int getId()
   {
      return id;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public void setPhoneNum(String phonenum)
   {
      this.phonenum = phonenum;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public void setId(int id)
   {
      this.id = id;
   }
   public boolean equals(Chauffeur chauffeur){
      return this.getName().equals(chauffeur.getName())&&this.getAddress().equals(chauffeur.getAddress())&&
            this.getId()==(chauffeur.getId());
   }

}
