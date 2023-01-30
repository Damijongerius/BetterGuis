package com.me.dami.activabetterinterface.Thropees;

import com.me.dami.activabetterinterface.Base.Trophy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * contains all info of thropies and who has what
 */
public class ThropeeManager{

    private static Map<UUID, List<Trophy>> playerTrophies = new LinkedHashMap<>();
    private static Map<String, List<Trophy>> KingdomTrophies = new LinkedHashMap<>();
    private static Map<Integer, Trophy> trophies = new LinkedHashMap<>();


    public static List<Trophy> GetTrophies(){

        return null;
    }


    //public static void AddThop
}
