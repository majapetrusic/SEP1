import java.io.Serializable;
public class Passenger implements Serializable
{
   private String name;
   private String address;
   private int age;
   private double price;

   public Passenger(String name, String address, int age,double price)
   {
      this.name = name;
      this.address = address;
      this.age = age;
      this.price = price;
   }

   public String getName()
   {
      return name;
   }

   public String getAddress()
   {
      return address;
   }

   public int getAge()
   {
      return age;
   }

   public double getPrice()
   {
      return price;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public void setPrice(double price)
   {
      this.price = price;
   }

   public String toString()
   {
      return name + "  " + address + "  " + age + "   " + price;
   }
}
