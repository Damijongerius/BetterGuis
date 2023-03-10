package com.me.dami.activabetterinterface.Base;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TextConverter {

    public static String CheckString(String string){
        String clean = "";
        boolean color = false;
            for(char character : string.toCharArray()){
                if(color){
                    clean += GetColor(character);
                    color = false;
                    continue;
                }
                if(character == '&'){
                    color = true;
                }else{
                    clean += character;
                }
            }
        return clean;
    }

    private static ChatColor GetColor(char character){
        return switch (character){
            case '0' -> ChatColor.BLACK;
            case '1' -> ChatColor.DARK_BLUE;
            case '2' -> ChatColor.DARK_GREEN;
            case '3' -> ChatColor.DARK_AQUA;
            case '4' -> ChatColor.DARK_RED;
            case '5' -> ChatColor.DARK_PURPLE;
            case '6' -> ChatColor.GOLD;
            case '7' -> ChatColor.GRAY;
            case '8' -> ChatColor.DARK_GRAY;
            case '9' -> ChatColor.BLUE;
            case 'a' -> ChatColor.GREEN;
            case 'b' -> ChatColor.AQUA;
            case 'c' -> ChatColor.RED;
            case 'd' -> ChatColor.LIGHT_PURPLE;
            case 'e' -> ChatColor.YELLOW;
            case 'f' -> ChatColor.WHITE;
            default -> null;
        };
    }
}
