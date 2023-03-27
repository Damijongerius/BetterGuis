package com.me.dami.activabetterinterface.Badge.Savable;

import com.me.dami.activabetterinterface.ActivaBetterInterface;
import com.me.dami.activabetterinterface.Badge.DB.InsertBadge;
import com.me.dami.activabetterinterface.Base.ConfigurationManager;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Kingdom {

    private final String name;

    private List<LinkedBadge> unSavedBadges = new ArrayList<>();
    private List<LinkedBadge> badges = new ArrayList<>();
    InsertBadge insertBadge = new InsertBadge();
    public Kingdom(String name){
        this.name = name;
    }

    public String getName() {
        return name;
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
                insertBadge.Into(badge.getId(),badge.getUnlockDate(),badge.getPlacement(),name);
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
