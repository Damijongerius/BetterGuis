package com.me.dami.activabetterinterface.Kingom.GUI;

import com.me.dami.activabetterinterface.Base.IOpenGui;
import com.me.dami.activabetterinterface.Base.TextConverter;
import com.me.dami.activabetterinterface.GUI.StaticGuiItems;
import me.map.ultimatekingdom.api.UltimateKingdom;
import me.map.ultimatekingdom.api.objects.Kingdom;
import me.map.ultimatekingdom.api.objects.KingdomPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class KingdomGUI{

    private static int[] spacing = {0,1,2,3,4,5,6,7,8,9,12,14,17,18,19,20,21,22,23,24,25,26,27,29,33,35,36,38,42,44,45,46,47,48,49,50,51,52,53};

    public static Inventory createInventory(Kingdom kd, String name) {
        Inventory inv = Bukkit.createInventory(null,54,name);

        for(int slot : spacing){
            inv.setItem(slot, StaticGuiItems.space);
        }

        inv.setItem(10,SetKing(kd));
        inv.setItem(11,SetQueen(kd));
        inv.setItem(13,SetKingdom(kd));
        inv.setItem(15,SetAdvisors(kd));
        inv.setItem(16,SetGeneral(kd));
        inv.setItem(28,SetAlly1(kd));
        inv.setItem(30,SetGovernment(kd));
        inv.setItem(31,SetAbout());
        inv.setItem(32,SetPoints(kd));
        inv.setItem(34,SetOnlinePlayers(kd));
        inv.setItem(37,SetAlly2(kd));
        inv.setItem(39,SetWarScore());
        inv.setItem(40,SetDiscordLink());
        inv.setItem(41,SetMedals());
        inv.setItem(43,SetOfflinePlayers(kd));

        return inv;
    }

    private static ItemStack SetKing(Kingdom kd) {
        System.out.println("setKing");
        ArrayList<String> rolls = new ArrayList<String>() {
            {
                add("chief");
                add("mayor");
                add("baron");
                add("earl");
                add("duke");
                add("king");
                add("emperor");
            }
        };

        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            for (String roll : rolls) {
                if (Objects.equals(roll, kPlayer.getRank().getName())) {

                    return StaticGuiItems.generateItem(
                            TextConverter.CheckString(kPlayer.getRank().getColor() + kPlayer.getRankString()),
                            Material.GOLDEN_HELMET,
                            new ArrayList<>() {
                                {
                                    if (kPlayer.getName() != null) {
                                        add(kPlayer.getName());
                                    }
                                }
                            },
                            true
                    );
                }
            }
        }
        return StaticGuiItems.generateItem(
                "???",
                Material.GOLDEN_HELMET,
                null,
                true
        );
    }

    private static ItemStack SetQueen(Kingdom kd){
        ArrayList<String> rolls = new ArrayList<>() {
            {
                add("baroness");
                add("countess");
                add("duchess");
                add("queen");
                add("empress");
            }
        };

        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            for (String roll : rolls) {
                if (Objects.equals(roll, kPlayer.getRankString())) {


                    return StaticGuiItems.generateItem(
                            TextConverter.CheckString(kPlayer.getRank().getColor() + kPlayer.getRankString()),
                            Material.GOLDEN_HELMET,
                            new ArrayList<String>() {
                                {
                                    if (kPlayer.getName() != null) {
                                        add(kPlayer.getName());
                                    }
                                }
                            },
                            true
                    );
                }
            }
        }
        return StaticGuiItems.generateItem(
                "???",
                Material.GOLDEN_HELMET,
                null,
                true
        );
    }

    private static ItemStack SetKingdom(Kingdom kd){
        return StaticGuiItems.generateItem(
                kd.getName(),
                Material.CRAFTING_TABLE,
                new ArrayList<String>(){
                    {
                        add("players: " + kd.getMemberList().size());
                    }
                },
                false
        );
    }

    private static ItemStack SetAdvisors(Kingdom kd) {

        ArrayList<String> players = new ArrayList<>();

        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            if (Objects.equals("advisor", kPlayer.getRankString())) {
                players.add(kPlayer.getName());

            }
        }
        return StaticGuiItems.generateItem(
                "advisors",
                Material.GOLDEN_BOOTS,
                players,
            true
            );
    }

    private static ItemStack SetGeneral(Kingdom kd){

        ArrayList<String> players = new ArrayList<>();

        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            if (Objects.equals("general", kPlayer.getRankString())) {
                players.add(kPlayer.getName() );

            }
        }
        return StaticGuiItems.generateItem(
                "generals",
                Material.GOLDEN_BOOTS,
                players,
                true
        );
    }

    private static ItemStack SetAlly1(Kingdom kd){
        return StaticGuiItems.generateItem(
                "Ally1",
                Material.TOTEM_OF_UNDYING,
                null,
                false
        );
    }

    private static ItemStack SetAlly2(Kingdom kd){
        return StaticGuiItems.generateItem(
                "Ally1",
                Material.TOTEM_OF_UNDYING,
                null,
                false
        );
    }

    private static ItemStack SetGovernment(Kingdom kd){
        return StaticGuiItems.generateItem(
                "government",
                Material.GOLD_BLOCK,
                null,
                false
        );
    }

    private static ItemStack SetAbout(){
        return StaticGuiItems.generateItem(
                "about",
                Material.BOOK,
                null,
                false
        );
    }

    private static ItemStack SetPoints(Kingdom kd){
        return StaticGuiItems.generateItem(
                "government",
                Material.AMETHYST_CLUSTER,
                null,
                false
        );
    }

    private static ItemStack SetWarScore(){
        return StaticGuiItems.generateItem(
                "warScore",
                Material.WOODEN_SWORD,
                null,
                false
        );
    }

    private static ItemStack SetDiscordLink(){
        return StaticGuiItems.generateItem(
                "discordLink",
                Material.GOLD_BLOCK,
                new ArrayList<String>(){
            {
                add("Discord Link");
                add("discord.gg");
                add("-----------");
                add("click to get message link");
            }
        },
                false
        );
    }

    private static ItemStack SetMedals(){
        return StaticGuiItems.generateItem(
                "medals",
                Material.SUNFLOWER,
                null,
                false
        );
    }

    private static ItemStack SetOnlinePlayers(Kingdom kd){
        ArrayList<String> players = new ArrayList<>();

        String aFewPlayers = ChatColor.GREEN + "";
        int count = 0;
        for(Player p : kd.getOnlinePlayers()){
            if(kd.getOnlinePlayers().indexOf(p) == (kd.getOnlinePlayers().size() -1)){
                aFewPlayers += p.getName();
                players.add(aFewPlayers);
                break;
            }
            if(count == 3){
                aFewPlayers += p.getName();
                players.add(aFewPlayers);
                aFewPlayers  = ChatColor.GREEN + "";
                count = 0;
            }else{
                aFewPlayers += p.getName() + ",";
                count++;
            }
        }

        return StaticGuiItems.generateItem(
                "OnlinePlayerList",
                Material.GREEN_BED,
                players,
                false
        );
    }

    private static ItemStack SetOfflinePlayers(Kingdom kd){
        List<UUID> players = kd.getMemberList();

        for(Player p : kd.getOnlinePlayers()){
            players.remove(p.getUniqueId());
        }

        String aFewPlayers = ChatColor.RED + "";
        int count = 0;
        ArrayList<String> sPlayers = new ArrayList<>();
        for(UUID p : players){
            String playerName = UltimateKingdom.Players().getPlayer(p).getName();
            if(kd.getOnlinePlayers().indexOf(p) == (kd.getOnlinePlayers().size() -1)){
                aFewPlayers += playerName;
                sPlayers.add(aFewPlayers);
                break;
            }
            if(count == 3){
                aFewPlayers += playerName;
                sPlayers.add(aFewPlayers);
                aFewPlayers  = ChatColor.RED + "";
                count = 0;
            }else{
                aFewPlayers += playerName + ",";
                count++;
            }
        }

        return StaticGuiItems.generateItem(
                "OfflinePlayerList",
                Material.RED_BED,
                sPlayers,
                false
        );
    }

}
