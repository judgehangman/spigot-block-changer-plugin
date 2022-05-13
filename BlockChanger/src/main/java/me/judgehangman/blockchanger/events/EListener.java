package me.judgehangman.blockchanger.events;

import me.judgehangman.blockchanger.BlockChanger;
import me.judgehangman.blockchanger.commands.BlockChangerCommands;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import java.util.*;

public class EListener implements Listener {


    public EListener(BlockChangerCommands plugin){
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        Player p = event.getPlayer();

        //Detect block under player

        Location under = p.getLocation().subtract(0,1,0);
        Block block = under.getBlock();

        //Check if the material of the block under player is one of the allowed materials

        Material mat = block.getType();

        /* List of materials that can be changed */

        Material[] allowList = {
                Material.DEEPSLATE_TILES,
                Material.SMOOTH_QUARTZ,
                Material.BLACK_WOOL,
                Material.WHITE_CONCRETE,
                Material.IRON_BLOCK,
                Material.GOLD_BLOCK,
                Material.DIAMOND_BLOCK
        };

        boolean isAllowed = Arrays.asList(allowList).contains(mat);

        // List of materials that can be turned in Deep Slate
        Material[] slateList ={
                Material.GLOWSTONE,
                Material.WHITE_CONCRETE,
                Material.GRAY_CONCRETE,
                Material.STONE_BRICKS,
                Material.DEEPSLATE,
                Material.BLACKSTONE
        };

        boolean isSlateList = Arrays.asList(slateList).contains(mat);


        //check if player is moving a full block in either the x or z direction while remaining at the same y

        // X
        double from_x = event.getFrom().getX();
        int fx = (int) from_x;

        double to_x = Objects.requireNonNull(event.getTo()).getX();
        int tx = (int) to_x;

        // Y
        double from_y = event.getFrom().getY();
        int fy = (int) from_y;

        double to_y = event.getTo().getY();
        int ty = (int) to_y;

        // Z
        double from_z = event.getFrom().getZ();
        int fz = (int) from_z;

        double to_z = event.getTo().getZ();
        int tz = (int) to_z;


        if((tx != fx || tz != fz) && ty == fy){

            // Check what block player is standing on and see if it matches allow list

            Block cb = under.clone().getBlock();


            if(isAllowed){

                if(mat.name().equals(allowList[0].name())){


                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "Next Block: " + allowList[1].name());

                }else if(mat.name().equals(allowList[1].name())){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + block.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "Next Block: " + allowList[2].name());

                }else if(mat.name().equals(allowList[2].name())){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "Next Block: " + allowList[3].name());

                }else if(mat.name().equals(allowList[3].name())){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "Next Block: " + allowList[4].name());

                }else if(mat.name().equals(allowList[4].name())){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "Next Block: " + allowList[5].name());

                }else if(mat.name().equals(allowList[5].name())){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "Next Block: " + allowList[6].name());

                    p.playSound(under, Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);

                    p.getWorld().spawnParticle(Particle.REDSTONE, under, 2,
                            new Particle.DustOptions(Color.fromRGB(255,223,0),1));

                    // Effects



                }else if(mat.name().equals(allowList[6].name())){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());

                    p.sendMessage(ChatColor.LIGHT_PURPLE + "Current Block: " + mat.name());
                    p.sendMessage(ChatColor.AQUA + "This is the last block in the array!");

                    // Effects

                    p.playSound(under, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 2.0f);
                    p.getWorld().spawnParticle(Particle.REDSTONE, under, 2,
                            new Particle.DustOptions(Color.fromRGB(77,255,255),1));

                    ItemStack diamond = new ItemStack(Material.DIAMOND);

                    p.getInventory().addItem(diamond);

                }else{
                    p.sendMessage(ChatColor.RED + "Please register this block to change it!");
                }
            }else{
                if(isSlateList){

                    p.sendMessage(ChatColor.GRAY + "POSITION: ");
                    p.sendMessage(ChatColor.GRAY + "X= " + cb.getX());
                    p.sendMessage(ChatColor.GRAY + "Y= " + cb.getY());
                    p.sendMessage(ChatColor.GRAY + "Z= " + cb.getZ());
                    p.sendMessage(ChatColor.GREEN + "This block can be turned into deep slate!");
                }else{
                    p.sendMessage(ChatColor.RED + "Invalid block");
                }
            }
        }assert true;

    }

}
