package controller;

import java.sql.*;
import java.util.ArrayList;
import entity.MonThi;

/**
 *
 * @author tungdd
 */
public class MonThiDAO extends DAO {

    private final String orderBy = "tenMon";
    private final String orderDir = "ASC";
    private final String table = "mon_thi";

    public MonThiDAO() {
        super();
    }

    public ArrayList<MonThi> getListItem() {
        ArrayList<MonThi> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MonThi item = new MonThi();

                item.setMaMon(rs.getString("maMon"));
                item.setTenMon(rs.getString("tenMon"));

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
