package com.me.dami.activabetterinterface.Info;

import com.me.dami.activabetterinterface.Badge.DB.Connector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteInfo extends Connector {

    public void removePlayerInfo(int id) throws SQLException {
        PreparedStatement statement = Connection().prepareStatement("DELETE FROM tp_Player WHERE Name = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
