package com.sairijal.rivulet;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by sayujya on 16-06-02.
 */
public class Statistics {

    // TODO implement weather

    // shared preferences keys
    public static final String WEIGHT_PREF_KEY = "weight";
    public static final String WEATHER_PREF_KEY = "weather";
    public static final String EXERCISE_PREF_KEY = "exercise";
    public static final String GLASS_SIZE_PREF_KEY = "glasssize";
    public static final String UNITS_PREF_KEY = "units";

    // activity
    public static final int ACTIVITY_COUCHPOTATO = 0;
    public static final int ACTIVITY_SEMIACTIVE = 1;
    public static final int ACTIVITY_ACTIVE = 2;
    public static final int ACTIVITY_MARATHONER = 3;

    // units
    public static final int UNITS_METRIC = 0;
    public static final int UNITS_IMPERIAL = 1;

    // statistics
    private float weight;
    private int weather;
    private int activity;
    private int glassSize;
    private int units;

    private static Statistics ourInstance;

    public static Statistics getInstance(Context context) {
        if (ourInstance==null) {
            ourInstance = new Statistics(context);
        }
        return ourInstance;
    }

    private Statistics(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.weight = preferences.getFloat(Statistics.WEIGHT_PREF_KEY, 125f);
        // weather
        this.activity = preferences.getInt(Statistics.EXERCISE_PREF_KEY, ACTIVITY_SEMIACTIVE);
        this.glassSize = preferences.getInt(Statistics.GLASS_SIZE_PREF_KEY, 250);
        this.units = preferences.getInt(Statistics.UNITS_PREF_KEY, 0);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getGlassSize() {
        return glassSize;
    }

    public void setGlassSize(int glassSize) {
        this.glassSize = glassSize;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public float getRequiredAmount() {
        return 0.5f*(this.getWeight()*1.1f);
    }

}
