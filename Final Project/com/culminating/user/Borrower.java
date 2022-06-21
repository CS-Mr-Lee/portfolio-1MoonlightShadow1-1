/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: Borrower class
 */
package com.culminating.user;

import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

import com.culminating.utils.Handler;
import com.culminating.utils.Library;
import com.culminating.media.Media;
import com.culminating.payment.Fee;

public class Borrower extends User {
    /**
     * library of this Borrower
     */
    private Library library;
    
    /**
     * Default Constructor of Borrower, Initializes the attributes name, address, age, gender, birthDate and library    
     */
    public Borrower() {
        super();
    }

    /**
     * Constructor of Borrower
     * @param name, Name of the Borrower
     * @param address, address of the Borrower
     * @param age, age of the Borrower
     * @param gender, gender of the Borrower
     * @param birthDate, birthDate of the Borrower
     * @param library, library of the Borrower
     */
    public Borrower(String name, String address, String gender, LocalDate birthDate, Library library, String password) {
        super(name, address, gender, birthDate, password);
        super.setType("Borrower");
        this.library = library;
    }
    
    /**
     * Description: borrow media from system
     * @param handler, handle action
     * @param media, the media need borrow from system.
     */
    public void borrow(Handler handler, Media media) {
        handler.checkOut(this, media);
    }
 
    /**
     * Description: return media to system
     * @param handler, handle action
     * @param media, the media need return to system.
     */
    public void returnMedia(Handler handler, Media media) {
        handler.checkIn(this, media);        
    }
	
    /**
     * Description: hold media in system
     * @param handler, handle action
     * @param media, the media need hold in system.
     */
    public void placeHold(Handler handler, Media media) {
        handler.addHold(media, this);
    }
	
    /**
     * Description: pay fee to system
     * @param handler, handle action
     * @param fee, the fee need to pay in system.
     */
    public void payFee(Handler handler, Fee fee) {
        handler.payPenalty(fee);
    }
	
    /**
     * Description: Gets the library of Borrower
     * @return the library of Borrower
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Description: set library of Borrower
     * @param library, the library of Borrower.
     */
    public void setLibrary(Library library) {
        this.library = library;
    }

    /**
     * Returns all the attributes of the Borrower in a String.
     *
     * @return  String representation all the attributes of the Borrower.
     */
    public String toString() {
        return super.toString() + "\nLibrary: " + this.library;
    }	
}