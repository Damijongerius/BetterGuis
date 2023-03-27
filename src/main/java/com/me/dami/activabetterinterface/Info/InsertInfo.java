package com.me.dami.activabetterinterface.Info;

import com.me.dami.activabetterinterface.Badge.DB.Connector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class InsertInfo extends Connector {
    public boolean IntoPlayer(UUID player, String annotation) throws SQLException {

        String query = "INSERT INTO tp_Player (UUID,Annotation)  VALUES (?, ?)";
        PreparedStatement ps = Connection().prepareStatement(query);

        ps.setString(1, player.toString());
        ps.setString(2,annotation);
        return true;
    }

    public boolean IntoKingdom(String kingdom, String discordLink, String about) throws SQLException {

        String query = "INSERT INTO tp_Kingdom (Name, DiscordLink, about) VALUES (?, ?, ?)";
        PreparedStatement ps = Connection().prepareStatement(query);

        ps.setString(1, kingdom);
        ps.setString(2, discordLink);
        ps.setString(3, about);

        return true;
    }
}
