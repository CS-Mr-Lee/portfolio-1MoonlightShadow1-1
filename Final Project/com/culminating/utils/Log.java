/**
*Name(s): Franklin, Mike, Grace, Sophia
*Date: 2022-05-04
*Description: Log class
*/
package com.culminating.utils;

import java.time.LocalDate;
import java.util.Date;

import org.json.simple.JSONObject;

import com.culminating.media.Media;
import com.culminating.user.User;

public class Log {

    /**
     * user of the Log
     */
    private User user;
   
    /**
     * media item of the Log
     */
    private Media item;
   
    /**
     * date of the Log
     */
    private Date date;
   
    /**
     * detail of the Log
     */
    private String detail;
    
    /**
     * userName of the Log
     */
    private String userName;
    
    /**
     * mediaName of the Log
     */
    private String mediaName;
    
    /**
     * mediaSIN of the Log
     */
    private int mediaSIN;
    
    /**
     * author of the Log
     */
    private String author;
    
    /**
     * type of the Log
     */
    private String type;
    
    /**
     * publishDate of the Log
     */
    private LocalDate publishDate;

    /**
     * Default Constructor of Log, Initializes the attributes user, item, age, date and detail    
     */
    public Log() {
       this.user = new User();
       this.item = new Media();
       this.date = new Date();
       this.detail = "";
    }

    /**
     * Constructor of Log
     * @param user, user of the Log
     * @param item, address of the Log
     * @param date, age of the Log
     * @param detail, gender of the Log
     */
    public Log(User user, Media item, Date date, String detail) {
     	 this.user = user;
       this.item = item;
       this.date = date;
       this.detail = detail;
       this.userName = user.getName();
       this.mediaName = item.getName();
       this.mediaSIN = item.getSIN();
       this.author = item.getAuthor();
       this.type = item.getType();
       this.publishDate = item.getPublishDate();
        
    }

    /**
     *Description: Gets json object represent of this class object
     * 
     *@return jsonobject
     */
    public JSONObject getJSONObject() {
       JSONObject obj = new JSONObject();
       try {
          obj.put("detail", this.detail);
          obj.put("userName", this.userName);
          obj.put("mediaName", this.mediaName);
          obj.put("date", this.date.getTime());
          obj.put("type", this.type);
          obj.put("author", this.author);
          obj.put("mediaSIN", this.mediaSIN);
          obj.put("publishDateYear", this.publishDate.getYear());
          obj.put("publishDateMonth", this.publishDate.getMonthValue());
          obj.put("publishDateDay", this.publishDate.getDayOfMonth());
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
      return obj;
    }

    /**
     * Description: Gets the user of log
     * @return the user of log
     */
     public User getUser() {
        return this.user;
     }

    /**
     * Description: Sets user of log
     * @param user, the user of log
     */ 
    public void setUser(User user) {
       this.user = user;
    }

    /**
    * Description: Gets the item of log
    * @return the item of log
    */
    public Media getItem() {
       return this.item;
    }

    /**
     * Description: Sets item of log
     * @param item, the item of log
     */ 
    public void setItem(Media item) {
       this.item = item;
    }

    /**
    * Description: Gets the date of log
    * @return the date of log
    */
    public Date getDate() {
       return this.date;
    }

    /**
     * Description: Sets date of log
     * @param date, the date of log
     */ 
    public void setDate(Date date) {
       this.date = date;
    }

    /**
     * Description: Gets the detail of log
     * @return the detail of log
     */
    public String getDetail() {
       return this.detail;
    }

    /**
     * Description: Sets detail of log
     * @param detail, the detail of log
     */ 
    public void setDetail(String detail) {
       this.detail = detail;
    }

    /**
    * Description: Gets the userName of log
    * @return the userName of log
    */
    public String getUserName() {
       return user.getName();
    }

    /**
     * Description: Sets userName of log
     * @param userName, the userName of log
     */ 
    public void setUserName(String userName) {
       this.userName = userName;
    }

    /**
     * Description: Gets the mediaName of log
     * @return the mediaName of log
     */
    public String getMediaName() {
       return item.getName();
    }

    /**
     * Description: Sets mediaName of log
     * @param mediaName, the mediaName of log
     */ 
    public void setMediaName(String mediaName) {
       this.mediaName = mediaName;
    }

    /**
     * Description: Gets the mediaSIN of log
     * @return the mediaSIN of log
     */
    public int getMediaSIN() {
       return item.getSIN();
    }

    /**
     * Description: Sets mediaSIN of log
     * @param mediaSIN, the mediaSIN of log
     */ 
    public void setMediaSIN(int mediaSIN) {
       this.mediaSIN = mediaSIN;
    }

    /**
     * Description: Gets the author of log
     * @return the author of log
     */
    public String getAuthor() {
       return item.getAuthor();
    }

    /**
     * Description: Sets author of log
     * @param author, the author of log
     */ 
    public void setAuthor(String author) {
       this.author = author;
    }

    /**
    * Description: Gets the type of log
    * @return the type of log
    */
    public String getType() {
       return item.getType();
    }

    /**
     * Description: Sets type of log
     * @param type, the type of log
     */ 
    public void setType(String type) {
       this.type = type;
    }

    /**
     * Description: Gets the publishDate of log
     * @return the publishDate of log
     */
    public LocalDate getPublishDate() {
       return item.getPublishDate();
    }

    /**
     * Description: Sets publishDate of log
     * @param publishDate, the publishDate of log
     */ 
    public void setPublishDate(LocalDate publishDate) {
       this.publishDate = publishDate;
    }

    /**
     *Description: prints the attributes of the log
     */
    public String toString() {
       return "User: " + this.user.toString() + "\nItem: " + this.item.toString() + "\nDate: " + this.date
               + "\nDescription: " + this.detail;
    }

}