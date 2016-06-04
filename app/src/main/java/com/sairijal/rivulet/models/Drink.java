package com.sairijal.rivulet.models;

import com.orm.SugarRecord;

/**
 * Created by sayujya on 16-06-02.
 */
public class Drink extends SugarRecord{

    // which day did this occur in
    Day day;
    // time of day, stored in seconds from midnight
    long time;
    // amount of water drank stored in mL
    int amount;

    public long getTime() {
        return time;
    }

    public int getAmount() {
        return amount;
    }
}
