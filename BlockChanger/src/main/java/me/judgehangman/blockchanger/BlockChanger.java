package me.judgehangman.blockchanger;
import me.judgehangman.blockchanger.events.EListener;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockChanger extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getConsoleSender().sendMessage("[Block Changer] Plugin is Enabled!");
        this.getCommand("cmd");


    }

    @Override
    public void onDisable() {

        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("[Block Changer] Plugin is Disabled!");
    }

    // COMMANDS

}
