package com.me.dami.activabetterinterface.Badge.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBadge extends Connector {

    public void UpdateBadge(int id, String name, String Description) throws SQLException {
        PreparedStatement pstmt = Connection().prepareStatement("UPDATE  SET Name = ?, Description = ? WHERE ID = ?");

            pstmt.setString(1, name);
            pstmt.setString(2, Description);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
        }
}
