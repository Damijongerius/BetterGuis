package com.me.dami.activabetterinterface.Badge.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBadge extends Connector {

    public void RemoveBadge(int id) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM tp_Badge WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
    }

    /**
     * @SQL this will delete all saved badges to kingdoms
     */
    public void RemoveKingdomBadges(String kingdom) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM KingdomBadge WHERE name = ?");
        statement.setString(1, kingdom);
        statement.executeUpdate();
    }

    /**
     * @SQL this will delete every a badge from every kingdom
     */
    public void RemoveKingdomBadges(int id) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM KingdomBadge WHERE tp_Badge_ID = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    public void RemovePlayerBadges(String player) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM PlayerBadge WHERE Player_UUID = ?");
        statement.setString(1, player);
        statement.executeUpdate();
    }
}
