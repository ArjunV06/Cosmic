import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Cosmic
{
    //plan is to do for(i=0 until i = in.Nextint - 1) as long as in.nextInt(month) is greater than 1 to get number of days from monthVal
    //else just take second num as total days
    //then, add the second in.nextInt to it to get total number of days
    //then take that total number of days, and multiply it by 4
    //% 60 it, that number is your minutes

    

    /*monthVals[0] = 31;
    monthVals[1] = 28;
    monthVals[2] = 31;
    monthVals[3] = 30;
    monthVals[4] = 31;
    monthVals[5] = 30;
    monthVals[6] = 31;
    monthVals[7] = 31;
    monthVals[8] = 30;
    monthVals[9] = 31;
    monthVals[10] = 30;
    monthVals[11] = 31;*/


    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(new File("cosmic.dat"));
        int totalAmnt = in.nextInt();
        int counter = 0;
        while(counter < totalAmnt)
        {
            counter++;
            int[] monthVals = new int[] {31,28,31,30,31,30,31,31,30,31,30,31}; //array for number of days in monhs
            int dayCount=0;
        
            String cur = in.next();
            String firstNum = cur.substring(0,2);
            String secondNum = cur.substring(3);
            int fir = Integer.parseInt(firstNum);
            int sec = Integer.parseInt(secondNum);
            //System.out.println(fir + "" + sec);
            if(fir>1)
            {
                for(int i = 0; i<fir-1; i++)
                {
                    int temp = monthVals[i];
                    //System.out.println(temp);
                    dayCount+=temp;
                }
            }
            dayCount+=sec;
            //System.out.println(in.nextLine());
            double conversionFactor = 1440.0/365.0;
            //System.out.println(conversionFactor);
            int days = dayCount-1;
            double totalMins = days * conversionFactor;
            double mins = totalMins%60;
            double hours = (totalMins-=mins) / 60;
            int roundedMins = (int)mins;//(int)Math.round(mins);
            int roundedHours= (int)hours;//Math.round(hours);
            //System.out.println(days);
            if(roundedHours>=10 && roundedMins>=10)
            {
                System.out.println(roundedHours + ":" + roundedMins);
            }
            else if(roundedHours<10 && roundedMins>=10)
            {
                System.out.println("0" + roundedHours + ":" + roundedMins);
            }
            else if(roundedHours>=10 && roundedMins<10)
            {
                System.out.println(roundedHours + ":" + "0" + roundedMins);
            }
            else
            {
                System.out.println("0" + roundedHours + ":" + "0" + roundedMins);
            }
        }
        
        

    }
}