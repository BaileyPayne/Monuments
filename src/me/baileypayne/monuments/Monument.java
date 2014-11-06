package me.baileypayne.monuments;

import org.bukkit.Location;

import java.util.ArrayList;

/**
 * Created by Bailey on 06/11/2014.
 */
public class Monument {

    //list monument objects
    public static ArrayList<Monument> monumentObjects = new ArrayList<Monument>();

    //monument info
    private Location monumentLocation; //Locations
    private String monumentName; //Name
    private int votes; //votes
    private boolean isContest = false;

    //Constructor
    public Monument(String monumentName, Location monumentLocation, int votes){
        //init all objects
        this.monumentName = monumentName;
        this.monumentLocation = monumentLocation;
        this.votes = votes;

        //add to list of objects
        monumentObjects.add(this);
    }
    //Getters and Setters
    //Locations
    public Location getMonumentLocation(){
        return this.monumentLocation;
    }
    public void setMonumentLocation(Location monumentLocation){
        this.monumentLocation = monumentLocation;
    }
    //Name
    public String getMonumentName(){
        return this.monumentName;
    }
    public void setMonumentName(String monumentName){
        this.monumentName = monumentName;
    }
    //Votes
    public int getVotes(){
        return this.votes;
    }
    public void setVotes(int votes){
        this.votes = votes;
    }
    //Is a contest ongoing?
    public boolean isContest(){
        return isContest;
    }

}
