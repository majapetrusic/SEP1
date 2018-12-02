import java.util.ArrayList;
import java.io.Serializable;

public class Reservation implements Serializable
{
   private Customer customer;
   private PassengerList list;
   private double price;
   private int numberofpassengers;

   public Reservation(Customer customer, PassengerList list)
   {
      this.customer = customer;
      this.list = list;
      numberofpassengers = list.getNumberOfPassengers();
      price = 0;
      this.customer.increment();
   }

   public Reservation(Customer customer, int numberofpassengers)
   {
      this.customer = customer;
      this.numberofpassengers = numberofpassengers;
   }

   public int numberOfPassengers()
   {
      return numberofpassengers;
   }

   public void setNumberOfPassengers(int numberofpassengers)
   {
      this.numberofpassengers = numberofpassengers;
   }

   public Customer getCustomer()
   {
      return customer;
   }

   public PassengerList getPassengerList()
   {
      return list;
   }

   public void setPrice(double price)
   {
      this.price = price;
   }

   public void calculatePrice()
   {
      price = list.getTotalPrice();

   }

   public double getPrice()
   {
      return price;

   }

}
