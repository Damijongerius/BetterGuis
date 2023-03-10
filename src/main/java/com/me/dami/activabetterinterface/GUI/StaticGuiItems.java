package com.me.dami.activabetterinterface.GUI;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.function.Consumer;

public class StaticGuiItems {

    public static ItemStack space = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
    public static ItemStack exit = new ItemStack(Material.RED_CANDLE);

    public StaticGuiItems(){
//        <----------------------------------------------->
        ItemMeta space_Meta = space.getItemMeta();

        space_Meta.setDisplayName("");

        space_Meta.setLore(null);
        space.setItemMeta(space_Meta);
//        <----------------------------------------------->
        ItemMeta exit_Meta = exit.getItemMeta();

        exit_Meta.setDisplayName("");

        exit_Meta.setLore(null);
        exit.setItemMeta(exit_Meta);
//        <----------------------------------------------->

    }

    public static ItemStack generateItem(String name, Material material, ArrayList<String> lore, Boolean hide_Attributes){


        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        if(hide_Attributes){
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

}
