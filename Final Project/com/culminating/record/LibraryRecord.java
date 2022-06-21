/**
*Name(s): Franklin, Mike, Grace, Sophia
*Date: 2022-05-04
*Description: Library record class
*/
package com.culminating.record;

public class LibraryRecord {

    /**
     * userRecords of the LibraryRecord
     */
    private UserRecord[] userRecords;
    
    /**
     * mediaRecords of the LibraryRecord
     */
    private MediaRecord[] mediaRecords;
    
    /**
     * Default Constructor of LibraryRecord, Initializes the attributes userRecords and mediaRecords    
     */
    public LibraryRecord() {
        this.userRecords = new UserRecord[1];
        this.userRecords[0] = new UserRecord();
        this.mediaRecords = new MediaRecord[1];
        this.mediaRecords[0] = new MediaRecord();
    }

    /**
     * Constructor of LibraryRecord
     * @param userRecords, userRecords of the LibraryRecord
     * @param mediaRecords, mediaRecords of the LibraryRecord
     */
    public LibraryRecord(UserRecord[] userRecords, MediaRecord[] mediaRecords) {
        this.userRecords = userRecords;
        this.mediaRecords = mediaRecords;
    }

    /**
     * Description: Gets the userRecords of LibraryRecord
     * @return the userRecords of LibraryRecord
     */
    public UserRecord[] getUserRecords() {
        return this.userRecords;
    }

    /**
     * Description: Sets userRecords of LibraryRecord
     * @param userRecords, the userRecords of LibraryRecord
     */ 
    public void setUserRecords(UserRecord[] userRecords) {
        this.userRecords = userRecords;
    }

    /**
     * Description: Gets the mediaRecords of LibraryRecord
     * @return the mediaRecords of LibraryRecord
     */
    public MediaRecord[] getMediaRecords() {
        return this.mediaRecords;
    }

    /**
     * Description: Sets mediaRecords of LibraryRecord
     * @param mediaRecords, the mediaRecords of LibraryRecord
     */ 
    public void setMediaRecords(MediaRecord[] mediaRecords) {
        this.mediaRecords = mediaRecords;
    }
    
    /**
     *Description: prints all the attributes of the LibraryRecord
     */
    public String toString() {
        String ret = "";
        ret += "Media Records: ";
        for (int i = 0; i < this.mediaRecords.length; i++) {
         ret += mediaRecords[i].toString() + ",";
        }
        ret = ret.substring(0, ret.length()-1);
        for (int i = 0; i < this.userRecords.length; i++) {
         ret += userRecords[i].toString() + ",";
        }
        ret = ret.substring(0, ret.length()-1);
        return ret;
    }
}