package me.judgehangman.blockchanger.commands;

import me.judgehangman.blockchanger.events.EListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

public class BlockChangerCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            return true;
        }

        Player p = (Player) sender;

        if(cmd.getName().equals("bc")){
            if(args.length == 0){
                p.sendMessage(ChatColor.RED + "Incomplete command.");
                p.sendMessage(ChatColor.GRAY + "Usage: /bc <start | stop>");
            } else if(args.length == 1 && args[0].equals("start")){
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Block Changer] has started!");
                Bukkit.getConsoleSender().sendMessage(p.getName() + " started block changer!");
                getServer().getPluginManager().registerEvents(new EListener(this), (Plugin) this);
            }else if(args.length == 1 && args[0].equals("stop")){
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Block Changer] has stopped!");
                Bukkit.getConsoleSender().sendMessage(p.getName() + " stopped block changer!");
                HandlerList.unregisterAll();
            }
        }

        return true;
    }

}
