package controller;

import entity.KhoiThi;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tungdd
 */
public class KhoiThiDAO extends DAO {

    private final String orderBy = "tenKhoi";
    private final String orderDir = "ASC";
    private final String table = "khoi_thi";

    public KhoiThiDAO() {
        super();
    }

    public ArrayList<KhoiThi> getListItem() {
        ArrayList<KhoiThi> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhoiThi item = new KhoiThi();

                item.setMaKhoi(rs.getInt("maKhoi"));
                item.setTenKhoi(rs.getString("tenKhoi"));

                items.add(item);
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
