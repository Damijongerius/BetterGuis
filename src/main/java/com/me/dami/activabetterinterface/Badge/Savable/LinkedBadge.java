package com.me.dami.activabetterinterface.Badge.Savable;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedBadge {
    private final int id;
    private final Date unlockDate;
    private final int placement;

    public LinkedBadge(int id, int placement) {
        this.id = id;
        this.unlockDate = new Date();
        this.placement = placement;
    }

    public LinkedBadge(int id, Date unlockDate, int placement) {
        this.id = id;
        this.unlockDate = unlockDate;
        this.placement = placement;
    }

    public int getId() {
        return id;
    }

    public Date getUnlockDate() {
        return unlockDate;
    }

    public int getPlacement() {
        return placement;
    }

    public Map<String, Object> toConfig(){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("id",  id);
        data.put("unlockDate", unlockDate);
        data.put("placement", placement);

        return data;
    }
}
