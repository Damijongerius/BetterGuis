package com.me.dami.activabetterinterface.GUI;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
}
