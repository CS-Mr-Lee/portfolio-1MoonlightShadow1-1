/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: ItenStatus class
 */
package com.culminating.utils;

import java.util.Date;

import org.json.simple.JSONObject;

import com.culminating.user.User;
import com.culminating.media.Media;

public class ItemStatus extends Log {

   /**
    * status of the ItemStatus
    */
   private boolean status;
    
   /**
    * renewTimes of the ItemStatus
    */
   private int renewTimes;

   /**
    * Default Constructor of ItemStatus, Initializes the attributes status and renewTimes    
    */
   public ItemStatus() {
    	super();
    	this.status = false;
    	this.renewTimes = -1;
   }

   /**
    * Constructor of ItemStatus
    * @param user, user of the ItemStatus
    * @param item, item of the ItemStatus
    * @param date, date of the ItemStatus
    * @param detail, detail of the ItemStatus
    * @param status, status of the ItemStatus
    * @param renewTimes, renewTimes of the ItemStatus
    */
   public ItemStatus(User user, Media item, Date date, String detail, boolean status, int renewTimes) {
    	super(user, item, date, detail);
    	this.status = status;
    	this.renewTimes = renewTimes;
   }
    
   /**
    * Description: Gets json object represent of this class object
    * 
    * @return jsonobject
    */
   public JSONObject getJSONObject() {
    	JSONObject obj = super.getJSONObject();
    	try {
    	    obj.put("status", this.status);
    	    obj.put("renewTimes", this.renewTimes);
    	} catch (Exception e) {
    	    System.out.println(e.getMessage());
    	}
    	return obj;
   }

   /**
    * Description: renew media for user
    * @param user, the user need to renew media
    */
   public void renew(User user) {
    	if (this.status == true) {return;}
         if (getUser().getName() != user.getName()) {return;}
         this.renewTimes++;
   }

   /**
    * Description: checkout media for user
    * @param user, the user need to checkout media
    * @param date, the date of checkout media
    */
   public void checkOut(User user, Date date) {
    	if (this.status == false) {return;}
         setUser(user);
         setDate(date);
         this.status = false;
   }

   /**
    * Description: checkin media for user
    * @param user, the user need to checkin media
    * @param date, the date of checkin media
    */
   public void checkIn(User user,Date date) {
    	if (this.status == false && getUser().getName() == user.getName()) {
         this.status = true;
         setUser(new User());
         setDate(new Date());
    	}
   }

   /**
    * Description: Gets the status of ItemStatus
    * @return the status of media
    */
   public boolean getStatus() {
    	return this.status;
   }

   /**
    * Description: Sets status of ItemStatus
    * @param status, the status of ItemStatus
    */
   public void setStatus(boolean status) {
    	this.status = status;
   }

   /**
    * Description: Gets the renewTimes of ItemStatus
    * @return the renewTimes of media
    */
   public int getRenewTimes() {
      return renewTimes;
   }

   /**
    * Description: Sets renewTimes of ItemStatus
    * @param renewTimes, the renewTimes of ItemStatus
    */
   public void setRenewTimes(int renewTimes) {
    	this.renewTimes = renewTimes;
   }

   /**
    * Description: prints all the attributes of the ItemStatus
    * @return String all the attributes of the ItemStatus
    */
   public String toString() {
      return super.toString() + "\nAvailable: " + this.status + "\nRenews: " + this.renewTimes;
   }
}
