package controller;

import java.sql.*;
import java.util.ArrayList;
import entity.DiemThi;

/**
 *
 * @author tungdd
 */
public class DiemThiDAO extends DAO {

    private String table = "diem_thi";

    public DiemThiDAO() {
        super();
    }

    public boolean updateItem(DiemThi dt) {
        String sql = "UPDATE " + table + " SET diem = ? WHERE thiSinh_id = ? AND monThi_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dt.getDiem());
            ps.setString(2, dt.getThiSinh_id());
            ps.setInt(3, dt.getMonThi_id());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addItem(DiemThi dt) {
        String sql = "INSERT INTO " + table + "(thiSinh_id, monThi_id, diem) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dt.getThiSinh_id());
            ps.setInt(2, dt.getMonThi_id());
            ps.setString(3, dt.getDiem());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteItem(DiemThi item) {
        String sql = "DELETE FROM " + table + " WHERE thiSinh_id = ? AND monThi_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getThiSinh_id());
            ps.setInt(2, item.getMonThi_id());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<DiemThi> getListItem(String maThiSinh) {
        ArrayList<DiemThi> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN mon_thi ON diem_thi.monThi_id = mon_thi.maMon WHERE thiSinh_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, maThiSinh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiemThi item = new DiemThi();
                item.setThiSinh_id(rs.getString("thiSinh_id"));
                item.setMonThi_id(rs.getInt("monThi_id"));
                item.setDiem(rs.getString("diem"));
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
