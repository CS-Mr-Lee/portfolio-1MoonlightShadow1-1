/**
Name: Grace
Date: 2022-02-10
Description:Code a program which encrypts a line of code. The encryption specifications are as follows:
            -first and last character of each word are exchanged.
            -Middle characters of each word are shifted to the character two after it in the ASCII table (works for non-letters as well.)
            -spaces are kept and unchanged
*/

import java.lang.*;
import java.util.Scanner;

public class Sui_Grace_Encryption {
   public static void main (String [] args) {
   
      Scanner in = new Scanner (System.in);
      System.out.print("Enter a line to be encrypted: ");
      String sentence = in.nextLine();
      
      //save user input to array
      String [] originalWords = sentence.split(" ");
      //variable which save the new word array after be encrypted.
      String [] newWords = new String [originalWords.length];
      //read each of the user input word 
      for (int i = 0; i < originalWords.length; i++) {
         //save current word to char array. 
         char[] currentWord = originalWords[i].toCharArray();
         if (currentWord.length == 1) {
            //currrent newwords array will be same as user input if the word only one char. 
            newWords[i] = String.valueOf(currentWord[0]);
         } else if(currentWord.length == 2)  {
            //currrent newwords array exchange the first char and the last char if the word only have two chars.
            newWords[i] = String.valueOf(currentWord[1]) + String.valueOf(currentWord[0]);
         } else {
            //let the newWords array first char to be the last char of currentWord
            newWords[i] = String.valueOf(currentWord[currentWord.length-1]);
            for (int j = 1; j < currentWord.length - 1; j++) {
               //let Middle characters of each word are shifted to the character two after it in the ASCII table 
               newWords[i] = newWords[i] + String.valueOf((char)(currentWord[j] + 2));
            }
            //let the newWords array last char to be the first char of currentWord
            newWords[i] = newWords[i] + String.valueOf(currentWord[0]);
         }
      }
      
      StringBuilder builder = new StringBuilder();
      for(String s : newWords) {
         //build the newWords array to one sentence
         builder.append(s).append(" ");
      }
      //save the new sentence to variable newSentence
      String newSentence = builder.toString();
      //remove the last space of newSentence
      newSentence = newSentence.substring(0, newSentence.length()-1);
      System.out.println("The encryption is: " + newSentence);
                 
   }
}