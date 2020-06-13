package controller;

import java.sql.*;
import java.util.ArrayList;
import entity.DiemTuyenSinh;

/**
 *
 * @author tungdd
 */
public class DiemTuyenSinhDAO extends DAO {

    private final String table = "diem_tuyen_sinh";

    public DiemTuyenSinhDAO() {
        super();
    }

    public boolean updateItem(DiemTuyenSinh item) {
        String sql = "UPDATE " + table + " SET diem = ? WHERE maThiSinh = ? AND maMon = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setFloat(1, item.getDiem());
            ps.setString(2, item.getMaThiSinh());
            ps.setString(3, item.getMaMon());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addItem(DiemTuyenSinh item) {
        String sql = "INSERT INTO " + table + "(maThiSinh, maMon, diem) VALUES(?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaThiSinh());
            ps.setString(2, item.getMaMon());
            ps.setFloat(3, item.getDiem());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteItem(DiemTuyenSinh item) {
        String sql = "DELETE FROM " + table + " WHERE maThiSinh = ? AND maMon = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaThiSinh());
            ps.setString(2, item.getMaMon());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<DiemTuyenSinh> getListItem(String maThiSinh) {
        ArrayList<DiemTuyenSinh> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN mon_thi ON diem_tuyen_sinh.maMon = mon_thi.maMon WHERE maThiSinh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, maThiSinh);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiemTuyenSinh item = new DiemTuyenSinh();
                item.setMaThiSinh(rs.getString("maThiSinh"));
                item.setMaMon(rs.getString("maMon"));
                item.setDiem(rs.getFloat("diem"));
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
    
    public ArrayList<DiemTuyenSinh> searchItem(String query, String maMon, String field) {
        ArrayList<DiemTuyenSinh> items = new ArrayList<>();
        String sql = "";
        String bonusSql = "".equals(maMon) ? "" : " AND diem_tuyen_sinh.maMon = '" + maMon + "'";
        switch (field) {
            case "maThiSinh":
                sql = "SELECT diem_tuyen_sinh.maThiSinh, diem_tuyen_sinh.maMon, diem, tenMon FROM " + table + " "
                        + "INNER JOIN mon_thi ON diem_tuyen_sinh.maMon = mon_thi.maMon "
                        + "WHERE diem_tuyen_sinh.maThiSinh = '" + query + "'" + bonusSql;
                break;
            case "CMND":
                sql = "SELECT diem_tuyen_sinh.maThiSinh, diem_tuyen_sinh.maMon, tenMon, diem FROM " + table + " "
                        + "INNER JOIN mon_thi ON diem_tuyen_sinh.maMon = mon_thi.maMon "
                        + "INNER JOIN thi_sinh ON thi_sinh.maThiSinh = diem_tuyen_sinh.maThiSinh "
                        + "WHERE thi_sinh.CMND = '" + query + "'" + bonusSql;
                break;
            case "hoTen":
                sql = "SELECT diem_tuyen_sinh.maThiSinh, diem_tuyen_sinh.maMon, tenMon, diem FROM " + table + " "
                        + "INNER JOIN mon_thi ON diem_tuyen_sinh.maMon = mon_thi.maMon "
                        + "INNER JOIN thi_sinh ON thi_sinh.maThiSinh = diem_tuyen_sinh.maThiSinh "
                        + "WHERE thi_sinh.hoTen LIKE '%" + query + "%'" + bonusSql;
                break;
        }
        try {
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery(sql);

            while (rs.next()) {
                DiemTuyenSinh item = new DiemTuyenSinh();

                item.setMaThiSinh(rs.getString("maThiSinh"));
                item.setTenMon(rs.getString("tenMon"));
                item.setMaMon(rs.getString("maMon"));
                item.setDiem(rs.getFloat("diem"));

                items.add(item);
            }
            rs.close();
            sm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
