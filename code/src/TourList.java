import java.util.ArrayList;
import java.io.Serializable;
public class TourList implements Serializable
{
   private ArrayList<Tour> tours;
   
   public TourList(){
      tours=new ArrayList<Tour>();
   }
   
   public void addTour(Tour tour){
      tours.add(tour);
      }
   public ArrayList<Tour> getList(){
      return tours;
   }
   public Tour getTour(int index){
     return tours.get(index);
   }
   public ArrayList<Tour> getToursByDate(MyDate date){
      ArrayList<Tour> temp=new ArrayList<Tour>();
      for(int i=0;i<tours.size();i++){
         if(tours.get(i).getInterval()[0].equalsDate(date)){
            temp.add(tours.get(i));
         }
      }
      return temp;
   }
   public ArrayList<Tour> getToursByDestination(String destination){
      ArrayList<Tour> temp=new ArrayList<Tour>();
      for(int i=0;i<tours.size();i++){
         if(tours.get(i).getDestination().equalsIgnoreCase(destination)){
            temp.add(tours.get(i));
         }
      }
      return temp;
      
   }

}
