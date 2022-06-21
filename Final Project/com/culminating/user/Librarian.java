/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: Librarian class
 */

package com.culminating.user;

import java.time.LocalDate;
import java.util.Date;

import com.culminating.utils.Handler;
import com.culminating.utils.Library;
import com.culminating.media.Media;

public class Librarian extends User {
	
    /**
     * library of this Librarian
     */
    private Library library;
    
    /**
     * Default Constructor of Librarian, Initializes the attributes name, address, age, gender, birthDate and library    
     */
    public Librarian() {
        super();
        this.library = null;
    }

    /**
     * Constructor of Librarian
     * @param name, Name of the Librarian
     * @param address, address of the Librarian
     * @param age, age of the Librarian
     * @param gender, gender of the Librarian
     * @param birthDate, birthDate of the Librarian
     * @param library, library of the Librarian
     */
    public Librarian(String name, String address, String gender, LocalDate birthDate, Library library, String password) {
        super(name, address, gender, birthDate, password);
        super.setType("Librarian");
        this.library = library;
    }
    
    /**
     * Description: add media to system
     * @param handler, handler to handle action
     * @param media, new media that add to system.
     */
    public void addItem(Handler handler, Media media) {
        handler.addMedia(media);
    }
    
    /**
     * Description: add user to system
     * @param handler, handler to handle action
     * @param user, new user that add to system.
     */
    public void addUser(Handler handler, User user) {
        handler.addUser(user);
    }
    
    /**
     * Description: remove user from system
     * @param handler, handler to handle action
     * @param user, the user that remove from system.
     */
    public void removeUser(Handler handler, User user) {
        handler.removeUser(user);
    }
    
    /**
     * Description: Gets the library of Librarian
     * @return the library of Borrower
     */
    public Library getLibrary() {
        return library;
    }
    
    /**
     * Description: set library of Librarian
     * @param library, the library of Librarian.
     */
    public void setLibrary(Library library) {
        this.library = library;
    }

    /**
     * Returns all the attributes of the Librarian in a String.
     *
     * @return  String representation all the attributes of the Librarian.
     */
    public String toString() {
        return super.toString() + "\nLibrary: " + this.library;
    }
}