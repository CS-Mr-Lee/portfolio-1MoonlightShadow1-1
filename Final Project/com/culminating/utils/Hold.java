/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: hold class
 */
package com.culminating.utils;

import java.util.Date;

import com.culminating.user.User;
import com.culminating.media.Media;

public class Hold extends Log {

   /**
    * arrived of the Hold
    */
   private boolean arrived;

   /**
    * Default Constructor of Hold, Initializes the attributes arrived    
    */
   public Hold() {
    	super();
    	this.arrived = false;
   }

   /**
    * Constructor of Hold
    * @param user, user of the Hold
    * @param item, item of the Hold
    * @param date, date of the Hold
    * @param detail, detail of the Hold
    * @param arrived, arrived of the Hold
    */
   public Hold(User user, Media item, Date date, String detail, boolean arrived) {
    	super(user, item, date, detail);
    	this.arrived = arrived;
   }

   /**
    * Description: Gets the arrived of Hold
    * @return the arrived of Hold
    */
   public boolean getArrived() {
    	return this.arrived;
   }

   /**
    * Description: Sets arrived of Hold
    * @param arrived, the arrived of Hold
    */
   public void setArrived(boolean arrived) {
    	this.arrived = arrived;
   }

   /**
    * Description: prints the attributes of the Hold
    * @return String all the attributes of the Hold
    */
   public String toString() {
    	return super.toString() + "\nArrived: " + this.arrived;
   }
}
