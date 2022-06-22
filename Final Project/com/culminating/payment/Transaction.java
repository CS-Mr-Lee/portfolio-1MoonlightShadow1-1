/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: transaction class
 */
package com.culminating.payment;

import java.util.ArrayList;

public class Transaction {

   /**
    * fees of the Transaction
    */
   private ArrayList<Fee> fees;

   /**
    * Default Constructor of Transaction, Initializes the attributes fees    
    */
   public Transaction() {
      this.fees = new ArrayList<Fee>();
   }

   /**
    * Description: crreate the fee of Transaction
    * @param fee, the fee of Transaction
    */
   public void createFee(Fee fee) {
      fees.add(fee);
   }

   /**
    * Description: prints the attributes of the Transaction
    * @return String all the attributes of the Transaction
    */
   @Override
   public String toString() {
      String allFees = "";
      String raw_block = "";
      for (int i = 0; i < fees.size(); i++) {
         raw_block = fees.get(i).toString().replace("\n", "");
      }
      allFees += raw_block + "\n";
      return allFees;
   }
}
