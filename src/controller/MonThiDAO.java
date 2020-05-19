package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.MonThi;

/**
 *
 * @author tungdd
 */
public class MonThiDAO extends DAO {
    public MonThiDAO() {
        super();
    }
    
    public ArrayList<MonThi> getListItem() {
        ArrayList<MonThi> items = new ArrayList<>();
        String sql = "SELECT * FROM mon_thi";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                MonThi item = new MonThi();
                
                item.setMaMon(rs.getInt("maMon"));
                item.setTenMon(rs.getString("tenMon"));
                
                items.add(item);
            }
        } catch (SQLException e) {
        }
        return items;
    }
}
