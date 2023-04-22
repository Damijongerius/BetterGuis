package com.me.dami.activabetterinterface.Base;

import com.me.dami.activabetterinterface.Badge.DB.DeleteBadge;
import com.me.dami.activabetterinterface.Badge.DB.InsertBadge;
import com.me.dami.activabetterinterface.Badge.Savable.Badge;
import com.me.dami.activabetterinterface.Badge.Savable.Kingdom;
import com.me.dami.activabetterinterface.Badge.Savable.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Saveable {
    private static List<Kingdom> kingdoms = new ArrayList<>();

    private static List<Player> players = new ArrayList<>();

    private static List<Badge> badges = new ArrayList<>();

    private static InsertBadge insertBadge =  new InsertBadge();
    private static DeleteBadge deleteBadge =  new DeleteBadge();

    public static boolean addBadge(String name, String description){
        try {
            int id = insertBadge.newBadge(name,description);
            badges.add(new Badge(id,name,description));
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void removeBadge(int id){
        try {
            deleteBadge.RemoveBadge(id);
            for(Badge badge : badges){
                if(badge.getId() == id){
                    badges.remove(badge);
                    return;
                }
            }
        } catch (SQLException ignored) {}
    }


    /**
     * @warning note that this will remove every badge with this name
     */
    public static void removeBadge(String name){
        for(Badge badge : badges){
            if(Objects.equals(badge.getName(), name)){
                try {
                    deleteBadge.RemoveBadge(badge.getId());
                } catch (SQLException ignored) {}
            }
        }
    }
    public static List<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public static Kingdom getKingdom(String name){
        for(Kingdom kd : kingdoms){
            if(kd.getName().equals(name)){
                return kd;
            }
        }
        return null;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void setKingdoms(List<Kingdom> _kingdoms) {
        kingdoms = _kingdoms;
    }

    public static void setPlayers(List<Player> _players) {
        players = _players;
    }

    public void saveToDatabase(){

    }

}
