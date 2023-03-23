package com.me.dami.activabetterinterface.Badge.DB;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class InsertBadge extends Connector {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public int InsertNewBadge(String name, String description) throws SQLException {

        int id = -1;
        String query = "INSERT INTO tp_Badge (Name, Description) VALUES (?, ?)";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, description);
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }
        return id;
    }

    public boolean InsertBadgeIntoKingdom(int badge, String kingdom, int placement) throws SQLException {

        String query = "INSERT INTO KingdomBadge (tp_Badge_ID, UnlockDate, Placement, Kingdom_Name) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setInt(1, badge);

        Date currentDate = new Date();
        String dateString = formatter.format(currentDate);
        ps.setDate(2, java.sql.Date.valueOf(dateString));
        ps.setInt(3, placement);
        ps.setString(4,kingdom);
        return true;
    }
    public boolean InsertBadgeIntoKingdom(int badge, String kingdom) throws SQLException {

        String query = "INSERT INTO KingdomBadge (tp_Badge_ID, UnlockDate, Kingdom_Name) VALUES (?, ?, ?)";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setInt(1, badge);

        Date currentDate = new Date();
        String dateString = formatter.format(currentDate);
        ps.setDate(2, java.sql.Date.valueOf(dateString));
        ps.setString(3,kingdom);
        return true;
    }

    public boolean InsertBadgeIntoPlayer(int badge, String player) throws SQLException {
        String query = "INSERT INTO PlayerBadge (tp_Badge_ID, UnlockDate, player) VALUES (?, ?, ?)";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setInt(1, badge);

        Date currentDate = new Date();
        String dateString = formatter.format(currentDate);
        ps.setDate(2, java.sql.Date.valueOf(dateString));
        ps.setString(3,player);
        return true;
    }
}
