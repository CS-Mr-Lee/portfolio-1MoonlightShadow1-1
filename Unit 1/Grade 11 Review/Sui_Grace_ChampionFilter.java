/**
Name: Grace
Date: 2022-02-10
Description:Read the file at https://github.com/ngryman/lol-champions/blob/master/champions.json. 
            In the file, MaxChampStats.txt, write out in separate lines:
            a) the name and hp of the champion with the highest hp
            b) the name and armor of the champion with the lowest armor
*/

import java.lang.*;
import java.util.Scanner;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Sui_Grace_ChampionFilter {
   public static void main (String [] args) {
      JSONParser parser = new JSONParser();
      try {
          //read information from champions.json and save it to jsonArray
          JSONArray personArray = (JSONArray) parser.parse(new FileReader("champions.json"));
          double minArmor = Double.MAX_VALUE;
          double maxHp = Double.MIN_VALUE;
          String minArmorName = "";
          String maxHpName = "";
          //continue read the personArray until end of the personArray
          for (Object person : personArray) {
              //cast the current jsonArray to JSONObject person
              JSONObject currentPerson = (JSONObject) person;
              //get current person name 
              String currentName = (String) currentPerson.get("name");
               
              double currentHp = 0;
              double currentArmor = 0;
              //get current stat and save to JSONObject stats               
              JSONObject stats = (JSONObject) currentPerson.get("stats");
              //get current hp value from stats 
              Object tempHp = stats.get("hp");
              //get current armor value from stats
              Object tempArmor = stats.get("armor");
              //convert hp value to double value and save to currentHp
              if (tempHp instanceof Long) {
                  currentHp = ((Long)tempHp).doubleValue();
              } else {
                  currentHp = (Double)tempHp;
              }
              //convert Armor value to double value and save to currentArmor
              if (tempArmor instanceof Long) {
                  currentArmor = ((Long)tempArmor).doubleValue();
              } else {
                  currentArmor = (Double)tempArmor;
              }
              //set maxHp and MaxHpName to currentHp when maxHp less than currentHp
              if (maxHp < currentHp) {
                  maxHp = currentHp;
                  maxHpName = currentName;
              }
              //set minArmor and minArmorName to currentHp when minArmor bigger than currentArmor
              if (minArmor > currentArmor) {
                  minArmor = currentArmor;
                  minArmorName = currentName;
              }
              System.out.println("Hp::Armor:" + currentHp + "   " + currentArmor);
           }
           System.out.println("The name is " +  maxHpName + " and hp is " + maxHp +" of the champion with the highest hp");
           System.out.println("The name is " +  minArmorName + " and armor is " + minArmor +" of the champion with with the lowest armor");
      
           //write out a) the name and hp of the champion with the highest hp and b) the name and armor of the champion with the lowest armor to file MaxChampStats.txt
           writeToFile("MaxChampStats.txt",maxHpName, minArmorName, maxHp, minArmor);
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       } catch (IOException e) {
           System.out.println(e.getMessage());
       } catch (org.json.simple.parser.ParseException e) {
           System.out.println(e.getMessage());
       }
    }
    /**
    Description: method writeToFile --> write out below information to file MaxChampStats.txt, 
                 in separate lines:
            a) the name and hp of the champion with the highest hp
            b) the name and armor of the champion with the lowest armor
    @param String fileName: the output file name 
           String maxHpName: the name of the champion with the highest hp
           String minArmorName: the name of the champion with the lowest armor 
           double maxHp: the hp of the champion with the highest hp
           double minArmor: the armor of the champion with the lowest armor        
    return: 
    */ 
    public static void writeToFile(String fileName, String maxHpName, String minArmorName, double maxHp, double minArmor) {
       try {
          //create file if the file no exist
          File myFile = new File(fileName);
          if (myFile.createNewFile()) {
             System.out.println("File created: " + myFile.getName());
          } else {
             System.out.println("File already exists.");
          }
            
          //Open a FileWriter to write max hp and min armor.
          FileWriter file = new FileWriter(fileName);

          //Creates a BufferedWriter to write max hp and min armor
          BufferedWriter output = new BufferedWriter(file);
          output.write("The name is " +  maxHpName + " and hp is " + maxHp +" of the champion with the highest hp");
          output.newLine();
          output.write("The name is " +  minArmorName + " and armor is " + minArmor +" of the champion with with the lowest armor");
          output.newLine();
          output.flush();

          //Closes the file
          output.close();
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
   }
}