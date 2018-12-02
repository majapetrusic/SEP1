import java.io.Serializable;
import java.util.ArrayList;

public class ChauffeurList implements Serializable
{
   private ArrayList<Chauffeur> chauffeurs;

   public ChauffeurList()
   {
      chauffeurs = new ArrayList<Chauffeur>();
   }

   // Add a chauffeur to the list
   public void addChauffeur(Chauffeur chauffeur)
   {
      chauffeurs.add(chauffeur);
   }
   
   public ArrayList<Chauffeur> getList(){
      return chauffeurs;
   }

   // Replace the Room object at index with student
   public void setChauffeur(Chauffeur chauffeur, int index)
   {
      chauffeurs.set(index, chauffeur);
   }

   // Return the Room object at index if one exists,
   // else return null
   public Chauffeur getChauffeur(int index)
   {
      if (index < chauffeurs.size())
      {
         return chauffeurs.get(index);
      }
      else
      {
         return null;
      }
   }

   public void removeChauffeur(int index)
   {
      chauffeurs.remove(index);
   }

   public boolean contains(Chauffeur chauffeur)
   {
      return chauffeurs.contains(chauffeur);

   }

   // Get the Room object with the given roomNumber
   // if one exists, else return null
   

   public ChauffeurList getAvailablechauffeures(MyDate from, MyDate to)
   {
      ChauffeurList available = new ChauffeurList();
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).isAvailable(from, to))
         {
            available.addChauffeur(chauffeurs.get(i));
         }
      }
      return available;
   }

   public ChauffeurList getChauffeurByName(String name)
   {
      ChauffeurList thattype = new ChauffeurList();
      for (int i = 0; i < chauffeurs.size(); i++)
      {
         if (chauffeurs.get(i).getName().equalsIgnoreCase(name))
            thattype.addChauffeur(chauffeurs.get(i));
      }
      return thattype;
   }

   // Return how many chauffeures objects are in the list

   // The toString method in ArrayList doesn't give a good result
   // with many Room objects, so I make my own toString and
   // manually add a newline after each room

   public String toString()
   {
      String s = "";
      s+="1.   "+chauffeurs.get(0).getName();
      for (int i = 1; i < chauffeurs.size(); i++)
      {
         s += "\n"+(i+1)+".   " + chauffeurs.get(i).getName();

      }
      return s;
   }

}
