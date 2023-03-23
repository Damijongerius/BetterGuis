package com.me.dami.activabetterinterface.Badge.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBadge extends Connector {

    public void UpdateExistingBadge(int id, String name, String description) throws SQLException {
        PreparedStatement pstmt = Connection().prepareStatement("UPDATE  SET Name = ?, Description = ? WHERE ID = ?");

            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
        }
}
