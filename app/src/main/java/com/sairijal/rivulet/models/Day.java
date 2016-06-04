package com.sairijal.rivulet.models;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sayujya on 16-06-02.
 */
public class Day extends SugarRecord
{
    // the date associated with this date
    private Date date;

    // did the user drink enough water on this day;
    private boolean isComplete = false;

    // total water for this day
    // not valid unless flag following is true
    private int totalWater = 0;
    private boolean isTotalWaterValid = true;

    // water balance for this day
    // not valid unless flag following is true
    private int balance = 0;
    private boolean isBalanceValid = true;

    public Day(Date date)
    {
        this.date = date;
    }

    public int getBalance()
    {
        return this.balance;
    }

    public void addDrink(Drink drink)
    {
        // TODO import drinks for this day, some sugar shit
        recomputeBalance();
    }

    private void recomputeBalance()
    {
        if (!isBalanceValid) {
            recomputeTotalWater();
        }


    }

    private void recomputeTotalWater()
    {
        // TODO import drinks for this day, some sugar shit
        List<Drink> drinks = new ArrayList<Drink>();
        this.totalWater = 0;
        for (Drink drink: drinks) {
            this.totalWater += drink.getAmount();
        }
        this.isBalanceValid = true;
    }

}
