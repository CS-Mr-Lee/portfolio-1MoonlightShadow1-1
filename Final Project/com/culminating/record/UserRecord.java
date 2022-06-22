/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: User Record class
 */
package com.culminating.record;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.culminating.media.Media;
import com.culminating.user.User;
import com.culminating.payment.Fee;
import com.culminating.utils.Log;

public class UserRecord {

    /**
     * owner of the UserRecord
     */
    private User owner;
    
    /**
     * pastFees of the UserRecord
     */
    private List<Fee> pastFees;
    
    /**
     * borrowHistory of the UserRecord
     */
    private List<Log> borrowHistory;

     /**
     * Default Constructor of UserRecord, Initializes the attributes owner, pastFees and borrowHistory    
     */
    public UserRecord() {
        this.owner = new User();
        this.pastFees = new ArrayList<Fee>();
        this.pastFees.set(0, new Fee());
        this.borrowHistory = new ArrayList<Log>();
        this.borrowHistory.set(0, new Log());
    }

    /**
     * Constructor of UserRecord
     * @param owner, owner of the UserRecord
     * @param pastFees, pastFees of the UserRecord
     * @param borrowHistory, borrowHistory of the UserRecord
     */
    public UserRecord(User owner, List<Fee> pastFees, List<Log> borrowHistory) {
        this.owner = owner;
        this.pastFees = pastFees;
        this.borrowHistory = borrowHistory;
    }

    /**
     * Description: append borrow history
     * @param fee, the fee of UserRecord
     */
    public void appendFeeLog(Fee fee) {
        this.pastFees.add(fee);
    }

    /**
     * Description: append borrow history
     * @param media, the media of UserRecord
     * @param date, the date of UserRecord
     */
    public void appendBorrowHistory(Media media, Date date) {
        List<Log> tempBorrowHistory = this.borrowHistory;
        Log newLog = new Log(this.owner, media, date, "checkout");
        tempBorrowHistory.add(newLog);
        this.borrowHistory = tempBorrowHistory;
    }

    /**
     * Description: append borrow history
     * @param media, the media of UserRecord
     * @param date, the date of UserRecord
     * @param detail, the detail of UserRecord
     */
    public void appendBorrowHistory(Media media, Date date, String detail) {
        List<Log> tempBorrowHistory = this.borrowHistory;
        Log newLog = new Log(this.owner, media, date, detail);
        tempBorrowHistory.add(newLog);
        this.borrowHistory = tempBorrowHistory;
    }
    
    /**
     * Description: Gets the owner of UserRecord
     * @return the owner of UserRecord
     */
    public User getOwner() {
        return this.owner;
    }

    /**
     * Description: Sets owner of UserRecord
     * @param owner, the owner of UserRecord
     */ 
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Description: Gets the pastFees of UserRecord
     * @return the pastFees of UserRecord
     */
    public List<Fee> getPastFees() {
        return this.pastFees;
    }

    /**
     * Description: Sets type of UserRecord
     * @param UserRecord, the pastFees of UserRecord
     */ 
    public void setPastFees(List<Fee> pastFees) {
        this.pastFees = pastFees;
    }

    /**
     * Description: Gets the borrowHistory of UserRecord
     * @return the borrowHistory of UserRecord
     */
    public List<Log> getBorrowHistory() {
        return this.borrowHistory;
    }
 
    /**
     * Description: Sets borrowHistory of UserRecord
     * @param borrowHistory, the borrowHistory of UserRecord
     */ 
    public void setBorrowHistory(List<Log> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }

    /**
     * Description: prints all the attributes of the UserRecord
     * @return String all the attributes of the UserRecord
     */
    public String toString() {
        String ret = "";
        ret += "User: " + this.owner.toString() + "\nFees: ";
        for (int i = 0; i < this.pastFees.size(); i++) {
            ret += pastFees.get(i).toString() + ",";
        }
        for (int i = 0; i < this.borrowHistory.size(); i++) {
            ret += this.borrowHistory.get(i).toString() + ",";
        }
        ret = ret.substring(0, ret.length() - 1);
        return ret;
    }

}
