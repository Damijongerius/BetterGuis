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
     * @SQL this will delete all saved badges to ....
     */
    public void RemoveBadgesFrom(String object) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM LinkedBadge WHERE Name = ?");
        statement.setString(1, object);
        statement.executeUpdate();
    }

    /**
     * @SQL this will delete every Link from badge
     */
    public void RemoveBadgesFrom(int id) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM LinkedBadge WHERE tp_Badge_ID = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

}
