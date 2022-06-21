/**
 *Name: Grace Sui
 *Date: 2022-05-04
 *Description: handler class
 */
package com.culminating.utils;

import com.culminating.user.Borrower;
import com.culminating.user.Librarian;
import com.culminating.user.User;
import com.culminating.media.Book;
import com.culminating.media.DVD;
import com.culminating.media.EBook;
import com.culminating.media.Media;
import com.culminating.media.VideoGames;
import com.culminating.payment.Fee;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Handler {

    /**
     *sharedInstance of handler class, single handler instance in system. 
     */
    private final static Handler sharedInstance = new Handler();
   
    public final static int maxRenewTimes = 3;
    public final static int maxCheckoutBooks = 3;

    /**
     * currHolds medias in system
     */
    private static ArrayList<ItemStatus> currHolds;
    
    /**
     * fines in system
     */
    private static ArrayList<Fee> fines;

    /**
     * currentCheckOuts medias in system
     */
    private static ArrayList<ItemStatus> currentCheckOuts;

    /**
     * users in system
     */
    private static ArrayList<User> users;

    /**
     * medias in system
     */
    private static ArrayList<Media> medias;

    /**
     * Default Constructor of Handler, Initializes the attributes currHolds,
     * fines, currentCheckOuts, medias and users from json files
     */
    private Handler() {
    	 this.currHolds = new ArrayList<ItemStatus>();
    	 this.fines = new ArrayList<Fee>();
    	 this.currentCheckOuts = new ArrayList<ItemStatus>();
    	 this.users = new ArrayList<User>();
    	 this.medias = new ArrayList<Media>();
    	 readUsersFromFile();  //read users from json file.
    	 readMediasFromFile(); //read medias from json file.    	         	
    	 readHoldMediasFromFile(); //read hold medias from json file.
    	 readCheckoutMediasFromFile();    //read checkout medias from json file.
    }

    /**
     * get the handler instance to make sure only one handler object instance in system.
     */
    public static Handler sharedInstance() {
    	 return sharedInstance;
    }

    /**
     * Find media in currentCheckOuts by user
     * 
     *@param user, user which checkout media.
     *@param media, media to find
     *@return -1 if doesn't find; index in the currentCheckOuts if find
     */
    public int searchCheckOutMedia(User user, Media media) {
    	 for (int i = 0; i < this.currentCheckOuts.size(); i++) {
    	    if (this.currentCheckOuts.get(i).getItem().getSIN() == media.getSIN() 
    	    	    && this.currentCheckOuts.get(i).getType().equals(media.getType())
    	    	    && this.currentCheckOuts.get(i).getUserName().equals(user.getName())) {
             return i;
          }
       }
       return -1;
    }
    
    /**
     * Find media in hold medias by user
     * 
     *@param user, user which hold the media.
     *@param media, media to find
     *@return -1 if doesn't find; index in the hold medias if find
     */
    public int searchHoldMediaItem(User user, Media media) {
    	for (int i = 0; i < this.currHolds.size(); i++) {
    	    if (this.currHolds.get(i).getItem().getSIN() == media.getSIN()
    	    	    && this.currHolds.get(i).getType().equals(media.getType())
    	    	    && this.currHolds.get(i).getUserName().equals(user.getName())) {
    	    	return i;
    	    }
    	}
    	return -1;
    }
   
    /**
     * Find first hold media in hold medias
     * 
     *@param media, media to find
     *@return -1 if doesn't find; index in the hold medias if find
     */
    public int searchFirstHoldMediaItem(Media media) {
    	for (int i = 0; i < this.currHolds.size(); i++) {
    	    if (this.currHolds.get(i).getItem().getSIN() == media.getSIN()
    	    	    && this.currHolds.get(i).getType().equals(media.getType())
    	    	    && !this.currHolds.get(i).getStatus()) {
    	    	return i;
    	    }
    	}
    	return -1;
    }
    
    /**
     * Find total hold media quantity in hold medias
     * 
     *@param media, media to find
     *@return 0 if doesn't find; total quantity in the hold medias if find
     */
    public int searchTotalHoldOnMedia(Media media) {
    	int total = 0;
    	for (int i = 0; i < this.currHolds.size(); i++) {
    	    if (this.currHolds.get(i).getItem().getSIN() == media.getSIN()
    	    	    && this.currHolds.get(i).getType().equals(media.getType())) {
    	    	total ++;
    	    }
    	}
    	return total;
    }

    /**
     * Add hold media in system
     * 
     *@param media, the hold media
     *@param user, the user which will hold the media
     *@return true if succeed, false if user already hold the media           
     */
    public boolean addHold(Media media, User user) {
    	boolean succeed = true;
    	int index = searchHoldMediaItem(user, media);
    	if (index == -1) {
    	    ItemStatus item = new ItemStatus(user, media, new Date(), "", false, 1);
    	    this.currHolds.add(item);
    	} else {
    	    succeed = false;
    	}
    	return succeed;
    }

    /**
     * remove hold media from user in system
     * 
     *@param media, the hold media
     *@param user, the user which hold the media
     *@return true if succeed, false if user doesn't hold the media           
     */
    public boolean removeHold(Media media, User user) {
    	boolean succeed = true;
    	int index = searchHoldMediaItem(user, media);
    	if (index == -1) {
    	    succeed = false;
    	} else {
    	    this.currHolds.remove(index);
    	}
    	
    	return succeed;
    }


    /**
     * Pay fee in system
     * 
     * @param fee, the fee need to be paid
     *            
     */
    public void payPenalty(Fee fee) {
    	for (int i = 0; i < fines.size(); i++) {
    	    // find the fee in fines by compare the name
    	    if (this.fines.get(i).getRecipient().getName().equals(fee.getRecipient().getName())) {
    	    	this.fines.get(i).pay();
    	    	this.fines.remove(i);
    	    	break;
    	    }
    	}
    }

    /**
     *renew media in system
     * 
     *@param user, the user need to be renewed
     *            
     *@param media, the media need to be renewed
     *            
     */
    public void renew(User user, Media media) {
    	int index = searchCheckOutMedia(user, media);
    	if (index == -1 || !currentCheckOuts.get(index).getUser().getName().equals(user.getName())) {
    	    return;
    	}
    	this.currentCheckOuts.get(index).renew(user);
    }

    /**
     *checkOut media from system
     * 
     *@param user, the user need to borrow media
     *            
     *@param media, the media need to be borrowed
     *
    *@return true if succeed, false if user doesn't checkout the media            
     */
    public boolean checkOut(User user, Media media) {
    	boolean succeed = true;
    	int index = searchCheckOutMedia(user, media);
    	if (index == -1) {
    	    ItemStatus item = new ItemStatus(user, media, new Date(), "", false, 1);
    	    this.currentCheckOuts.add(item);
    	} else {
    	    succeed = false;
    	}
    	
    	return succeed;

    }

    /**
     *checkin media to system
     * 
     *@param user, the user need to checkin media
     *            
     *@param media, the media need to be checkin
     *            
     */
    public void checkIn(User user, Media media) {
    	int index = searchCheckOutMedia(user, media);
    	if (index == -1) {
    	    return;
    	}
    	this.currentCheckOuts.get(index).checkIn(user, new Date());
    	this.currentCheckOuts.remove(index);
    	index = searchMedia(media);
    	if(index > -1) {
    	    this.medias.get(index).setCheckOutNumber(this.medias.get(index).getCheckOutNumber()-1);
    	}
    	index = searchFirstHoldMediaItem(media);
    	if(index > -1) {
    	    this.currHolds.get(index).setStatus(true);
    	}
    }

    /**
     *Find user in system
     * 
     *@param user, the user need to be found
     *@param ignorePassword, true don't need compare password; false, need compare password           
     *@return -1 if doesn't find; index in users if find.
     */
    public static int searchUser(User user, boolean ignorePassword) {
    	for (int i = 0; i < users.size(); i++) {
    	    if (user.getType().equals(users.get(i).getType())
    	    	    && users.get(i).getName().equals(user.getName())
    	    	    && (ignorePassword  || (!ignorePassword && users.get(i).getPassword()
    	    	    	    .equals(user.getPassword())))) {
    	    	return i;
    	    }
    	}
    	return -1;
    }

    /**
     *Find media in system
     * 
     *@param media, the media need to be found
     *@return -1 if doesn't find; index in medias if find.
     */       
    public static int searchMedia(Media media) {
    	for (int i = 0; i < medias.size(); i++) {
    	    if (media.getSIN() == medias.get(i).getSIN()
    	    	    && media.getType().equals(medias.get(i).getType())) {
    	    	return i;
    	    }
    	}
    	return -1;
    }
    /**
     *Add media in system
     * 
     *@param media, the media need to be added in system
     *            
     *@return true if succeed; false if already exist.
     */
    public boolean addMedia(Media media) {
    	boolean succeed = true;
    	int index = this.searchMedia(media);
    	if (index == -1) {
    	    this.medias.add(media);
    	} else {
    	    succeed = false;
    	}
    	return succeed;
    }

    /**
     * Add user in system
     * 
     * @param user, the user need to be added in system
     *            
     * @return true if succeed; false if already exist.
     */
    public boolean addUser(User user) {
    	boolean succeed = true;
    	int index = searchUser(user, true);
    	if (index == -1) {
    	    this.users.add(user);
    	} else {
    	    succeed = false;
    	}
    	return succeed;
    }

    /**
     *Update user in system
     * 
     *@param user, the user need to be updated in system
     *            
     *@return true if succeed; false if doesn't exist.
     */    
    public boolean updateUser(User user) {
    	boolean succeed = true;
    	int index = searchUser(user, true);
    	if (index == -1) {
    	    succeed = false;
    	} else {
    	    users.set(index, user);
    	}
    	return succeed;
    }

    /**
     *Update media in system
     * 
     *@param media, the media need to be updated in system
     *            
     *@return true if succeed; false if doesn't exist.
     */    
    public boolean updateMedia(Media media) {
    	boolean succeed = true;
    	int index = searchMedia(media);
    	if (index == -1) {
    	    succeed = false;
    	} else {
    	    medias.set(index, media);
    	}
    	return succeed;
    }

    /**
     *Remove user from system
     * 
     *@param user, the user need to be removed from system
     *            
     *@return true if succeed; false if doesn't exist.
     */
    public boolean removeUser(User user) {
    	boolean succeed = true;
    	int index = searchUser(user, true);
    	if (index == -1) {
    	    succeed = false;
    	} else {
    	    this.users.remove(index);
    	}
    	return succeed;
    }

    /**
     *Remove media from system
     * 
     *@param media, the media need to be removed from system
     *            
     *@return true if succeed; false if doesn't exist.
     */
    public boolean removeMedia(Media media) {
    	boolean succeed = true;
    	int index = searchMedia(media);
    	if (index == -1) {
    	    succeed = false;
    	} else {
    	    this.medias.remove(index);
    	}
    	return succeed;
    }

    /**
     *Description: Gets the currHolds
     * 
     *@return the currHolds
     */
    public ArrayList<ItemStatus> getCurrHolds() {
    	return currHolds;
    }

    /**
     * Description: Sets currHolds
     * 
     * @param currHolds, the currHolds
     *            
     */
    public void setCurrHolds(ArrayList<ItemStatus> currHolds) {
    	this.currHolds = currHolds;
    }

    /**
     *Description: Gets the fines
     * 
     *@return the fines
     */
    public ArrayList<Fee> getFines() {
    	return fines;
    }

    /**
     *Description: Sets fines
     * 
     *@param fines, the fines
     *            
     */
    public void setFines(ArrayList<Fee> fines) {
    	this.fines = fines;
    }

    /**
     *Description: Gets the current checkout media
     * 
     *@return the currentCheckOuts media in system
     */
    public ArrayList<ItemStatus> getCurrentCheckOuts() {
    	return currentCheckOuts;
    }

    /**
     *Description: Sets curent checkout media in system
     * 
     *@param currentCheckOuts, the current checkout medias
     *            
     */
    public void setCurrentCheckOuts(ArrayList<ItemStatus> currentCheckOuts) {
    	this.currentCheckOuts = currentCheckOuts;
    }

    /**
     *Description: Gets all users in system
     * 
     *@return user ArrayList in system
     */
    public static ArrayList<User> getUsers() {
    	return users;
    }

    /**
     *Description: Gets handler object instance in system
     * 
     *@return sharedInstance in system
     */
    public static Handler getSharedinstance() {
    	return sharedInstance;
    }

    /**
     *Description: Sets users in system
     * 
     *@param users, the users ArrayList
     *            
     */
    public void setUsers(ArrayList<User> users) {
    	this.users = users;
    }

    /**
     *Description: Gets all media in system
     * 
     *@return media ArrayList in system
     */
    public static ArrayList<Media> getMedias() {
    	return medias;
    }

    /**
     *Description: Sets media in system
     * 
     *@param medias, the media ArrayList
     *            
     */
    public void setMedias(ArrayList<Media> medias) {
    	this.medias = medias;
    }
   
    /**
     *Description: Save hold media in holdMedias.json file
     * 
     */
    public static void saveHoldMediaTofile() {
    	JSONArray jsonArray = new JSONArray();
    	for (int i = 0; i < currHolds.size(); i++) {
    	   jsonArray.add(currHolds.get(i).getJSONObject());
    	}
    	try (FileWriter file = new FileWriter("holdMedias.json")) {
    	   //We can write any JSONArray or JSONObject instance to the file
    	   file.write(jsonArray.toJSONString()); 
    	   file.flush();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	}
    }
    
    /**
     *Description: read hold media from holdMedias.json file
     * 
     */
    public static void readHoldMediasFromFile() {
    	//JSON parser object to parse read file
    	JSONParser jsonParser = new JSONParser();
    	try (FileReader reader = new FileReader("holdMedias.json")) {
    	   //Read JSON file
    	   Object obj = jsonParser.parse(reader); 
    	   JSONArray mediaList = (JSONArray) obj;
    	   //Iterate over media array
    	   for (int i = 0; i < mediaList.size(); i++) {
    	      parseHoldMediaObject((JSONObject)mediaList.get(i));                
    	   }
    	} catch (FileNotFoundException e) {
    	   e.printStackTrace();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	} catch (ParseException e) {
    	   e.printStackTrace();
    	}
    }

    /**
     *Description: parse hold media and save to curhold arraylist in system
     * 
     *@param holdMedia, the hold media JSONObject
     *            
     */
    private static void parseHoldMediaObject(JSONObject holdMedia) {
    	//Get status
    	Boolean status = (Boolean) holdMedia.get("status");
    	//Get author
    	String author = (String) holdMedia.get("author");    
    	//Get mediaName
    	String mediaName = (String) holdMedia.get("mediaName");  
    	//Get type
    	String type = (String) holdMedia.get("type");    
    	//Get userName
    	String userName = (String) holdMedia.get("userName");
    	int mediaSIN = ((Long)  holdMedia.get("mediaSIN")).intValue();
    	int renewTimes = ((Long) holdMedia.get("renewTimes")).intValue();
    	Long date = (Long)holdMedia.get("date");
    	int publishDateYear = ((Long) holdMedia.get("publishDateYear")).intValue();   
    	int publishDateMonth = ((Long)  holdMedia.get("publishDateMonth")).intValue();   
    	int publishDateDay = ((Long) holdMedia.get("publishDateDay")).intValue();
    	ItemStatus tempHoldMedia = new ItemStatus();
    	tempHoldMedia.setAuthor(author);;
    	tempHoldMedia.setDate(new Date(date));
    	tempHoldMedia.setMediaName(mediaName);
    	tempHoldMedia.setAuthor(author);;
    	tempHoldMedia.setMediaSIN(mediaSIN);
    	tempHoldMedia.setRenewTimes(renewTimes);
    	tempHoldMedia.setType(type);
    	tempHoldMedia.setStatus(status);
    	tempHoldMedia.setUserName(userName);
    	tempHoldMedia.setPublishDate(LocalDate.of(publishDateYear, publishDateMonth,publishDateDay));
    	User user = new User();
    	user.setName(userName);
    	user.setType("Borrower");
    	int index = searchUser(user, true);
    	if (index > -1) {
    	   user = getUsers().get(index);
    	   tempHoldMedia.setUser(user);
    	}
    	Media media = new Media();
    	media.setSIN(mediaSIN);
    	media.setName(mediaName);
    	media.setType(type);
    	index = searchMedia(media);
    	if (index > -1) {
    	   media = getMedias().get(index);
    	   tempHoldMedia.setItem(media);
    	}
    	currHolds.add(tempHoldMedia);
    }
    
    /**
     *Description: Save checkout medias in checkoutMedias.json file
     * 
     */
    public static void saveCheckoutsMediaTofile() {
    	JSONArray jsonArray = new JSONArray();
    	for (int i = 0; i < currentCheckOuts.size(); i++) {
    	   jsonArray.add(currentCheckOuts.get(i).getJSONObject());
    	}
    	try (FileWriter file = new FileWriter("checkoutMedias.json")) {
    	   //write any JSONArray and JSONObject instance to the file
    	   file.write(jsonArray.toJSONString()); 
    	   file.flush();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	}
    }
    
    /**
     *Description: read checkout media from checkoutMedias.json file
     * 
     */   
    public static void readCheckoutMediasFromFile() {
    	//JSON parser object to parse read file
    	JSONParser jsonParser = new JSONParser();
         
    	try (FileReader reader = new FileReader("checkoutMedias.json")) {
    	   //Read JSON file
    	   Object obj = jsonParser.parse(reader); 
    	   JSONArray mediaList = (JSONArray) obj;
    	   //Iterate over media array
    	   for (int i = 0; i < mediaList.size(); i++) {
    	      parseCheckoutMediaObject((JSONObject)mediaList.get(i));
    	   }
    	} catch (FileNotFoundException e) {
    	   e.printStackTrace();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	} catch (ParseException e) {
    	   e.printStackTrace();
    	}
    }
    
    /**
     *Description: parse checkout media and save to currentCheckOuts arraylist in system
     * 
     *@param checkoutMedia, the checkoutMedia JSONObject
     *            
     */
    private static void parseCheckoutMediaObject(JSONObject checkoutMedia) {
    	//Get status
    	Boolean status = (Boolean) checkoutMedia.get("status");
    	//Get author
    	String author = (String) checkoutMedia.get("author");    
    	//Get mediaName
    	String mediaName = (String) checkoutMedia.get("mediaName");  
    	//Get type
    	String type = (String) checkoutMedia.get("type");    
    	//Get userName
    	String userName = (String) checkoutMedia.get("userName");
    	int mediaSIN = ((Long)  checkoutMedia.get("mediaSIN")).intValue();
    	int renewTimes = ((Long) checkoutMedia.get("renewTimes")).intValue();
    	Long date = (Long)checkoutMedia.get("date");
    	int publishDateYear = ((Long) checkoutMedia.get("publishDateYear")).intValue();   
    	int publishDateMonth = ((Long)  checkoutMedia.get("publishDateMonth")).intValue();   
    	int publishDateDay = ((Long) checkoutMedia.get("publishDateDay")).intValue();
    	ItemStatus tempHoldMedia = new ItemStatus();
    	tempHoldMedia.setAuthor(author);;
    	tempHoldMedia.setDate(new Date(date));
    	tempHoldMedia.setMediaName(mediaName);
    	tempHoldMedia.setAuthor(author);;
    	tempHoldMedia.setMediaSIN(mediaSIN);
    	tempHoldMedia.setRenewTimes(renewTimes);
    	tempHoldMedia.setType(type);
    	tempHoldMedia.setStatus(status);
    	tempHoldMedia.setUserName(userName);
    	tempHoldMedia.setPublishDate(LocalDate.of(publishDateYear, publishDateMonth,publishDateDay));
    	User user = new User();
    	user.setName(userName);
    	user.setType("Borrower");
    	int index = searchUser(user, true);
    	if (index > -1) {
    	    user = getUsers().get(index);
    	    tempHoldMedia.setUser(user);
    	}
    	Media media = new Media();
    	media.setSIN(mediaSIN);
    	media.setName(mediaName);
    	media.setType(type);
    	index = searchMedia(media);
    	if (index > -1) {
    	    media = getMedias().get(index);
    	    tempHoldMedia.setItem(media);
    	}
    	currentCheckOuts.add(tempHoldMedia);
    }

    /**
     *Description: Save medias in medias.json file
     * 
     */
    public static void saveMediasTofile() {
    	JSONArray jsonArray = new JSONArray();
    	for (int i = 0; i < getMedias().size(); i++) {
    	   jsonArray.add(getMedias().get(i).getJSONObject());
    	}
    	try (FileWriter file = new FileWriter("medias.json")) {
    	   //We can write any JSONArray or JSONObject instance to the file
    	   file.write(jsonArray.toJSONString()); 
    	   file.flush();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	}
    }
    
    /**
     *Description: read medias from medias.json file
     * 
     */     
    public static void readMediasFromFile() {
    	//JSON parser object to parse read file
    	JSONParser jsonParser = new JSONParser();
         
    	try (FileReader reader = new FileReader("medias.json")) {
    	   //Read JSON file
    	   Object obj = jsonParser.parse(reader); 
    	   JSONArray mediaList = (JSONArray) obj;
    	   //Iterate over media array
    	   for (int i = 0; i < mediaList.size(); i++) {
    	      parseMediaObject((JSONObject)mediaList.get(i));                
    	   }             
    	} catch (FileNotFoundException e) {
    	   e.printStackTrace();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	} catch (ParseException e) {
    	   e.printStackTrace();
    	}
    }
    
    /**
     *Description: parse media and save to medias arraylist in system
     * 
     *@param media, the media JSONObject
     *            
     */
    private static void parseMediaObject(JSONObject media) {
    	//Get user name
    	String name = (String) media.get("name");
    	//Get user address
    	String author = (String) media.get("author");    
    	//Get user password
    	String language = (String) media.get("language");  
    	//Get user type
    	String type = (String) media.get("type");    
    	//Get user gender
    	String publisher = (String) media.get("publisher");
    	int SIN = ((Long)  media.get("sin")).intValue();
    	//Get user type
    	String ageRating = (String) media.get("ageRating");
    	String genre = (String) media.get("genre");
    	int checkOutNumber = ((Long) media.get("checkOutNumber")).intValue();
    	int totalNumber = ((Long)  media.get("totalNumber")).intValue();
    	String imagePath = (String) media.get("imagePath");
    	String description = (String) media.get("description");
    	int publishDateYear = ((Long) media.get("publishDateYear")).intValue();   
    	int publishDateMonth = ((Long)  media.get("publishDateMonth")).intValue();   
    	int publishDateDay = ((Long) media.get("publishDateDay")).intValue();
    	Media tempMedia;
    	if (type.equals("Book")) {
    	   tempMedia = new Book();
    	} else if (type.equals("DVD")){
    	   tempMedia = new DVD();
    	} else if (type.equals("EBook")){
    	   tempMedia = new EBook();
    	} else {
    	   tempMedia = new VideoGames();
    	}
    	tempMedia.setName(name);
    	tempMedia.setSIN(SIN);
    	tempMedia.setAgeRating(ageRating.charAt(0));
    	tempMedia.setAuthor(author);;
    	tempMedia.setCheckOutNumber(checkOutNumber);
    	tempMedia.setTotalNumber(totalNumber);
    	tempMedia.setType(type);
    	tempMedia.setDescription(description);
    	tempMedia.setGenre(genre);
    	tempMedia.setImagePath(imagePath);
    	tempMedia.setLanguage(language);
    	tempMedia.setPublisher(publisher);
    	tempMedia.setPublishDate(LocalDate.of(publishDateYear, publishDateMonth,publishDateDay));
    	medias.add(tempMedia);
    }

    /**
     *Description: Save users in users.json file
     * 
     */
    public static void saveUsersTofile() {
    	JSONArray jsonArray = new JSONArray();
    	for (int i = 0; i < getUsers().size(); i++) {
    	   jsonArray.add(getUsers().get(i).getJSONObject());
    	}
    	try (FileWriter file = new FileWriter("users.json")) {
    	   //We can write any JSONArray or JSONObject instance to the file
    	   file.write(jsonArray.toJSONString()); 
    	   file.flush();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	}
    }
    
    /**
     *Description: read users from users.json file
     * 
     */       
    public static void readUsersFromFile() {
    	//JSON parser object to parse read file
    	JSONParser jsonParser = new JSONParser();
         
    	try (FileReader reader = new FileReader("users.json")) {
    	   //Read JSON file
    	   Object obj = jsonParser.parse(reader); 
    	   JSONArray userList = (JSONArray) obj;
    	   //Iterate over user array
    	   for (int i = 0; i < userList.size(); i++) {
    	    	parseUserObject((JSONObject)userList.get(i));                
    	   } 
            
    	} catch (FileNotFoundException e) {
    	   e.printStackTrace();
    	} catch (IOException e) {
    	   e.printStackTrace();
    	} catch (ParseException e) {
    	   e.printStackTrace();
    	}
    }

    /**
     *Description: parse user and save to users arraylist in system
     * 
     *@param user, the user JSONObject
     *            
     */
    private static void parseUserObject(JSONObject user) {
    	//Get user name
    	String name = (String) user.get("name");
    	//Get user address
    	String address = (String) user.get("address");    
    	//Get user password
    	String password = (String) user.get("password");  
    	//Get user type
    	String type = (String) user.get("type");   
    	//Get user gender
    	String gender = (String) user.get("gender");
    	int birthDateYear = ((Long) user.get("birthDateYear")).intValue();   
    	int birthDateMonth = ((Long)  user.get("birthDateMonth")).intValue();   
    	int birthDateDay = ((Long) user.get("birthDateDay")).intValue();
    	User tempUser;
    	if (type.equals("Borrower")) {
    	   tempUser = new Borrower();
    	} else {
    	   tempUser = new Librarian();
    	}
    	tempUser.setName(name);
    	tempUser.setAddress(address);
    	tempUser.setGender(gender);
    	tempUser.setPassword(password);
    	tempUser.setType(type);
    	tempUser.setBirthDate(LocalDate.of(birthDateYear, birthDateMonth,birthDateDay));
    	users.add(tempUser);
    }

    /**
     * Returns description of the handler.
     *
     */
    public String toString() {
    	return "This is the handler class to handle the actions";
    }
}