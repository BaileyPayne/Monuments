

package me.baileypayne.monuments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bailey
 */
public class Monuments extends JavaPlugin {

    public void onEnable(){

    }
    public void onDisable(){

    }

    //Monument Commands
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("monument")){
            if(args.length == 0){
                //send list of commands
            } else {
                if(args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        //make a true/false variable of if there is a contest
                        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.GREEN + "A Monument contest has started! Do /monument new to register your Monument!");
                    }
                    if (args[0].equalsIgnoreCase("end")) {
                        //end contest and declare winner
                    } else {
                        //send player options for using 1 argument or full list
                    }
                } else if(args.length == 2){
                    if(args[0].equalsIgnoreCase("new")){
                        //register a new monument
                    }
                    if(args[0].equalsIgnoreCase("tp")){
                        //tp to a monument
                    }
                    if(args[0].equalsIgnoreCase("vote")){
                        //vote for a monument
                    } else {
                        //send list of possible commands
                    }
                } else {
                    //send list of possible commands
                }
            }

        }
        return super.onCommand(sender, command, label, args);
    }
}
