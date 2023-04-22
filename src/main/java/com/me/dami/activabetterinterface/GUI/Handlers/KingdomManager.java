package com.me.dami.activabetterinterface.GUI.Handlers;

import com.dami.guimanager.Gui.GuiBehavior;
import com.dami.guimanager.Gui.GuiCreator;
import com.dami.guimanager.GuiManager;
import com.dami.guimanager.Item.Items;
import com.me.dami.activabetterinterface.ActivaBetterInterface;
import com.me.dami.activabetterinterface.Base.Saveable;
import com.me.dami.activabetterinterface.Base.TextConverter;
import me.map.ultimatekingdom.api.UltimateKingdom;
import me.map.ultimatekingdom.api.objects.Kingdom;
import me.map.ultimatekingdom.api.objects.KingdomPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.*;

public class KingdomManager implements GuiBehavior {

    private final GuiManager gm;

    public KingdomManager(GuiManager gm){
        this.gm = gm;
    }


    @Override
    public void onInventoryClick(InventoryClickEvent e, String name) {
        int slot = e.getSlot();
        Player p = (Player) e.getWhoClicked();
        Kingdom kd = UltimateKingdom.Kingdoms().getKingdom(name);
        switch (slot){
            case 10 -> {
                p.closeInventory();
                gm.openGuiFor(p, "playerView", getKing(kd));
            }//into lead1
            case 11 -> {
                p.closeInventory();
                gm.openGuiFor(p, "playerView", getQueen(kd));
            }//into lead2
            case 28 -> {
                p.closeInventory();
                gm.openGuiFor(p,"kingdomView", getAlly1(kd));
            }//open ally 1
            case 31 -> {
                p.closeInventory();
                ItemStack item = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta meta = (BookMeta) item.getItemMeta();
                assert meta != null;
                meta.addPage(Objects.requireNonNull(Saveable.getKingdom(name)).getDescription());
                item.setItemMeta(meta);
                p.openBook(item);
            }//open about book
            case 37 -> {
                p.closeInventory();
                gm.openGuiFor(p,"kingdomView", getAlly2(kd));
            }//open ally 2
            case 40 -> {
                p.closeInventory();
                p.sendMessage("click this to join discord server" + Objects.requireNonNull(Saveable.getKingdom(name)).getDiscordLink());
            }//open discordlink
            case 41 -> {

            }//open medals
            default -> {
                return;
            }
        }
    }

    @Override
    public Inventory updateInventory(Inventory inventory, String name) {
        return null;
    }

    @Override
    public Inventory buildInventory(String prefix, String name) {

        Kingdom kd = UltimateKingdom.Kingdoms().getKingdom(name);

        GuiCreator creator = new GuiCreator(prefix,name,54);

        creator.setItems(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 33, 35, 36, 38, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53}, Items.definedItems.get("space"));

        creator.setItem(10,setKing(kd));
        creator.setItem(11,setQueen(kd));
        creator.setItem(13,setKingdom(kd));
        creator.setItem(15,setAdvisors(kd));
        creator.setItem(16,setGeneral(kd));
        creator.setItem(28,setAlly1(kd));
        creator.setItem(30,setGovernment(kd));
        creator.setItem(31,setAbout());
        creator.setItem(32,setPoints(kd));
        creator.setItem(34,setOnlinePlayers(kd));
        creator.setItem(37,setAlly2(kd));
        creator.setItem(39,setWarScore());
        creator.setItem(40,setDiscordLink());
        creator.setItem(41,setMedals());
        creator.setItem(43,setOfflinePlayers(kd));

