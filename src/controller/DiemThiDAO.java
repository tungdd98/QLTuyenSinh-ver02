package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.DiemThi;

/**
 *
 * @author tungdd
 */
public class DiemThiDAO extends DAO {

    public DiemThiDAO() {
        super();
    }
    
    public boolean updateItem(DiemThi dt) {
        String sql = "UPDATE diem_thi SET diem = ? WHERE thiSinh_id = ? AND monThi_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, dt.getDiem());
            ps.setString(2, dt.getThiSinh_id());
            ps.setInt(3, dt.getMonThi_id());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addItem(DiemThi dt) {
        String sql = "INSERT INTO diem_thi(thiSinh_id, monThi_id, diem) VALUES(?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, dt.getThiSinh_id());
            ps.setInt(2, dt.getMonThi_id());
            ps.setString(3, dt.getDiem());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<DiemThi> getListItem(String maThiSinh) {
        ArrayList<DiemThi> items = new ArrayList<>();
        String sql = "SELECT id, thiSinh_id, monThi_id, diem, tenMon FROM diem_thi INNER JOIN mon_thi ON diem_thi.monThi_id = mon_thi.maMon WHERE thiSinh_id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, maThiSinh);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DiemThi item = new DiemThi();
                item.setId(rs.getInt("id"));
                item.setThiSinh_id(rs.getString("thiSinh_id"));
                item.setMonThi_id(rs.getInt("monThi_id"));
                item.setDiem(rs.getString("diem"));
                item.setTenMonThi(rs.getString("tenMon"));
                
                items.add(item);
            }
        } catch (SQLException e) {
        }
        return items;
    }
}
