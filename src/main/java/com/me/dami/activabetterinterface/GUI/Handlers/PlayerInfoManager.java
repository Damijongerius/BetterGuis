package com.me.dami.activabetterinterface.GUI.Handlers;

import com.dami.guimanager.Gui.GuiBehavior;
import com.dami.guimanager.Gui.GuiCreator;
import com.dami.guimanager.GuiManager;
import com.dami.guimanager.Item.Items;
import com.me.dami.activabetterinterface.Base.TextConverter;
import me.map.ultimatekingdom.api.UltimateKingdom;
import me.map.ultimatekingdom.api.objects.KingdomPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerInfoManager implements GuiBehavior {

    private final GuiManager gm;

    public PlayerInfoManager(GuiManager gm){
        this.gm = gm;
    }
    @Override
    public void onInventoryClick(InventoryClickEvent e, String name) {
        int slot = e.getSlot();
        if(!(slot > 11) && !(slot < 17)){
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if(slot == 12){
            p.closeInventory();
            gm.openGuiFor(p,"kingdomView",UltimateKingdom.Players().getPlayer(p).getKingdom().getName());
        }

        if(slot == 13){
            //open medal menu
        }

        if(slot == 14){
            //open playtime top
        }

        if(slot == 16){
            p.closeInventory();
        }
    }

    @Override
    public Inventory updateInventory(Inventory inventory, String name) {
        Player p = Bukkit.getPlayer(name);

        inventory.setItem(14, setPlayTime(p.getUniqueId()));

        if(p.isOnline()){

            inventory.setItem(10,setHead(p.getName(), p.getUniqueId(), p.getDisplayName()));
        }
        else{
            inventory.setItem(10,setHead(p.getName(), p.getUniqueId(), p.getName()));
        }
        return null;
    }

    @Override
    public Inventory buildInventory(String prefix, String name) {

        GuiCreator creator = new GuiCreator(prefix, name, 27);
        creator.setItems(new int[] {0,1,2,3,4,5,6,7,8,9,11,17,18,19,20,21,22,23,24,25,26}, Items.definedItems.get("space"));

        Player p = Bukkit.getPlayer(name);
        assert p != null;

        creator.setItem(12, setKingdom(p.getUniqueId()));
        creator.setItem(13, setMedals(p.getUniqueId()));
        creator.setItem(14, setPlayTime(p.getUniqueId()));

        if(p.isOnline()){
            creator.setItem(10,setHead(p.getName(), p.getUniqueId(), p.getDisplayName()));
        }
        else{
            creator.setItem(10,setHead(p.getName(), p.getUniqueId(), p.getName()));
        }

        return creator.buildInventory();
    }

    private static ItemStack setHead(String _name, UUID p, String customDisplay){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta skull = (SkullMeta) item.getItemMeta();
        assert skull != null;

        skull.setDisplayName(_name);

        ArrayList<String> lore = new ArrayList<>();

        KingdomPlayer kPlayer = UltimateKingdom.Players().getPlayer(p);

        lore.add("Balance: " + "Geen balance beschikbaar");
        lore.add("Rank: " + TextConverter.CheckString(kPlayer.getRank().getColor() + kPlayer.getRankString()));

        if(kPlayer.isOnline()){
            lore.add("Status : " + ChatColor.GREEN + "Online");
        }else{
            lore.add("Status :" + ChatColor.RED + "Offline");
        }

        lore.add("customDisplay: " + customDisplay);

        skull.setLore(lore);

        skull.setOwner(_name);
        item.setItemMeta(skull);

        return item;
    }

    private static ItemStack setKingdom(UUID p){
        ItemStack item = new ItemStack(Material.SPRUCE_DOOR);

        ItemMeta meta = item.getItemMeta();

        String kd = UltimateKingdom.Players().getPlayer(p).getKingdom().getDisplay();
        if(kd != null){
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

    private static ItemStack setMedals(UUID p){
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

    private static ItemStack setPlayTime(UUID p){
        ItemStack item = new ItemStack(Material.CLOCK);

        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("PlayTime");

        ArrayList<String> lore = new ArrayList<>();

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
