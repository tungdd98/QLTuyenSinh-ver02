package controller;

import entity.NganhThi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuanndm
 */
public class NganhThiDAO extends DAO {

    private String orderBy = "tenNganh";
    private String orderDir = "ASC";

    public NganhThiDAO() {
        super();
    }

    public boolean addItem(NganhThi item) {
        String sql = "INSERT INTO nganh_thi(maNganh, tenNganh) VALUES(?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getTenNganh());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateItem(NganhThi item) {
        String sql = "UPDATE nganh_thi SET tenNganh = ? WHERE maNganh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getTenNganh());
            ps.setString(2, item.getMaNganh());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(NganhThi item) {
        String sql = "DELETE FROM nganh_thi WHERE maNganh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getMaNganh());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }

        return false;
    }

    public ArrayList<NganhThi> getListItem() {
        ArrayList<NganhThi> items = new ArrayList<>();
        String sql = "SELECT * FROM nganh_thi ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NganhThi item = new NganhThi();

                item.setMaNganh(rs.getString("maNganh"));
                item.setTenNganh(rs.getString("tenNganh"));

                items.add(item);
            }
        } catch (SQLException e) {
        }
        return items;
    }
}
