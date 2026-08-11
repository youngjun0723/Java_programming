package net.jyj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import member.DBConnectionMgr;

public class TalkMgr {

    private DBConnectionMgr pool;

    public TalkMgr() {
        pool = DBConnectionMgr.getInstance();
    }

    public boolean loginChk(String id, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isSuccess = false;

        try {
            conn = pool.getConnection();
            String query = "SELECT pwd FROM tblRegister WHERE id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPwd = rs.getString("pwd");
                if (dbPwd != null && dbPwd.equals(pwd)) {
                    isSuccess = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(conn, pstmt, rs);
        }

        return isSuccess;
    }
}