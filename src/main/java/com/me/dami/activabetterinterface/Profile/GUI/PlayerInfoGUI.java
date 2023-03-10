package com.me.dami.activabetterinterface.Profile.GUI;

import com.me.dami.activabetterinterface.Base.IOpenGui;
import com.me.dami.activabetterinterface.Base.TextConverter;
import com.me.dami.activabetterinterface.GUI.StaticGuiItems;
import me.map.ultimatekingdom.api.UltimateKingdom;
import me.map.ultimatekingdom.api.objects.KingdomPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class PlayerInfoGUI implements IOpenGui {

    private int[] spacing = {0,1,2,3,4,5,6,7,8,9,11,17,18,19,20,21,22,23,24,25,26};

    public void OpenInventory(Inventory _inv, Player _p) {
        //should be set playtime when accessable

        _p.openInventory(_inv);
    }

    @Override
    public void OpenStaffInventory(Player _p, String _name) {

    }

    public Inventory OpenInventory(Player _p, String _object) {
        Inventory inv = Bukkit.createInventory(null,27,_p.getDisplayName());


        for(int slot : spacing){
            inv.setItem(slot , StaticGuiItems.space);
        }

        inv.setItem(10,SetHead(_object, _p));

        inv.setItem(12, SetKingdom(_p));

        inv.setItem(13, SetMedals(_p));

        inv.setItem(14, SetPlayTime(_p));

        //should be set playtime when accessable

        _p.openInventory(inv);
        return inv;
    }

    private ItemStack SetHead(String _name, Player p){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta skull = (SkullMeta) item.getItemMeta();

        skull.setDisplayName(_name);

        ArrayList<String> lore = new ArrayList<>();

        KingdomPlayer kPlayer = UltimateKingdom.Players().getPlayer(p.getUniqueId());

        lore.add("Balance: " + "Geen balance beschikbaar");
        lore.add("Rank: " + TextConverter.CheckString(kPlayer.getRank().getColor() + kPlayer.getRankString()));

        if(kPlayer.isOnline()){
            lore.add("Status : " + ChatColor.GREEN + "Online");
        }else{
            lore.add("Status :" + ChatColor.RED + "Offline");
        }

        lore.add("customDisplay: " + p.getDisplayName());

        skull.setLore(lore);

        skull.setOwner(_name);
        item.setItemMeta(skull);

        return item;
    }

    private ItemStack SetKingdom(Player p){
        ItemStack item = new ItemStack(Material.SPRUCE_DOOR);

        ItemMeta meta = item.getItemMeta();

        String kd = UltimateKingdom.Players().getPlayer(p.getUniqueId()).getKingdom().getDisplay();
        if(kd != null){
            p.sendMessage(kd);
            assert meta != null;
            meta.setDisplayName("Kingdom");
        }

        ArrayList<String> lore = new ArrayList<>();

        lore.add(ChatColor.WHITE +"kingdom: "  + TextConverter.CheckString(kd));
        lore.add(ChatColor.WHITE + "-=-=-=-=-=-=-");
        lore.add(ChatColor.YELLOW +"click here to open kingdom");

        item.setItemMeta(meta);
        return item;
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

    private ItemStack SetPlayTime(Player p){
        ItemStack item = new ItemStack(Material.CLOCK);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("PlayTime");

        ArrayList<String> lore = new ArrayList<>();

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