        return creator.buildInventory();
    }

    private static ItemStack setKing(Kingdom kd) {
        System.out.println("setKing");
        List<String> rolls = Arrays.asList(
                "chief",
                "mayor",
                "baron",
                "earl",
                "duke",
                "king",
                "emperor"
        );


        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            for (String roll : rolls) {
                if (Objects.equals(roll, kPlayer.getRank().getName())) {

                    return Items.generateItem(
                            TextConverter.CheckString(kPlayer.getRank().getColor() + kPlayer.getRankString()),
                            Material.GOLDEN_HELMET,
                            kPlayer.getName() != null ? List.of(kPlayer.getName()) : Collections.emptyList(),
                            true
                    );
                }
            }
        }
        return Items.generateItem(
                "???",
                Material.GOLDEN_HELMET,
                true
        );
    }

    private static String  getKing(Kingdom kd) {
        List<String> rolls = Arrays.asList(
                "chief",
                "mayor",
                "baron",
                "earl",
                "duke",
                "king",
                "emperor"
        );


        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            for (String roll : rolls) {
                if (Objects.equals(roll, kPlayer.getRank().getName())) {
                    return kPlayer.getName();
                }
            }
        }
        return null;
    }

    private static ItemStack setQueen(Kingdom kd){
        ArrayList<String> rolls = new ArrayList<>();
        rolls.add("baroness");
        rolls.add("countess");
        rolls.add("duchess");
        rolls.add("queen");
        rolls.add("empress");


        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            for (String roll : rolls) {
                if (Objects.equals(roll, kPlayer.getRankString())) {


                    return Items.generateItem(
                            TextConverter.CheckString(kPlayer.getRank().getColor() + kPlayer.getRankString()),
                            Material.GOLDEN_HELMET,
                            kPlayer.getName() != null ? List.of(kPlayer.getName()) : Collections.emptyList(),
                            true
                    );
                }
            }
        }
        return Items.generateItem(
                "???",
                Material.GOLDEN_HELMET,
                true
        );
    }

    private static String getQueen(Kingdom kd){
        ArrayList<String> rolls = new ArrayList<>();
        rolls.add("baroness");
        rolls.add("countess");
        rolls.add("duchess");
        rolls.add("queen");
        rolls.add("empress");


        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            for (String roll : rolls) {
                if (Objects.equals(roll, kPlayer.getRankString())) {
                    return kPlayer.getName();
                }
            }
        }
        return null;
    }

    private static ItemStack setKingdom(Kingdom kd){
        return Items.generateItem(
                kd.getName(),
                Material.CRAFTING_TABLE,
                List.of("players: " + kd.getMemberList().size()),
                false
        );
    }

    private static ItemStack setAdvisors(Kingdom kd) {

        ArrayList<String> players = new ArrayList<>();

        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            if (Objects.equals("advisor", kPlayer.getRankString())) {
                players.add(kPlayer.getName());

            }
        }
        return Items.generateItem(
                "advisors",
                Material.GOLDEN_BOOTS,
                players,
                true
        );
    }

    private static ItemStack setGeneral(Kingdom kd){

        ArrayList<String> players = new ArrayList<>();

        for (UUID player : kd.getMemberList()) {
            KingdomPlayer kPlayer = UltimateKingdom.getKingdomServer().Players().getPlayer(player);
            if (Objects.equals("general", kPlayer.getRankString())) {
                players.add(kPlayer.getName() );

            }
        }
        return Items.generateItem(
                "generals",
                Material.GOLDEN_BOOTS,
                players,
                true
        );
    }

    private static ItemStack setAlly1(Kingdom kd){
        return Items.generateItem(
                "Ally1",
                Material.TOTEM_OF_UNDYING
        );
    }

    private static String getAlly1(Kingdom kd){
        return null;
    }

    private static ItemStack setAlly2(Kingdom kd){
        return Items.generateItem(
                "Ally1",
                Material.TOTEM_OF_UNDYING
        );
    }

    private static String getAlly2(Kingdom kd){
        return null;
    }

    private static ItemStack setGovernment(Kingdom kd){
        return Items.generateItem(
                "government",
                Material.GOLD_BLOCK
        );
    }

    private static ItemStack setAbout(){
        return Items.generateItem(
                "about",
                Material.BOOK
        );
    }

    private static ItemStack setPoints(Kingdom kd){
        return Items.generateItem(
                "points",
                Material.AMETHYST_CLUSTER
        );
    }

    private static ItemStack setWarScore(){
        return Items.generateItem(
                "warScore",
                Material.WOODEN_SWORD
        );
    }

    private static ItemStack setDiscordLink(){
        return Items.generateItem(
                "discordLink",
                Material.FIREWORK_ROCKET,
                List.of("Discord Link","discord.gg","-----------","click to get message link"),
                false
        );
    }

    private static ItemStack setMedals(){
        return Items.generateItem(
                "medals",
                Material.SUNFLOWER
        );
    }

    private static ItemStack setOnlinePlayers(Kingdom kd){
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

        return Items.generateItem(
                "(" + kd.getOnlinePlayers().size() + ")OnlinePlayerList",
                Material.GREEN_BED,
                players,
                false
        );
    }

    private static ItemStack setOfflinePlayers(Kingdom kd){
        List<UUID> players = kd.getMemberList();

        for(Player p : kd.getOnlinePlayers()){
            players.remove(p.getUniqueId());
        }

        String aFewPlayers = ChatColor.RED + "";
        int count = 0;
        ArrayList<String> sPlayers = new ArrayList<>();
        for(UUID p : players){
            String playerName = UltimateKingdom.Players().getPlayer(p).getName();
            if(kd.getOnlinePlayers().indexOf(Bukkit.getPlayer(p)) == (kd.getOnlinePlayers().size() -1)){
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

        return Items.generateItem(
                "(" + sPlayers.size() + ")OfflinePlayerList",
                Material.RED_BED,
                sPlayers,
                false
        );
    }
}
