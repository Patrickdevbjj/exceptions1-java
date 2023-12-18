
package exceptions1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Exceptions1 {

   
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        System.out.println("Room Number: ");
        int number = sc.nextInt();
        System.out.println("Check-in Date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out Date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        if (checkOut.after(checkIn)) {
            System.out.println("Error in reservation: checkOut date must be after");
      
        }
        else {
            Reservation reservation = new Reservation(number, checkIn,checkOut);
        
            System.out.println("");
            System.out.println("enter data to update the reservation: ");
            System.out.println("Check in date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check Out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
            
            String error =  reservation.updateDates(checkIn, checkOut);
            if (error != null )
                System.out.println("Eror in Reservation: " + error);
            else {
                System.out.println("Reservation :" + reservation );
            }
    }
        sc.close();
    
    }
}
