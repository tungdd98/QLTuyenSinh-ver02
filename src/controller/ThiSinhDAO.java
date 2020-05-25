package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.ThiSinh;

/**
 *
 * @author tungdd
 */
public class ThiSinhDAO extends DAO {

    private String orderBy = "hoTen";
    private String orderDir = "DESC";

    public ThiSinhDAO() {
        super();
    }

    public boolean addItem(ThiSinh ts) {
        String sql = "INSERT INTO thi_sinh(maThiSinh, hoTen, ngaySinh, gioiTinh, CMND, danToc, soDienThoai, queQuan) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ts.getMaThiSinh());
            ps.setString(2, ts.getHoTen());
            ps.setDate(3, new Date(ts.getNgaySinh().getTime()));
            ps.setString(4, ts.getGioiTinh());
            ps.setString(5, ts.getCMND());
            ps.setString(6, ts.getDanToc());
            ps.setString(7, ts.getSoDienThoai());
            ps.setString(8, ts.getQueQuan());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateItem(ThiSinh ts) {
        String sql = "UPDATE thi_sinh SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, CMND = ?, danToc = ?, soDienThoai = ?, queQuan = ? WHERE maThiSinh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ts.getHoTen());
            ps.setDate(2, new Date(ts.getNgaySinh().getTime()));
            ps.setString(3, ts.getGioiTinh());
            ps.setString(4, ts.getCMND());
            ps.setString(5, ts.getDanToc());
            ps.setString(6, ts.getSoDienThoai());
            ps.setString(7, ts.getQueQuan());
            ps.setString(8, ts.getMaThiSinh());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(ThiSinh ts) {
        String sql = "DELETE FROM thi_sinh WHERE maThiSinh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ts.getMaThiSinh());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }

        return false;
    }

    public ArrayList<ThiSinh> getListItem() {
        ArrayList<ThiSinh> items = new ArrayList<>();
        String sql = "SELECT * FROM thi_sinh ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ThiSinh ts = new ThiSinh();
                ts.setMaThiSinh(rs.getString("maThiSinh"));
                ts.setHoTen(rs.getString("hoTen"));
                ts.setNgaySinh(rs.getDate("ngaySinh"));
                ts.setGioiTinh(rs.getString("gioiTinh"));
                ts.setDanToc(rs.getString("danToc"));
                ts.setCMND(rs.getString("CMND"));
                ts.setSoDienThoai(rs.getString("soDienThoai"));
                ts.setQueQuan(rs.getString("queQuan"));

                items.add(ts);
            }
        } catch (SQLException e) {
        }
        return items;
    }

    public ArrayList<ThiSinh> searchItem(String query, String field) {
        ArrayList<ThiSinh> items = new ArrayList<>();
        String sql = "";
        switch (field) {
            case "maThiSinh":
                sql = "SELECT * from thi_sinh WHERE maThiSinh = ?";
                break;
            case "CMND":
                sql = "SELECT * from thi_sinh WHERE CMND = ?";
                break;
            case "hoTen":
                sql = "SELECT * FROM thi_sinh WHERE hoTen LIKE % ? %";
                break;
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThiSinh ts = new ThiSinh();
                ts.setMaThiSinh(rs.getString("maThiSinh"));
                ts.setHoTen(rs.getString("hoTen"));
                ts.setNgaySinh(rs.getDate("ngaySinh"));
                ts.setGioiTinh(rs.getString("gioiTinh"));
                ts.setDanToc(rs.getString("danToc"));
                ts.setCMND(rs.getString("CMND"));
                ts.setSoDienThoai(rs.getString("soDienThoai"));
                ts.setQueQuan(rs.getString("queQuan"));

                items.add(ts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

}
