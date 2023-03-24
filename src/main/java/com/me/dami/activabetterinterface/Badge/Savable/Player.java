package com.me.dami.activabetterinterface.Badge.Savable;

import com.me.dami.activabetterinterface.Badge.DB.InsertBadge;

import java.sql.SQLException;
import java.util.*;

public class Player {

    private final UUID uuid;

    private List<LinkedBadge> unSavedBadges = new ArrayList<>();
    private List<LinkedBadge> badges = new ArrayList<>();

    InsertBadge insertBadge = new InsertBadge();
    public Player(org.bukkit.entity.Player player){
        uuid = player.getUniqueId();
    }

    public UUID getUUID() {
        return uuid;
    }

    public boolean addBadge(LinkedBadge badge){
        if(badges.contains(badge) || unSavedBadges.contains(badge)){
            return false;
        }
        unSavedBadges.add(badge);
        return true;
    }

    public void removeBadge(LinkedBadge badge){
        if(badges.contains(badge)){
            badges.remove(badge);
        }

        if(unSavedBadges.contains(badge)){
            unSavedBadges.remove(badge);
        }
    }

    public Map<String,Object> saveBadges(){
        List<LinkedBadge> failedBadges = new ArrayList<>();
        for(LinkedBadge badge : unSavedBadges){
            try {
                insertBadge.IntoPlayer(badge.getId(),badge.getUnlockDate(),badge.getPlacement(),uuid.toString());
                badges.add(badge);
            } catch (SQLException e) {
                failedBadges.add(badge);
            }
        }
        unSavedBadges.clear();
        if(failedBadges.size() > 0){
            Map<String,Object> mapBadges = new LinkedHashMap<>();
            for(int i = 0; i  < failedBadges.size(); i++){
                mapBadges.put("" + i, failedBadges.get(i).toConfig());
            }
            return mapBadges;
        }
        return Collections.emptyMap();
    }
}
