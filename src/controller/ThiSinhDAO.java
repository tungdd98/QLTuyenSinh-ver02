package controller;

import java.sql.*;
import java.util.ArrayList;
import entity.ThiSinh;

/**
 *
 * @author tungdd
 */
public class ThiSinhDAO extends DAO {

    private final String orderBy = "hoTen";
    private final String orderDir = "DESC";
    private final String table = "thi_sinh";

    public ThiSinhDAO() {
        super();
    }

    public boolean addItem(ThiSinh item) {
        String sql = "INSERT INTO " + table + "(maThiSinh, hoTen, ngaySinh, gioiTinh, CMND, danToc, soDienThoai, queQuan) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaThiSinh());
            ps.setString(2, item.getHoTen());
            ps.setDate(3, new Date(item.getNgaySinh().getTime()));
            ps.setInt(4, item.getGioiTinh());
            ps.setString(5, item.getCMND());
            ps.setString(6, item.getDanToc());
            ps.setString(7, item.getSoDienThoai());
            ps.setString(8, item.getQueQuan());
            
            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateItem(ThiSinh item) {
        String sql = "UPDATE " + table + " SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, CMND = ?, danToc = ?, soDienThoai = ?, queQuan = ? WHERE maThiSinh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getHoTen());
            ps.setDate(2, new Date(item.getNgaySinh().getTime()));
            ps.setInt(3, item.getGioiTinh());
            ps.setString(4, item.getCMND());
            ps.setString(5, item.getDanToc());
            ps.setString(6, item.getSoDienThoai());
            ps.setString(7, item.getQueQuan());
            ps.setString(8, item.getMaThiSinh());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(ThiSinh item) {
        String sql = "DELETE FROM " + table + " WHERE maThiSinh = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getMaThiSinh());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
        }

        return false;
    }

    public ArrayList<ThiSinh> getListItem() {
        ArrayList<ThiSinh> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ThiSinh item = new ThiSinh();
                item.setMaThiSinh(rs.getString("maThiSinh"));
                item.setHoTen(rs.getString("hoTen"));
                item.setNgaySinh(rs.getDate("ngaySinh"));
                item.setGioiTinh(rs.getInt("gioiTinh"));
                item.setDanToc(rs.getString("danToc"));
                item.setCMND(rs.getString("CMND"));
                item.setSoDienThoai(rs.getString("soDienThoai"));
                item.setQueQuan(rs.getString("queQuan"));

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

    public ArrayList<ThiSinh> searchItem(String query, String field) {
        ArrayList<ThiSinh> items = new ArrayList<>();
        String sql = "";
        switch (field) {
            case "maThiSinh":
                sql = "SELECT * from " + table + " WHERE maThiSinh = ?";
                break;
            case "CMND":
                sql = "SELECT * from " + table + " WHERE CMND = ?";
                break;
            case "hoTen":
                sql = "SELECT * FROM " + table + " WHERE hoTen LIKE '%?%'";
                break;
        }
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ThiSinh item = new ThiSinh();
                item.setMaThiSinh(rs.getString("maThiSinh"));
                item.setHoTen(rs.getString("hoTen"));
                item.setNgaySinh(rs.getDate("ngaySinh"));
                item.setGioiTinh(rs.getInt("gioiTinh"));
                item.setDanToc(rs.getString("danToc"));
                item.setCMND(rs.getString("CMND"));
                item.setSoDienThoai(rs.getString("soDienThoai"));
                item.setQueQuan(rs.getString("queQuan"));

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

    public ArrayList<ThiSinh> getResultScore(String totalScore, int maKhoi) {
        ArrayList<ThiSinh> items = new ArrayList<>();
        String sql = "SELECT thi_sinh.maThiSinh, hoTen, ngaySinh, gioiTinh, CMND, danToc, soDienThoai, queQuan, SUM(diem) "
                + "FROM thi_sinh "
                + "INNER JOIN diem_thi ON thi_sinh.maThiSinh = diem_thi.thiSinh_id "
                + "INNER JOIN monthi_khoithi ON diem_thi.monThi_id = monthi_khoithi.monThi_id "
                + "WHERE khoiThi_id = ? "
                + "GROUP BY thi_sinh.maThiSinh, hoTen, ngaySinh, gioiTinh, CMND, danToc, soDienThoai, queQuan "
                + "HAVING SUM(diem) >= ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, maKhoi);
            ps.setString(2, totalScore);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThiSinh item = new ThiSinh();
                item.setMaThiSinh(rs.getString("maThiSinh"));
                item.setHoTen(rs.getString("hoTen"));
                item.setNgaySinh(rs.getDate("ngaySinh"));
                item.setGioiTinh(rs.getInt("gioiTinh"));
                item.setDanToc(rs.getString("danToc"));
                item.setCMND(rs.getString("CMND"));
                item.setSoDienThoai(rs.getString("soDienThoai"));
                item.setQueQuan(rs.getString("queQuan"));

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
