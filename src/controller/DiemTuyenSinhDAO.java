package controller;

import entity.DiemTuyenSinh;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tuanndm
 */
public class DiemTuyenSinhDAO extends DAO {

    private String orderBy = "namThi";
    private String orderDir = "DESC";
    private String table = "diem_tuyen_sinh";

    public DiemTuyenSinhDAO() {
        super();
    }

    public boolean addItem(DiemTuyenSinh item) {
        String sql = "INSERT INTO " + table + "(maNganh, diemChuan, chiTieu, namThi, khoiThi_id) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getDiemChuan());
            ps.setString(3, item.getChiTieu());
            ps.setString(4, item.getNamThi());
            ps.setInt(5, item.getKhoiThi_id());

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
        String sql = "DELETE FROM " + table + " WHERE maNganh = ? AND namThi = ? AND khoiThi_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getNamThi());
            ps.setInt(3, item.getKhoiThi_id());

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
        String sql = "SELECT * FROM " + table + " INNER JOIN khoi_thi ON diem_tuyen_sinh.khoiThi_id = khoi_thi.maKhoi ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiemTuyenSinh item = new DiemTuyenSinh();

                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getString("diemChuan"));
                item.setChiTieu(rs.getString("chiTieu"));
                item.setNamThi(rs.getString("namThi"));
                item.setKhoiThi_id(rs.getInt("khoiThi_id"));
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

    public DiemTuyenSinh getItemByCode(String maNganh, int maKhoi, String namThi) {
        DiemTuyenSinh item = new DiemTuyenSinh();
        String sql = "SELECT * FROM " + table + " WHERE maNganh = ? AND khoiThi_id = ? AND namThi = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, maNganh);
            ps.setInt(2, maKhoi);
            ps.setString(3, namThi);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getString("diemChuan"));
                item.setChiTieu(rs.getString("chiTieu"));
                item.setNamThi(rs.getString("namThi"));
                item.setKhoiThi_id(rs.getInt("khoiThi_id"));
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}
