package com.me.dami.activabetterinterface.GUI.Handlers;

import com.dami.guimanager.Gui.GuiBehavior;
import com.dami.guimanager.Gui.GuiCreator;
import com.dami.guimanager.Item.Items;
import com.me.dami.activabetterinterface.Badge.Savable.Badge;
import com.me.dami.activabetterinterface.Badge.Savable.Kingdom;
import com.me.dami.activabetterinterface.Badge.Savable.LinkedBadge;
import com.me.dami.activabetterinterface.Badge.Savable.Player;
import com.me.dami.activabetterinterface.Base.Saveable;
import com.me.dami.activabetterinterface.Base.TextConverter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerBadgeList implements GuiBehavior {
    @Override
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent, String s) {

    }

    @Override
    public Inventory updateInventory(Inventory inventory, String fullName) {
        Player p = Saveable.getPlayer(Objects.requireNonNull(Bukkit.getPlayer(getPlayer(fullName))).getUniqueId());
        assert p != null;

        List<LinkedBadge> badges = p.getBadges(0,45);
        for(LinkedBadge linkedBadge : badges){
            Badge badge = Saveable.getBadge(linkedBadge.getId());
            assert badge != null;
            ArrayList<String> lore = new ArrayList<>();
            lore.add("UnlockDate:" + linkedBadge.getUnlockDate());
            if(linkedBadge.getPlacement() != 0){
                lore.add(TextConverter.setPlacement(linkedBadge.getPlacement()));
            }
            inventory.setItem(badges.indexOf(linkedBadge) + 8,Items.generateItem(badge.getName(),Material.SUNFLOWER,lore, true));
        }
        return inventory;
    }

    @Override
    public Inventory buildInventory(String prefix, String name) {
        GuiCreator creator = new GuiCreator(prefix,name,54);
        creator.setItems(new int[]{1, 2, 3, 4, 5, 6, 7}, Items.definedItems.get("space"));
        creator.setItem(0,Items.generateItem("----", Material.RED_STAINED_GLASS_PANE));
        creator.setItem(8,Items.generateItem("NextPage", Material.GREEN_STAINED_GLASS_PANE));
        Player p = Saveable.getPlayer(Objects.requireNonNull(Bukkit.getPlayer(name)).getUniqueId());
        assert p != null;

        List<LinkedBadge> badges = p.getBadges(0,45);
        for(LinkedBadge linkedBadge : badges){
            Badge badge = Saveable.getBadge(linkedBadge.getId());
            assert badge != null;
            ArrayList<String> lore = new ArrayList<>();
            lore.add("UnlockDate:" + linkedBadge.getUnlockDate());
            if(linkedBadge.getPlacement() != 0){
                lore.add(TextConverter.setPlacement(linkedBadge.getPlacement()));
            }

            creator.setItem(badges.indexOf(linkedBadge) + 8,Items.generateItem(badge.getName(),Material.SUNFLOWER,lore, true));
        }
        return creator.buildInventory();
    }

    private String getPlayer(String fullName){
        String kingdomName = "";
        for(int i = 0 ; i < fullName.indexOf("-") - 1; i++)
        {
            kingdomName += fullName.charAt(i);
        }

        return kingdomName;
    }

    private int getPage(String fullName){
        return fullName.charAt(fullName.length() - 1);
    }
}
