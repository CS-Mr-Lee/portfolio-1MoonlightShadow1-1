/**
 * Name(s): Franklin, Mike, Grace, Sophia
 * Date: 2022-05-04
 * Description: Media record class
 */
package com.culminating.record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.culminating.media.Media;
import com.culminating.utils.Log;

public class MediaRecord {

    /**
     * borrowHistory of the MediaRecord
     */
    private List<Log> borrowHistory;
    
    /**
     * item of the MediaRecord
     */
    private Media item;

    /**
     * Default Constructor of MediaRecord, Initializes the attributes item and borrowHistory    
     */
    public MediaRecord() {
        this.item = new Media();
        this.borrowHistory = new ArrayList<Log>();
        this.borrowHistory.set(0, new Log());
    }

    /**
     * Constructor of MediaRecord
     * @param borrowHistory, borrowHistory of the MediaRecord
     * @param item, item of the MediaRecord
     */
    public MediaRecord(List<Log> borrowHistory, Media item) {
        this.borrowHistory = borrowHistory;
        this.item = item;
    }

    /**
     * Description: Gets the popular media of MediaRecord
     * @return media of MediaRecord
     */
    public Media getPopularItem() {
        List<Log> tempLog = this.borrowHistory;

        Map<Media, Integer> popularMap = new HashMap<>();

        Media popularMedia = new Media();

        for (int i = 0; i < tempLog.size(); i++) {
            Log checkout = tempLog.get(i);
            Media item = checkout.getItem();
            int count = popularMap.getOrDefault(item, 0);
            popularMap.putIfAbsent(item, count + 1);
        }

        int maxValue = Collections.max(popularMap.values());
        for (Entry<Media, Integer> entry : popularMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                popularMedia = entry.getKey();
            }
        }
        return popularMedia;
    }

    /**
     * Description: Gets the borrowHistory of MediaRecord
     * @return the borrowHistory of MediaRecord
     */
    public List<Log> getBorrowHistory() {
        return this.borrowHistory;
    }

    /**
     * Description: Sets type of media
     * @param type, the type of media
     */
    public void setBorrowHistory(List<Log> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }

    /**
     * Description: Gets the item of MediaRecord
     * @return the item of MediaRecord
     */
    public Media getItem() {
        return this.item;
    }

    /**
     * Description: Sets item of MediaRecord
     * @param item, the item of MediaRecord
     */
    public void setItem(Media item) {
        this.item = item;
    }

    /**
     * Description: prints all the attributes of the MediaRecord
     * @return String all the attributes of the MediaRecord
     */
    public String toString() {
        String ret = "";
        ret += "Item: " + this.item.toString() + "\n";
        for (int i = 0; i < this.borrowHistory.size(); i++) {
            ret += this.borrowHistory.get(i).toString() + ",";
        }
        ret = ret.substring(0, ret.length() - 1);
        return ret;
    }

}
