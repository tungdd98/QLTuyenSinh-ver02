package controller;

import entity.DiemChuan;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author tuanndm
 */
public class DiemChuanDAO extends DAO {

    private final String orderBy = "namThi, maNganh";
    private final String orderDir = "DESC";
    private final String table = "diem_chuan";

    public DiemChuanDAO() {
        super();
    }

    public boolean addItem(DiemChuan item) {
        String sql = "INSERT INTO " + table + "(maNganh, diemChuan, chiTieu, namThi, maKhoi) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaNganh());
            ps.setFloat(2, item.getDiemChuan());
            ps.setInt(3, item.getChiTieu());
            ps.setString(4, item.getNamThi());
            ps.setString(5, item.getMaKhoi());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateItem(DiemChuan item) {
        String sql = "UPDATE " + table + " SET diemChuan = ?, chiTieu = ? WHERE maNganh = ? AND namThi = ? AND maKhoi = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, item.getDiemChuan());
            ps.setInt(2, item.getChiTieu());
            ps.setString(3, item.getMaNganh());
            ps.setString(4, item.getNamThi());
            ps.setString(5, item.getMaKhoi());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteItem(DiemChuan item) {
        String sql = "DELETE FROM " + table + " WHERE maNganh = ? AND namThi = ? AND maKhoi = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, item.getMaNganh());
            ps.setString(2, item.getNamThi());
            ps.setString(3, item.getMaKhoi());

            int isSuccess = ps.executeUpdate();
            ps.close();
            conn.close();
            return isSuccess > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<DiemChuan> getListItem() {
        ArrayList<DiemChuan> items = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " INNER JOIN khoi_thi ON diem_chuan.maKhoi = khoi_thi.maKhoi ORDER BY " + orderBy + " " + orderDir;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DiemChuan item = new DiemChuan();

                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getFloat("diemChuan"));
                item.setChiTieu(rs.getInt("chiTieu"));
                item.setNamThi(rs.getString("namThi"));
                item.setMaKhoi(rs.getString("maKhoi"));
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

    public DiemChuan getItemByCode(String maNganh, String maKhoi, String namThi) {
        DiemChuan item = new DiemChuan();
        String sql = "SELECT * FROM " + table + " WHERE maNganh = ? AND maKhoi = ? AND namThi = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, maNganh);
            ps.setString(2, maKhoi);
            ps.setString(3, namThi);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getFloat("diemChuan"));
                item.setChiTieu(rs.getInt("chiTieu"));
                item.setNamThi(rs.getString("namThi"));
                item.setMaKhoi(rs.getString("maKhoi"));
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
    
    public ArrayList<String> getListYear() {
        ArrayList<String> items = new ArrayList<>();
        String sql = "SELECT namThi FROM diem_chuan GROUP BY namThi";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String item = rs.getString("namThi");
                
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public ArrayList<DiemChuan> getListItemByCode(String maNganh, String namThi) {
        ArrayList<DiemChuan> items = new ArrayList<>();
        String sql = "SELECT maNganh, diemChuan, chiTieu, tenKhoi FROM " + table + " INNER JOIN khoi_thi ON diem_chuan.maKhoi = khoi_thi.maKhoi "
                + "WHERE maNganh = ? AND namThi = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, maNganh);
            ps.setString(2, namThi);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                DiemChuan item = new DiemChuan();
                
                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getFloat("diemChuan"));
                item.setChiTieu(rs.getInt("chiTieu"));
                item.setTenKhoi(rs.getString("tenKhoi"));
                
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
