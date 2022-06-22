/**
* Name(s): Franklin, Mike, Grace, Sophia
* Date: 2022-05-04
* Description: media class
*/

//packages media in com.culminating.media
package com.culminating.media;

//imports ArrayList and Date
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.simple.JSONObject;

//imports library class
import com.culminating.utils.Library;

public class Media {
    /**
     * the date of publication of the media
     */
    private LocalDate publishDate; 
    
    /**
     * the author of the media's name
     */	
    private String author; 
    
    /**
     * the SIN of the media
     */
    private int SIN; 
    
    /**
     * the language the media is in
     */
    private String language; 
    
    /**
     * the media's publisher's name
     */
    private String publisher; 
    
    /**
     * the age rating of the media
     */
    private Character ageRating; 
    
    /**
     * the genre of the media
     */
    private String genre; 
	
    /**
     * the name of the media
     */
    private String name;
    
    /**
     * the checkOutNumber of the media
     */
    private int checkOutNumber;
    
    /**
     * the totalNumber of the media
     */
    private int totalNumber;
    
    /**
     * the imagePath of the media
     */
    private String imagePath;
    
    /**
     * the description of the media
     */
    private String description;
    
    /**
     * the type of the media
     */
    private String type;

    /**
     * default constructor a media 
     * sets publishDate to new Date()
     * sets author to ""
     * sets SIN to -1
     * sets language to ""
     * sets publisher to ""
     * sets ageRating to 0
     * sets genre to ""
     */
    public Media() {
        this.author = "";
        this.SIN = -1;
        this.language = "";
        this.publisher = "";
        this.ageRating = 0;
        this.genre = "";
    }

    /**
     * Constructor a media: sets publishDate, author, SIN, language, publisher, ageRating, and genre from parameters
     * @param publishDate, the media's date of publication 
     * @param author, the media's author's name
     * @param SIN, the SIN of the media
     * @param language, the language the media is in
     * @param publisher, the publisher of the media
     * @param ageRating, the age rating of the media
     * @param genre, the genre of the media
     */
    public Media(String name, LocalDate publishDate, String author, int SIN, String language,
            String publisher, Character ageRating, String genre, int checkOutNumber, int totalNumber, String imagePath, String description) {
        this.publishDate = publishDate;
        this.author = author;
        this.SIN = SIN;
        this.language = language;
        this.publisher = publisher;
        this.ageRating = ageRating;
        this.genre = genre;
        this.checkOutNumber = checkOutNumber;
        this.totalNumber = totalNumber;
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
    }
    
