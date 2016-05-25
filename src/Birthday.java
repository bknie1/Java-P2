//  P2BirthdayKnieriem.java
//  @Author: Brandon Knieriem
//	@Version: 1.0

import java.util.*;

//------------------------------------------------------------------------------
public class Birthday{
    public static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May",
    "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    public static final String[] days = { "Sunday", "Monday", "Tuesday",
    "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] startsOn = {5, 1, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    public static final int[] daysinmonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 
    										 31, 30, 31}; // Weekday/Days 2016
    
    private String month;   // Month.
    private int date;       // 1-31.
    private int	iDoY;		// 1-365.
    private String day;     // The day of the week.

    //--------------------------------------------------------------------------
    // Compute a new random value for the die.
    // Postcondition: the return value is between 1 and faces.
    Birthday( String m, int d){
        month = m;
        date = d;
        
        calculateDay();
    }
    //--------------------------------------------------------------------------    
    private void calculateDay() {
        int found, k, i, answer;
        for(k = 0; k < 12; ++k) {
            if (months[k].equals(month))  break;
        }
        found = k;
        
        if (found == 12)
            System.out.println("Your month name was not a valid 3-letter "
            		+ "abbreviation.");
        else {
            answer = (startsOn[k] + date -1)%7;
            day = days[answer];
        }
        
        if(k != 0) {
            for(i = 0; i < k; i++) {
            	iDoY += daysinmonth[i];
            }
    	}
        iDoY += date;
    }
    //--------------------------------------------------------------------------    
    public String getDay(){  return day;  }

    public String toString(){
        return month +" " + date ;
    }
    
    public Integer getDoY() { return iDoY;	}

    public static void  main( String[] args ) {
        int date;
        String monthname;
        Scanner sc = new Scanner( System.in );

        System.out.println("\n2016 Leap Year Birthday Day Calculator");
        System.out.print ("Months are: ");
        for( String s : months) System.out.print( s+"  " );

        System.out.println("\n\nPlease enter your birth month and date:");
        monthname = sc.next();
        date = sc.nextInt();
        Birthday b = new Birthday (monthname, date);
        

        System.out.printf ("Your %s birthday is on %s this year\n\n",
                           b.toString(), b.getDay() );
        System.out.printf ("It is day %s of this year.\n\n", b.getDoY() );
        sc.close();
    }
}

/* output:

2016 Leap Year Birthday Day Calculator
Months are: Jan  Feb  Mar  Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec  

Please enter your birth month and date:
May 26
Your May 26 birthday is on Thursday this year

It is day 147 of this year.

*/