package com.me.dami.activabetterinterface.Profile.GUI;

import com.me.dami.activabetterinterface.Base.IOpenGui;
import com.me.dami.activabetterinterface.Base.Kingdom;
import com.me.dami.activabetterinterface.GUI.StaticGuiItems;
import me.map.ultimatekingdom.API.UltimateKingdom;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class PlayerInfoGUI implements IOpenGui {

    private int[] spacing = {0,1,2,3,4,5,6,7,8,9,11,17,18,19,20,21,22,23,24,25,26,27};

    public void OpenInventory(Inventory _inv, Player _p) {
        //should be set playtime when accessable

        _p.openInventory(_inv);
    }

    public Inventory OpenInventory(Player _p, String _object) {
        Inventory inv = Bukkit.createInventory(null,27,_p.getDisplayName());


        for(int slot : spacing){
            inv.setItem(slot , StaticGuiItems.space);
        }

        inv.setItem(10,SetHead(_object));

        inv.setItem(12, SetKingdom(Bukkit.getPlayer(_object)));

        //should be set playtime when accessable

        _p.openInventory(inv);
        return inv;
    }

    private ItemStack SetHead(String _name){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta skull = (SkullMeta) item.getItemMeta();

        skull.setDisplayName(_name);
        skull.setLore(null);
        skull.setOwner(_name);

        item.setItemMeta(skull);

        return item;
    }

    private ItemStack SetKingdom(Player p){
        ItemStack item = new ItemStack(Material.SPRUCE_DOOR);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(UltimateKingdom.Players().getPlayer(p.getUniqueId()).getKingdom().getDisplayName());

        ArrayList<String> lore = new ArrayList<>();

        lore.add("click here to open kingdom");

        item.setItemMeta(meta);
        return null;
    }

    private ItemStack SetMedals(Player p){
        ItemStack item = new ItemStack(Material.SUNFLOWER);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("medals");

        ArrayList<String> lore = new ArrayList<>();

        //get medal count
        //get latestMedal

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    private ItemStack SetPlayTime(){
        ItemStack item = new ItemStack(Material.CLOCK);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("PlayTime");

        ArrayList<String> lore = new ArrayList<>();

        //get player play time

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
