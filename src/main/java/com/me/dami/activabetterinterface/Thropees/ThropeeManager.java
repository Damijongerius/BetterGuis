package com.me.dami.activabetterinterface.Thropees;

import com.me.dami.activabetterinterface.Base.Thropee;
import me.map.ultimatekingdom.API.UltimateKingdom;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * contains all info of thropies and who has what
 */
public class ThropeeManager{

    private static Map<UUID, List<Thropee>> playerTrophies = new LinkedHashMap<>();
    private static Map<String, List<Thropee>> KingdomTrophies = new LinkedHashMap<>();
    private static Map<Integer, Thropee> trophies = new LinkedHashMap<>();


    public static List<Thropee> GetTrophies(){

        return null;
    }


    //public static void AddThop
}
