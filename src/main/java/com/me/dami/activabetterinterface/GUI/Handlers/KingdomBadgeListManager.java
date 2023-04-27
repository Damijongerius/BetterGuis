package com.me.dami.activabetterinterface.GUI.Handlers;

import com.dami.guimanager.Gui.GuiBehavior;
import com.dami.guimanager.Gui.GuiCreator;
import com.dami.guimanager.GuiManager;
import com.dami.guimanager.Item.Items;
import com.me.dami.activabetterinterface.ActivaBetterInterface;
import com.me.dami.activabetterinterface.Badge.Savable.Badge;
import com.me.dami.activabetterinterface.Badge.Savable.Kingdom;
import com.me.dami.activabetterinterface.Badge.Savable.LinkedBadge;
import com.me.dami.activabetterinterface.Base.Saveable;
import com.me.dami.activabetterinterface.Base.TextConverter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class KingdomBadgeListManager implements GuiBehavior {

    GuiManager gm;
    public KingdomBadgeListManager(GuiManager gm){
        this.gm = gm;
    }

    @Override
    public void onInventoryClick(InventoryClickEvent e, String name) {
        int slot = e.getSlot();
        Player p = (Player) e.getWhoClicked();

        if(slot == 0 && getPage(name) != 1){
            p.closeInventory();
            gm.openGuiFor(p,"kingdomBadgeList",getKingdom(name) + "-page " + (getPage(name) -1) );
        }

        if(slot == 8){
            p.closeInventory();
            gm.openGuiFor(p,"kingdomBadgeList",getKingdom(name) + "-page " + (getPage(name) +1));
        }
    }

    @Override
    public Inventory updateInventory(Inventory inv, String name) {
        int page = getPage(name);
        Inventory ninv = inv;
        ninv.setItem(0, Items.generateItem("----", Material.RED_STAINED_GLASS_PANE));
        ninv.setItem(8, Items.generateItem("NextPage", Material.GREEN_STAINED_GLASS_PANE));
        Kingdom kd = Saveable.getKingdom(getKingdom(name));
        assert kd != null;

        List<LinkedBadge> badges = kd.getBadges((page - 1) * 45,page * 45);
        for (LinkedBadge linkedBadge : badges) {
            Badge badge = Saveable.getBadge(linkedBadge.getId());
            assert badge != null;
            ArrayList<String> lore = new ArrayList<>();
            lore.add("UnlockDate:" + linkedBadge.getUnlockDate());
            if (linkedBadge.getPlacement() != 0) {
                switch (linkedBadge.getPlacement()) {
                    case 1 -> lore.add("placement: 1st");
                    case 2 -> lore.add("placement: 2nd");
                    case 3 -> lore.add("placement: 3rd");
                    case 4 -> lore.add("placement: 4th");
                    case 5 -> lore.add("placement: 5th");
                    default -> {
                        if (linkedBadge.getPlacement() <= 10) {
                            lore.add("placement: top 10");
                            break;
                        }
                        if (linkedBadge.getPlacement() < 50) {
                            lore.add("placement: top 50");
                            break;
                        }
                        lore.add("placement: 50+");
                    }
                }
            }
            ninv.setItem(badges.indexOf(linkedBadge) + 8,Items.generateItem(badge.getName(),Material.SUNFLOWER,lore, true));
        }
        return null;
    }

    @Override
    public Inventory buildInventory(String prefix, String name) {
        GuiCreator creator = new GuiCreator(prefix,name,54);
        creator.setItems(new int[]{1, 2, 3, 4, 5, 6, 7}, Items.definedItems.get("space"));
        creator.setItem(0,Items.generateItem("----", Material.RED_STAINED_GLASS_PANE));
        creator.setItem(8,Items.generateItem("NextPage", Material.GREEN_STAINED_GLASS_PANE));
        Kingdom kd = Saveable.getKingdom(getKingdom(name));
        assert kd != null;

        List<LinkedBadge> badges = kd.getBadges(0,45);
        for(LinkedBadge linkedBadge : badges){
            Badge badge = Saveable.getBadge(linkedBadge.getId());
            assert badge != null;
            ArrayList<String> lore = new ArrayList<>();
            lore.add("UnlockDate:" + linkedBadge.getUnlockDate());
            if(linkedBadge.getPlacement() != 0){
                if(linkedBadge.getPlacement() != 0){
                    lore.add(TextConverter.setPlacement(linkedBadge.getPlacement()));
                }
            }

            creator.setItem(badges.indexOf(linkedBadge) + 8,Items.generateItem(badge.getName(),Material.SUNFLOWER,lore, true));
        }
        return creator.buildInventory();
    }

    private String getKingdom(String fullName){
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
