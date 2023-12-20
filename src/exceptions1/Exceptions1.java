
package exceptions1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

public class Exceptions1 {

   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            System.out.println("Room Number: ");
            int number = sc.nextInt();
            System.out.println("Check-in Date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-out Date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn,checkOut);
            System.out.println("Reservation" + reservation);
            
            System.out.println("");
            System.out.println("enter data to update the reservation: ");
            System.out.println("Check in date (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check Out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
            
           reservation.updateDates(checkIn, checkOut);
           System.out.println("Reservation :" + reservation );
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        
        sc.close();
    
    }
}
