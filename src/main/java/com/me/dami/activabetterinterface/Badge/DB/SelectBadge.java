package com.me.dami.activabetterinterface.Badge.DB;

import com.me.dami.activabetterinterface.Badge.Savable.Badge;
import com.me.dami.activabetterinterface.Badge.Savable.LinkedBadge;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectBadge extends Connector {

    public List<Badge> getBadges() throws SQLException {
        String query = "SELECT * FROM Badge";
        PreparedStatement ps = Connection().prepareStatement(query);

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

    public List<Integer> getBadgesFrom(String object) throws SQLException {
        String query = "SELECT * FROM PlayerBadge WHERE Name = ?";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, object);

        ResultSet resultSet = ps.executeQuery();

        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("tp_Badge_ID"));
        }

        return ids;
    }

    public List<LinkedBadge> getAllFrom(String object) throws SQLException {
        String query = "SELECT * FROM PlayerBadge WHERE Name = ?";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, object);

        ResultSet resultSet = ps.executeQuery();

        List<LinkedBadge> badges = new ArrayList<>();
        while (resultSet.next()) {
            badges.add(new LinkedBadge(resultSet.getInt("tp_Badge_ID"),
                    java.sql.Date.valueOf(resultSet.getDate("UnlockDate").toLocalDate()),
                    resultSet.getInt("Placement")
            ));
        }

        return badges;
    }
}