    /**
     * Description: Gets json object represent of this class object
     * 
     * @return jsonobject
     */
    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("name", this.name);
            obj.put("sin", this.SIN);
            obj.put("publisher", this.publisher);
            obj.put("checkOutNumber", this.checkOutNumber);
            obj.put("publishDateYear", this.publishDate.getYear());
            obj.put("publishDateMonth", this.publishDate.getMonthValue());
            obj.put("publishDateDay", this.publishDate.getDayOfMonth());
            obj.put("type", this.type);
            obj.put("author", this.author);
            obj.put("ageRating", String.valueOf(this.ageRating));
            obj.put("language", this.language);
            obj.put("description", this.description);
            obj.put("imagePath", this.imagePath);
            obj.put("totalNumber", this.totalNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    /**
     * Adds current item to the library collection
     * 
     * @param library, library to receive a new media
     */
    public void transfer(Library library) {
        ArrayList<Media> tempMedia = (ArrayList<Media>) library.getCollection();
        tempMedia.add(this);
        library.setCollection(tempMedia);
    }    
        
    /**
     * Description: gets the date of publication
     * @return Date publishDate of media
     */
    public LocalDate getPublishDate() {
        return this.publishDate;
    }
        
    /**
     * Description: sets the publication date
     * @param publishDate, the media's date of publication
     */
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
        
    /**
     * Description: gets the Author's name
     * @return String author of media
     */
    public String getAuthor() {
        return this.author;
    }
        
    /**
     * Description: sets the name of the author
     * @param author, the media's author's name 
     */
    public void setAuthor(String author) {
        this.author = author;
    }
        
    /**
     * Description: gets the SIN 
     * @return int SIN of the media
     */
    public int getSIN() {
        return this.SIN;
    }
        
    /**
     * Description: sets the SIN
     * @param SIN, the unique identity of the media
     */
    public void setSIN(int SIN) {
        this.SIN = SIN;
    }
        
    /**
     * Description: gets the language
     * @return String language of the media
     */
    public String getLanguage() {
        return this.language;
    }
        
    /**
     * Description: sets the language
     * @param language, the language of the media
     */
    public void setLanguage(String language) {
        this.language = language;
    }
        
    /**
     * Description: gets the publisher's name
     * @return String publisher of the media
     */
    public String getPublisher() {
        return this.publisher;
    }
        
    /**
     * Description: sets the publisher's name 
     * @param publisher, the publisher's name
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
        
    /**
     * Description: gets the age rating
     * @return Character ageRating of the media
     */
    public Character getAgeRating() {
        return this.ageRating;
    }
        
    /**
     * Description: sets the age rating
     * @param ageRating, the age rating of the media
     */
    public void setAgeRating(Character ageRating) {
        this.ageRating = ageRating;
    }
        
    /**
     * Description: gets the genre
     * @return String genre of the media
     */
    public String getGenre() {
        return this.genre;
    }
        
    /**
     * Description: sets the genre
     * @param genre, the genre of the media
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Description: Gets the name of media
     * @return the name of media
     */
    public String getName() {
       return name;
    }

    /**
     * Description: sets the name
     * @param name, the name of the media
     */
    public void setName(String name) {
       this.name = name;
    }

    /**
     * Description: Gets the checkOutNumber of media
     * @return the checkOutNumber of media
     */
    public int getCheckOutNumber() {
       return checkOutNumber;
    }

    /**
     * Description: Sets checkOutNumber of media
     * @param checkOutNumber, the checkOutNumber of media
     */ 
    public void setCheckOutNumber(int checkOutNumber) {
       this.checkOutNumber = checkOutNumber;
    }

    /**
     * Description: Gets the totalNumber of media
     * @return the totalNumber of media
     */
    public int getTotalNumber() {
       return totalNumber;
    }

    /**
     * Description: Sets totalNumber of media
     * @param totalNumber, the totalNumber of media
     */ 
    public void setTotalNumber(int totalNumber) {
       this.totalNumber = totalNumber;
    }

    /**
     * Description: Gets the imagePath of media
     * @return the imagePath of media
     */
    public String getImagePath() {
       return imagePath;
    }

    /**
     * Description: Sets imagePath of media
     * @param imagePath, the imagePath of media
     */ 
    public void setImagePath(String imagePath) {
       this.imagePath = imagePath;
    }

    /**
     * Description: prints all the attributes of the media
     * @return String all the attributes of the media
     */
    @Override
    public String toString() {
        return "{" +
                " publishDate='" + getPublishDate() + "'" +
                ", author='" + getAuthor() + "'" +
                ", SIN='" + getSIN() + "'" +
                ", language='" + getLanguage() + "'" +
                ", publisher='" + getPublisher() + "'" +
                ", ageRating='" + getAgeRating() + "'" +
                ", genre='" + getGenre() + "'" +
                "}";
    }

    /**
     * Description: Gets the description of media
     * @return the description of media
     */
    public String getDescription() {
       return description;
    }

    /**
     * Description: Sets description of media
     * @param description, the description of media
     */ 
    public void setDescription(String description) {
       this.description = description;
    }

    /**
     * Description: Gets the type of media
     * @return the type of media
     */
    public String getType() {
       return type;
    }

    /**
     * Description: Sets type of media
     * @param type, the type of media
     */ 
    public void setType(String type) {
       this.type = type;
    }
}
