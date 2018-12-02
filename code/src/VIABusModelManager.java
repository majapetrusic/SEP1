import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VIABusModelManager implements Serializable
{

   private BusListAdapter bla;
   private ChauffeurListAdapter chla;
   private CustomerListAdapter cula;
   private TourListAdapter tla;
   private String blafile = "buslist.bin";
   private String chlafile = "chauffeurlist.bin";
   private String culafile = "customerlist.bin";
   private String tlafile = "tourlist.bin";
   private MyDate from;
   private MyDate to;

   private MyDate date = new MyDate();

   public VIABusModelManager()
   {
      bla = new BusListAdapter("buslist.bin");
      chla = new ChauffeurListAdapter("chauffeurlist.bin");
      tla = new TourListAdapter();
      cula = new CustomerListAdapter("customerlist.bin");
   }

   public int currentDay()
   {
      MyDate date = new MyDate();
      return date.getDay();

   }

   public int currentMonth()
   {
      MyDate date = new MyDate();
      return date.getMonth();

   }

   public int currentYear()
   {
      MyDate date = new MyDate();
      return date.getYear();

   }

   public int currentHour()
   {
      MyDate date = new MyDate();
      return date.getHour();

   }

   public int currentMinute()
   {
      MyDate date = new MyDate();
      return date.getMinute();

   }

   public String[] getMonths(int n)
   {
      String[] str = new String[13 - n];
      int k = 0;
      for (int i = n; i <= 12; i++)
      {

         str[k] = date.getMonthName(i);
         k++;
      }
      return str;
   }

   public String[] getMonths()
   {
      String[] str = new String[12];

      for (int i = 0; i < 12; i++)
      {

         str[i] = date.getMonthName(i + 1);

      }
      return str;
   }

   public int getMonthNum(String month)
   {
      return date.monthNum(month);
   }

   public String[] getYears()
   {
      String[] str = new String[5];
      for (int i = 0; i < 5; i++)
      {
         str[i] = Integer.toString(currentYear() + i);
      }
      return str;
   }

   public String[] getDays(int n, int y)
   {
      int z = date.numberOfDaysInMonth(n, y);
      int k;
      int j = 0;
      String[] str;
      if (n == date.getMonth())
      {
         k = z - date.getDay() + 1;
         str = new String[k];
         for (int i = 0; i < k; i++)
         {
            str[i] = Integer.toString(date.getDay() + i);
         }
      }
      else
      {
         k = z;
         str = new String[k];
         for (int i = 0; i < k; i++)
         {
            str[i] = Integer.toString(i + 1);
         }

      }
      return str;
   }

   public BusList getAllBuses()
   {
      return bla.getAllBuses();
   }

   public TourList getAllTours()
   {
      return tla.getAllTours();
   }

   public void addTour(Tour tour)
   {
      TourList list = tla.getAllTours();
      list.addTour(tour);
      tla.saveTours(list);
   }

   public ChauffeurList getAllChauffeurs()
   {
      return chla.getAllChauffeurs();
   }

   public Object[][] getBusesTable()
   {

      Object[][] object = new Object[new BusListAdapter("buslist.bin")
            .getSize()][3];

      for (int i = 0; i < bla.getAllBuses().getList().size(); i++)
      {
         object[i][0] = bla.getAllBuses().getBus(i).getModel();
         object[i][1] = bla.getAllBuses().getBus(i).getType();
         object[i][2] = bla.getAllBuses().getBus(i).getSeats();

      }
      return object;
   }

   public Object[][] getBusesTable2()
   {

      Object[][] obj = new Object[bla.getAllBuses().getList().size()][2];

      for (int i = 0; i < bla.getAllBuses().getList().size(); i++)
      {
         obj[i][0] = bla.getAllBuses().getBus(i).getModel();

         obj[i][1] = bla.getAllBuses().getBus(i).getSeats();

      }
      return obj;
   }

   public void createTour(String type, String from, String to, MyDate date1,
         MyDate date2, MyDate date3, MyDate date4, Bus bus, Chauffeur chauffeur)
   {
      try
      {

        

         Tour tour = new Tour(type, from, to, date1, date2, date3, date4, bus,
               chauffeur);

         BusList buses = bla.getAllBuses();
        
         ChauffeurList chauffeurs=chla.getAllChauffeurs();
         
         for(int i=0;i<chauffeurs.getList().size();i++){
            
            if(chauffeur.equals(chauffeurs.getChauffeur(i))){
               chauffeurs.setChauffeur(chauffeur, i);
                   
               chauffeurs.getChauffeur(i).notAvailable(tour.getInterval());
               break;
            }
         }
         chla.saveChauffeurs(chauffeurs);
   
         
         for(int i=0;i<buses.getList().size();i++){
           
            if(bus.equals(buses.getBus(i))){
               buses.setBus(bus, i);
               JOptionPane.showMessageDialog(null, bus.toString());          
               buses.getBus(i).notAvailable(tour.getInterval());
               break;
            }
         }
         
         
         
        
        
         bla.saveBuses(buses);
         
         
         TourList list = new TourList();
         list = tla.getAllTours();
         list.addTour(tour);
         tla.saveTours(list);
      }
      catch (Exception e)
      {
         System.out.println("Sometin wrong");

      }
   }

   public Object[][] getAvailableBusesTable(MyDate from, MyDate to)
   {

      Object[][] obj = new Object[bla.getAllBuses().getAvailableBuses(from, to)
            .getList().size()][3];

      for (int i = 0; i < bla.getAllBuses().getAvailableBuses(from, to)
            .getList().size(); i++)
      {
         obj[i][0] = bla.getAllBuses().getAvailableBuses(from, to).getBus(i)
               .getModel();
         obj[i][1] = bla.getAllBuses().getAvailableBuses(from, to).getBus(i)
               .getType();
         obj[i][2] = bla.getAllBuses().getAvailableBuses(from, to).getBus(i)
               .getSeats();

      }
      return obj;
   }

   public Object[][] getAvailableBusesTypeTable(MyDate from, MyDate to,
         String type)
   {

      BusList temp = new BusList();
      temp = bla.getAllBuses().getAvailableBuses(from, to);
      BusList ret = new BusList();
      for (int i = 0; i < temp.getList().size(); i++)
      {
         if (type.equals(temp.getBus(i).getType()))
         {
            ret.addBus(temp.getBus(i));
         }
      }
      Object[][] obj = new Object[ret.getList().size()][2];

      for (int i = 0; i < ret.getList().size(); i++)
      {
         obj[i][0] = ret.getBus(i).getModel();
         obj[i][1] = ret.getBus(i).getSeats();

      }
      return obj;
   }

   public Object[][] getChauffeursTable()
   {
      Object[][] obj = new Object[chla.getAllChauffeurs().getList().size()][5];

      for (int i = 0; i < chla.getAllChauffeurs().getList().size(); i++)
      {
         obj[i][0] = chla.getAllChauffeurs().getChauffeur(i).getName();
         obj[i][1] = chla.getAllChauffeurs().getChauffeur(i).getAddress();
         obj[i][2] = chla.getAllChauffeurs().getChauffeur(i).getId();
         obj[i][3] = chla.getAllChauffeurs().getChauffeur(i).getPhoneNum();
         obj[i][4] = chla.getAllChauffeurs().getChauffeur(i).getEmail();

      }
      return obj;
   }

   public Object[][] getChauffeursTable1()
   {
      Object[][] obj = new Object[chla.getAllChauffeurs().getList().size()][1];

      for (int i = 0; i < chla.getAllChauffeurs().getList().size(); i++)
      {
         obj[i][0] = chla.getAllChauffeurs().getChauffeur(i).getName();

      }
      return obj;
   }

   public Object[][] getAvailableChauffeursTable(MyDate from, MyDate to)
   {
      Object[][] obj = new Object[chla.getAllChauffeurs()
            .getAvailablechauffeures(from, to).getList().size()][1];

      for (int i = 0; i < chla.getAllChauffeurs()
            .getAvailablechauffeures(from, to).getList().size(); i++)
      {
         obj[i][0] = chla.getAllChauffeurs().getChauffeur(i).getName();

      }
      return obj;
   }

   public Object[] getLastBus()
   {
      Bus bus = bla.getAllBuses().getBus(
            (bla.getAllBuses().getList().size()) - 1);
      Object[] obj = new Object[3];
      obj[0] = bus.getModel();
      obj[1] = bus.getType();
      obj[2] = bus.getSeats();
      return obj;
   }

   public Object[] getLastChauffeur()
   {
      Chauffeur chauffeur = chla.getAllChauffeurs().getChauffeur(
            (chla.getAllChauffeurs().getList().size()) - 1);
      Object[] obj = new Object[5];
      obj[0] = chauffeur.getName();
      obj[1] = chauffeur.getAddress();
      obj[2] = chauffeur.getId();
      ;
      obj[3] = chauffeur.getPhoneNum();
      obj[4] = chauffeur.getEmail();
      return obj;

   }

   public void addBus(String model, String type, int seats)
   {
      Bus bus = new Bus(model, type, seats);
      BusList temp = new BusList();
      temp = this.getAllBuses();
      temp.addBus(bus);
      bla.saveBuses(temp);
   }

   public void addChauffeur(String name, String address, int id,
         String phonenum, String email)
   {
      Chauffeur chauffeur = new Chauffeur(name, address, id, phonenum, email);
      ChauffeurList temp = new ChauffeurList();

      temp = this.getAllChauffeurs();
      temp.addChauffeur(chauffeur);
      chla.saveChauffeurs(temp);
   }

   public void removeBus(int index)
   {
      BusList temp = new BusList();
      temp = bla.getAllBuses();
      temp.removeBus(index);
      bla.saveBuses(temp);
   }

   public void removeChauffeur(int index)
   {
      ChauffeurList temp = new ChauffeurList();
      temp = getAllChauffeurs();
      temp.removeChauffeur(index);
      chla.saveChauffeurs(temp);
   }

   public String allBusesToString()
   {
      return bla.getAllBuses().toString();
   }

   public BusList getAvailableBuses(MyDate from, MyDate to)
   {
      this.from = from;
      this.to = to;
      return bla.getAllBuses().getAvailableBuses(from, to);
   }

   public ChauffeurList getAvailableChauffeurs(MyDate from, MyDate to)
   {
      return chla.getAllChauffeurs().getAvailablechauffeures(from, to);
   }
   // public BusList getAvailableBusesType(String type){
   // BusList temp=new BusList();
   // BusList ret=new BusList();
   // temp = this.getAvailableBuses(from, to);
   // for(int i=0;i<temp.getList().size();i++){
   // if(type.equals(temp))
   // }
   // }

}
