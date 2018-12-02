import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class MyDate implements Serializable
{

   private int day;
   private int month;
   private int year;
   private int hour;
   private int minute;

   public MyDate(int day, int month, int year, int hour, int minute)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.hour = hour;
      this.minute = minute;

   }

   public MyDate(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
      this.hour = 0;
      this.minute = 0;

   }

   public MyDate()
   {
      Calendar now = GregorianCalendar.getInstance();
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = now.get(Calendar.MONTH) + 1;
      this.year = now.get(Calendar.YEAR);
      this.hour = now.get(Calendar.HOUR_OF_DAY);
      this.minute = now.get(Calendar.MINUTE);
   }

   public void setDay(int d)
   {
      this.day = d;
   }

   public void setMonth(int m)
   {
      this.month = m;
   }

   public void setYear(int y)
   {
      this.year = y;
   }

   public void setHour(int h)
   {
      this.hour = h;
   }

   public void setMinute(int min)
   {
      this.minute = min;
   }

   public int getDay()
   {
      return day;
   }

   public int getMonth()
   {
      return month;
   }

   public int getYear()
   {
      return year;
   }

   public int getHour()
   {
      return hour;
   }

   public int getMinute()
   {
      return minute;
   }

   public String getMonthName()
   {
      switch (month)
      {
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";

         default:
            return "Wrong month, please try again!";
      }
   }
   
   public int monthNum(String month){
      switch (month)
      {
         case "January":
            return 1;
         case "February":
            return 2;
         case "March":
            return 3;
         case "April":
            return 4;
         case "May":
            return 5;
         case "June":
            return 6;
         case "July":
            return 7;
         case "August":
            return 8;
         case "September":
            return 9;
         case "Otober":
            return 10;
         case "November":
            return 11;
         case "December":
            return 12;

         default:
            return 0;
      }
   }
   
   public String getMonthName(int i)
   {
      switch (i)
      {
         case 1:
            return "January";
         case 2:
            return "February";
         case 3:
            return "March";
         case 4:
            return "April";
         case 5:
            return "May";
         case 6:
            return "June";
         case 7:
            return "July";
         case 8:
            return "August";
         case 9:
            return "September";
         case 10:
            return "October";
         case 11:
            return "November";
         case 12:
            return "December";

         default:
            return "Wrong month, please try again!";
      }
   }

   public boolean isLeapYear()
   {
      return (year % 4 == 0 && ((year % 100 != 0 || (year % 400 == 0))));
   }
   public boolean isLeapYear(int n)
   {
      return (n % 4 == 0 && ((n % 100 != 0 || (n % 400 == 0))));
   }

   public int numberOfDaysInMonth()
   {
      int daysInMonth = -1;
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
            || month == 10 || month == 12)
      {
         daysInMonth = 31;
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
         daysInMonth = 30;

      }
      else
      {
         if (isLeapYear())
         {
            daysInMonth = 29;
         }
         else
         {
            daysInMonth = 28;

         }

      }
      return daysInMonth;
   }
   
   public int numberOfDaysInMonth(int n,int y)
   {
      int daysInMonth = -1;
      if (n == 1 || n == 3 || n == 5 || n == 7 || n == 8
            || n == 10 || n == 12)
      {
         daysInMonth = 31;
      }
      else if (n == 4 || n == 6 || n == 9 || n == 11)
      {
         daysInMonth = 30;

      }
      else
      {
         if (new MyDate().isLeapYear(y))
         {
            daysInMonth = 29;
         }
         else
         {
            daysInMonth = 28;

         }

      }
      return daysInMonth;
   }

   public boolean isBefore(MyDate other)
   {
      if (year < other.getYear())
      {
         return true;
      }
      else if (year > other.getYear())
      {
         return false;
      }
      else
      {
         if (month < other.getMonth())
         {
            return true;

         }
         else if (month > other.getMonth())
         {
            return false;
         }
         else
         {
            if (day < other.getDay())
            {
               return true;
            }
            else if (day > other.getDay())
            {
               return false;
            }
            else
            {
               if (hour < other.getHour())
               {
                  return true;
               }
               else if (hour > other.getHour())
               {
                  return false;
               }
               else
               {
                  if (minute < other.getMinute())
                  {
                     return true;
                  }
                  else
                  {
                     return false;
                  }
               }
            }
         }
      }
   }

   public boolean isBetween(MyDate date1, MyDate date2)
   {

      if (date1.isBefore(this) && this.isBefore(date2))
      {
         return true;
      }
      return false;
   }

   public MyDate copy()
   {
      MyDate copy = new MyDate(day, month, year, hour, minute);
      return copy;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof MyDate))
         return false;
      MyDate other = (MyDate) obj;
      return day == other.getDay() && month == other.getMonth()
            && year == other.getYear() && hour == other.getHour()
            && minute == other.getMinute();
   }
   public boolean equalsDate(Object obj)
   {
      if (!(obj instanceof MyDate))
         return false;
      MyDate other = (MyDate) obj;
      return day == other.getDay() && month == other.getMonth()
            && year == other.getYear();
   }

   public String toString()
   {
      String s = "";
      if (day < 10)
      {
         s += "0";

      }
      s += day + "/";
      if (month < 10)
      {
         s += "0";
      }
      s += month + "/" + year + "   ";
      if (hour < 10)
      {
         s += "0";
      }
      s += hour + ":";
      if (minute < 10)
      {
         s += "0";
      }
      s += minute;

      return s;
   }

   public String toStringTime()
   {
      String s = "";
      if (hour < 10)
      {
         s += "0";
      }
      s += hour + ":";
      if (minute < 10)
      {
         s += "0";
      }
      s += minute;
      return s;
   }

}
