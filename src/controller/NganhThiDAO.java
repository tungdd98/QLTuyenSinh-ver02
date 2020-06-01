package controller;

import entity.NganhThi;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tuanndm
 */
public class NganhThiDAO extends DAO {

    private final String orderBy = "tenNganh";
    private final String orderDir = "ASC";
    private final String table = "nganh_thi";

    public NganhThiDAO() {
        super();
    }

    public boolean addItem(NganhThi item) {
        String sql = "INSERT INTO " + table + "(maNganh, tenNganh) VALUES(?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getTenNganh());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateItem(NganhThi item) {
        String sql = "UPDATE " + table + " SET tenNganh = ? WHERE maNganh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getTenNganh());
            ps.setString(2, item.getMaNganh());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(NganhThi item) {
        String sql = "DELETE FROM " + table + " WHERE maNganh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getMaNganh());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<NganhThi> getListItem() {
        ArrayList<NganhThi> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NganhThi item = new NganhThi();

                item.setMaNganh(rs.getString("maNganh"));
                item.setTenNganh(rs.getString("tenNganh"));

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
