/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: Library class
 */
package com.culminating.utils;

import java.util.ArrayList;

import com.culminating.media.Media;

public class Library {

   /**
    * address of the Library
    */
   private String address;
    
   /**
    * collection of the Library
    */
   private ArrayList<Media> collection;
    
   /**
    * phoneNumber of the Library
    */
   private String phoneNumber;
    
   /**
    * numConferenceRooms of the Library
    */
   private int numConferenceRooms;
    
   /**
    * wifiPwd of the Library
    */
   private String wifiPwd;
    
   /**
    * name of the Library
    */
   private String name;

   /**
    * Default Constructor of Library    
    */
   public Library() {
   }

   /**
    * Constructor of Library
    * @param name, Name of the Library
    * @param address, address of the Library
    * @param collection, collection of the Library
    * @param phoneNumber, phoneNumber of the Library
    * @param numConferenceRooms, numConferenceRooms of the Library
    * @param wifiPwd, wifiPwd of the Library
    */
   public Library(String name, String address, ArrayList<Media> collection, String phoneNumber, int numConferenceRooms, String wifiPwd) {
    	this.name = name;
    	this.address = address;
    	this.collection = collection;
    	this.phoneNumber = phoneNumber;
    	this.numConferenceRooms = numConferenceRooms;
    	this.wifiPwd = wifiPwd;
   }

   /**
    * Description: Gets the address of Library
    * @return the address of Library
    */
   public String getAddress() {
    	return this.address;
   }

   /**
    * Description: Sets address of Library
    * @param address, the address of Library
    */
   public void setAddress(String address) {
   	this.address = address;
   }

   /**
    * Description: Gets the collection of Library
    * @return the collection of Library
    */
   public ArrayList<Media> getCollection() {
    	return this.collection;
   }

   /**
    * Description: Sets collection of Library
    * @param collection, the collection of Library
    */
   public void setCollection(ArrayList<Media> collection) {
    	this.collection = collection;
   }

   /**
    * Description: Gets the phoneNumber of Library
    * @return the phoneNumber of Library
    */
   public String getPhoneNumber() {
    	return this.phoneNumber;
   }

   /**
    * Description: Sets phoneNumber of Library
    * @param phoneNumber, the phoneNumber of Library
    */
   public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
   }

   /**
    * Description: Gets the numConferenceRooms of Library
    * @return the numConferenceRooms of Library
    */
   public int getNumConferenceRooms() {
    	return this.numConferenceRooms;
   }

   /**
    * Description: Sets numConferenceRooms of Library
    * @param numConferenceRooms, the numConferenceRooms of Library
    */
   public void setNumConferenceRooms(int numConferenceRooms) {
    	this.numConferenceRooms = numConferenceRooms;
   }

   /**
    * Description: Gets the wifiPwd of Library
    * @return the wifiPwd of Library
    */
   public String getWifiPwd() {
    	return this.wifiPwd;
   }

   /**
    * Description: Sets wifiPwd of Library
    * @param wifiPwd, the wifiPwd of Library
    */
   public void setWifiPwd(String wifiPwd) {
    	this.wifiPwd = wifiPwd;
   }

   /**
    * Description: prints the attributes of the Library
    * @return String all the attributes of the Library
    */
   @Override
   public String toString() {
    	return this.name;
   }

   /**
    * Description: Gets the name of Library
    * @return the name of Library
    */
   public String getName() {
    	return name;
   }

   /**
    * Description: Sets name of Library
    * @param name, the name of Library
    */
   public void setName(String name) {
    	this.name = name;
   }

}
