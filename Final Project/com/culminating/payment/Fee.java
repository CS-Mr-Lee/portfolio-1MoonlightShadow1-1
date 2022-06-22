/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: fee class
 */

//packages the fee into com.culminating.payment
package com.culminating.payment;

//imports Date, Media and User
import java.util.Date;
import com.culminating.media.Media;
import com.culminating.user.User;

public class Fee {
    /**
     * the recipient of the fee
     */
    private User recipient;
    
    /**
     * the item the fee belongs to
     */ 
    private Media[] item; 
    
    /**
     * the amount of fee
     */
    private double amount; 
    
    /**
     * the date the fee is due
     */
    private Date date;
    
    /**
     * the details of the fee
     */ 
    private String details; 
    
    /**
     * whether or not the fee has been fulfilled
     */
    private boolean fulfilled; 

    /**
     * default constructor a fee: call superclass payment
     * sets recipient to new User()
     * sets item = new Media[1] to new Media()
     * sets the amount to -6.9
     * sets the date to new Date()
     * sets the details to ""
     * sets fulfilled to false
     */
    public Fee() {
        this.recipient = new User();
        (this.item = new Media[1])[0] = new Media();
        this.amount = -6.9;
        this.date = new Date();
        this.details = "";
        this.fulfilled = false;
    }

    /**
     * Constructor a fee: sets recipient, item, amount, date, details, and fulfilled from parameters
     * @param recipient, the recipient of the fee
     * @param item, the item the fee belongs to
     * @param amount, the amount of the fee
     * @param date, the date the fee is due
     * @param details, the details of the fee
     * @param fulfilled, whether or not the fee is fulfilled
     */
    public Fee(User recipient, Media[] item, double amount, Date date, String details,
            boolean fulfilled) {
        this.recipient = recipient;
        this.item = item;
        this.amount = amount;
        this.date = date;
        this.details = details;
        this.fulfilled = fulfilled;
    }
    
    /**
     * Description: Gets the recipient of fee
     * @return the recipient of fee
     */    
    public User getRecipient() {
        return recipient;
   }

   /**
    * Description: Sets recipient of fee
    * @param recipient, the recipient of fee
    */
   public void setRecipient(User recipient) {
       this.recipient = recipient;
   }

   /**
     * Description: Gets the media item of fee
     * @return the media item of fee
     */ 
   public Media[] getItem() {
       return item;
   }

   /**
    * Description: Sets item of fee
    * @param item, the item of fee
    */
   public void setItem(Media[] item) {
       this.item = item;
   }

   /**
    * Description: Gets the amount of fee
    * @return the amount of fee
    */
   public double getAmount() {
       return amount;
   }

   /**
    * Description: Sets amount of fee
    * @param amount, the amount of fee
    */
   public void setAmount(double amount) {
       this.amount = amount;
   }

   /**
    * Description: Gets the date of fee
    * @return the date of fee
    */
   public Date getDate() {
      return date;
   }

   /**
    * Description: Sets date of fee
    * @param date, the date of fee
    */
   public void setDate(Date date) {
       this.date = date;
   }

   /**
    * Description: Gets the details of fee
    * @return the details of fee
    */
   public String getDetails() {
       return details;
   }

   /**
    * Description: Sets details of fee
    * @param details, the details of fee
    */
   public void setDetails(String details) {
       this.details = details;
   }

   /**
    * Description: Gets the fulfilled of fee
    * @return the fulfilled of fee
    */
   public boolean isFulfilled() {
       return fulfilled;
   }

   /**
    * Description: Sets fulfilled of fee
    * @param fulfilled, the fulfilled of fee
    */
   public void setFulfilled(boolean fulfilled) {
       this.fulfilled = fulfilled;
   }

   /**
    * Description: turns fulfilled to true 
    */
   public void pay() {
       this.fulfilled = true;
   }
    
   /**
    * Description: prints the attributes of the fee
    * @return String the attributes of the fee
    */
   @Override
   public String toString() {
      String items = "";
      for (int i = 0; i < this.item.length; i++) {
          items += this.item[i].toString() + ",";
      }
      items = items.substring(0, items.length() - 1);
      String fee = "Recipient: " + this.recipient + "\nItem(s): " + items + "\nAmount: " + this.amount + "\nDate: "
              + this.date + "\nDescription: " + this.details + "\nFulfilled: " + this.fulfilled;
      return fee;
   }
}
