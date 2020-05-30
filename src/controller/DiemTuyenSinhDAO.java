package controller;

import entity.DiemTuyenSinh;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tungdd
 */
public class DiemTuyenSinhDAO extends DAO {

    private String orderBy = "namThi";
    private String orderDir = "DESC";
    private String table = "diem_tuyen_sinh";

    public DiemTuyenSinhDAO() {
        super();
    }

    public boolean addItem(DiemTuyenSinh item) {
        String sql = "INSERT INTO " + table + "(maNganh, diemChuan, chiTieu, namThi) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getDiemChuan());
            ps.setString(3, item.getChiTieu());
            ps.setString(4, item.getNamThi());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateItem(DiemTuyenSinh item) {
        String sql = "UPDATE " + table + " SET diemChuan = ?, chiTieu = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getDiemChuan());
            ps.setString(2, item.getChiTieu());

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
        String sql = "DELETE FROM " + table + " WHERE maNganh = ? AND namThi = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getNamThi());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<DiemTuyenSinh> getListItem() {
        ArrayList<DiemTuyenSinh> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiemTuyenSinh item = new DiemTuyenSinh();

                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getString("diemChuan"));
                item.setChiTieu(rs.getString("chiTieu"));
                item.setNamThi(rs.getString("namThi"));

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
