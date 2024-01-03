
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainsExceptions;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainsExceptions {
        if (!checkOut.after(checkIn)) {
            throw new DomainsExceptions("Check-Out date must be after check-In date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reservation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return    TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    public void updateDates(Date checkIn, Date checkOut) throws DomainsExceptions {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
          throw new DomainsExceptions("Error in reservation dates!!")  ;
        }
        if (!checkOut.after(checkIn)) {
            throw new IllegalArgumentException("CheckOut date must be after a checkIn date ");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
     }

    
    @Override
     public String toString() {
        return " nights" 
               + "room "
                + roomNumber
                + ", check-in: "
                +  sdf.format(checkIn)
                ;

    }
    }

