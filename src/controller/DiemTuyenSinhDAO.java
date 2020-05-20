package controller;

import entity.DiemTuyenSinh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tungdd
 */
public class DiemTuyenSinhDAO extends DAO {
    public DiemTuyenSinhDAO() {
        super();
    }
    
    public boolean addItem(DiemTuyenSinh item) {
        String sql = "INSERT INTO diem_tuyen_sinh(maNganh, diemChuan, chiTieu, namThi) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, item.getMaNganh());
            ps.setFloat(2, item.getDiemChuan());
            ps.setInt(3, item.getChiTieu());
            ps.setString(4, item.getNamThi());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean updateItem(DiemTuyenSinh item) {
        String sql = "UPDATE diem_tuyen_sinh SET diemChuan = ?, chiTieu = ?, namThi = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, item.getDiemChuan());
            ps.setInt(2, item.getChiTieu());
            ps.setString(3, item.getNamThi());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean deleteItem(DiemTuyenSinh item) {
        String sql = "DELETE FROM diem_tuyen_sinh WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
        }

        return false;
    }
    
    public ArrayList<DiemTuyenSinh> getListItem() {
        ArrayList<DiemTuyenSinh> items = new ArrayList<>();
        String sql = "SELECT * FROM diem_tuyen_sinh";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                DiemTuyenSinh item = new DiemTuyenSinh();
                
                item.setId(rs.getInt("id"));
                item.setMaNganh(rs.getString("maNganh"));
                item.setDiemChuan(rs.getFloat("diemChuan"));
                item.setChiTieu(rs.getInt("chiTieu"));
                item.setNamThi(rs.getString("namThi"));
                
                items.add(item);
            }
        } catch (SQLException e) {
        }
        return items;
    }
}
