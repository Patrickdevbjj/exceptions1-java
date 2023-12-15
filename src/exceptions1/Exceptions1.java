
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
        
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation dates!!");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        
        sc.close();
    }
}
