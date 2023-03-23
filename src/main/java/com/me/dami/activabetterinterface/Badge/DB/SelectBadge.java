package com.me.dami.activabetterinterface.Badge.DB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectBadge extends Connector {

    public void main() {
        try {
            PreparedStatement ps = Connection().prepareStatement("SELECT * FROM mytable WHERE name = ?");
            ps.setString(1, "John");

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

            }

            resultSet.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetPlayerBadges(String UUID) throws SQLException {
        String query = "SELECT * FROM PlayerBadge WHERE Player_UUID = ?";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, UUID);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int badge = resultSet.getInt("id");
            int Placement = resultSet.getInt("Placement");
            Date UnlockDate = resultSet.getDate("UnlockDate");
        }
    }

    public void GetKingdomBadges(String kingdom) throws SQLException {
        String query = "SELECT * FROM KingdomBadge WHERE Kingdom_Name = ?";
        PreparedStatement ps = Connection().prepareStatement(query);
        ps.setString(1, kingdom);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int badge = resultSet.getInt("id");
            int Placement = resultSet.getInt("Placement");
            Date UnlockDate = resultSet.getDate("UnlockDate");
        }
    }

}
