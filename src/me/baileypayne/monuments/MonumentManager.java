package me.baileypayne.monuments;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Bailey on 06/11/2014.
 */
public class MonumentManager {

    private Monuments plugin;

    private static MonumentManager mm = new MonumentManager();

    //use to get arena manager
    public static MonumentManager getManager(){
        return mm;
    }

    private FileConfiguration config;

    //Get a Monument
    public Monument getMonument(String mounumentName){
        for(Monument m: Monument.monumentObjects){ //filter through list of monuments
            if(m.getMonumentName().equals(mounumentName)){ //check to see if there is a match
                return m;
            }
        }
        return null; //nothing found
    }
    //Load Monuments
    public void loadMonuments(){
        //config file
        FileConfiguration fc = plugin.getConfig();

        for(String keys: fc.getConfigurationSection("monuments").getKeys(false)){

            //Monument Object
            World world = Bukkit.getWorld("monuments." + keys + ".world");

            //Locations
            double joinX = fc.getDouble("monuments." + "keys." + ".monumentX");
            double joinZ = fc.getDouble("monuments." + "keys." + ".monumentZ");
            double joinY = fc.getDouble("monuments." + "keys." + ".monumentY");
            Location monumentLocation = new Location(world, joinX, joinY, joinZ);

            int votes = fc.getInt("monuments." + keys + ".votes");

            //object creation
            Monument arena = new Monument(keys, monumentLocation, votes);
        }
    }
    public void createArena(String monumentName, Location monumentLocation, int votes){

        //monument object to represent
        Monument monument = new Monument(monumentName, monumentLocation, votes);

        FileConfiguration fc = plugin.getConfig();

        //set name
        fc.set("monuments." + monumentName, null); //set name

        String path = "monuments." + monumentName + ".";

        //set monument location
        fc.set(path + ".monumentX", monumentLocation.getX());
        fc.set(path + ".monumentY", monumentLocation.getY());
        fc.set(path + ".monumentZ", monumentLocation.getZ());
        monument.setMonumentLocation(monumentLocation);

        //set max players
        fc.set(path + ".votes", votes);

        //need to save config
        plugin.saveConfig();
    }
    public void RemoveMonument(Player player, String monumentName){
        FileConfiguration fc = plugin.getConfig();
        String path = "monuments." + monumentName;
        fc.set(path, null);
        plugin.saveConfig();
        player.sendMessage("Monument Removed!");
        Monument.monumentObjects.remove(getMonument(monumentName));
    }

}
