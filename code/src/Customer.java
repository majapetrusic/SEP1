import java.util.ArrayList;
import java.io.Serializable;

public class Customer implements Serializable
{
   private String name;
   private String organisation;
   private String address;
   private String phonenum;
   private String email;
   private int count;

   public Customer(String name, String address, String phonenum)
   {

      this.name = name;
      this.address = address;
      this.phonenum = phonenum;
      this.email = null;
      count = 0;
      organisation = null;

   }

   public Customer(String name, String address, String phonenum, String email)
   {
      this.name = name;
      this.address = address;
      this.phonenum = phonenum;
      this.email = email;
      count = 0;
      organisation = null;

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

   public String getOrganisation()
   {
      return organisation;
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

   public void setOrganisation(String organisation)
   {
      this.organisation = organisation;
   }

   public void increment()
   {
      count++;
   }

   public boolean isOrganisation()
   {
      return (organisation != null);
   }

   public int getCount()
   {
      return count;
   }

}
