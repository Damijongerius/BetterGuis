package com.me.dami.activabetterinterface.Badge.DB;

import com.me.dami.activabetterinterface.Base.Badge;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectBadge extends Connector {

    public List<Badge> GetBadges(String uuid) throws SQLException {
        String query = "SELECT * FROM Badge";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, uuid);

        ResultSet resultSet = ps.executeQuery();

        List<Badge> badges = new ArrayList<>();
        while (resultSet.next()) {
            badges.add(
                    new Badge(
                            resultSet.getInt("ID"),
                            resultSet.getString("Name"),
                            resultSet.getString("Description")
                    )
            );
        }

        return badges;
    }

    public List<Integer> GetPlayerBadges(String uuid) throws SQLException {
        String query = "SELECT * FROM PlayerBadge WHERE Player_UUID = ?";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, uuid);

        ResultSet resultSet = ps.executeQuery();

        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("tp_Badge_ID"));
        }

        return ids;
    }

    public List<Integer> GetKingdomBadges(String kingdom) throws SQLException {
        String query = "SELECT * FROM KingdomBadge WHERE Kingdom_Name = ?";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, kingdom);

        ResultSet resultSet = ps.executeQuery();

        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("tp_Badge_ID"));
        }

        return ids;
    }

}
