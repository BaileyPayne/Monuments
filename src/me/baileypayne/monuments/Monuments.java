

package me.baileypayne.monuments;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bailey
 */
public class Monuments extends JavaPlugin {

    public boolean isContest = false;

    public void onEnable(){
        loadConfigFile();
        MonumentManager.getManager().loadMonuments();
    }
    public void onDisable(){

    }
    private void loadConfigFile() {
        saveDefaultConfig();
        getConfig().options();
        saveConfig();
    }
    private void deleteConfigFile(){
        getConfig().set("monuments.", null);
    }

    //Monument Commands
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(command.getName().equalsIgnoreCase("monument")){
            if(args.length == 0){
                //send list of commands
            } else {
                if(args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (isContest == false) {
                            isContest = true;
                            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.GREEN + "A Monument contest has started! Do /monument new to register your Monument!");
                        } else if(isContest == true){
                            p.sendMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.RED + "Monument Contest is already on-going!");
                        }
                    }
                    if (args[0].equalsIgnoreCase("end")) {
                        if(isContest == true) {
                            isContest = false;
                            deleteConfigFile();
                            //declare winner
                        } else if(isContest == false){
                            p.sendMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.RED + "You need to start a contest first!");
                        }
                    } else {
                        //send player options for using 1 argument or full list
                    }
                } else if(args.length == 2){
                    if(args[0].equalsIgnoreCase("new")) {
                        if (isContest == true) {
                            MonumentManager.getManager().createMonument(args[1], p.getLocation(), 0);
                        } else {
                            p.sendMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.RED + "No on-going contest!");
                        }
                    }
                    if(args[0].equalsIgnoreCase("tp")) {
                        if (isContest == true) {
                            p.teleport(MonumentManager.getManager().getMonument(args[1]).getMonumentLocation());
                        } else {
                            p.sendMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.RED + "No on-going contest!");
                        }
                    }
                    if(args[0].equalsIgnoreCase("vote")){
                        if (isContest == true) {
                            //finish voting system
                        } else {
                            p.sendMessage(ChatColor.GOLD + "[Monuments]" + ChatColor.RED + "No on-going contest!");
                        }
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
