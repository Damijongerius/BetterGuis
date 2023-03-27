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
    private List<Kingdom> kingdoms = new ArrayList<>();

    private List<Player> players = new ArrayList<>();

    private List<Badge> badges = new ArrayList<>();

    private InsertBadge insertBadge =  new InsertBadge();
    private DeleteBadge deleteBadge =  new DeleteBadge();

    public boolean addBadge(String name, String description){
        try {
            int id = insertBadge.newBadge(name,description);
            badges.add(new Badge(id,name,description));
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public void removeBadge(int id){
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
    public void removeBadge(String name){
        for(Badge badge : badges){
            if(Objects.equals(badge.getName(), name)){
                try {
                    deleteBadge.RemoveBadge(badge.getId());
                } catch (SQLException ignored) {}
            }
        }
    }
    public List<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setKingdoms(List<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void saveToDatabase(){

    }

}
