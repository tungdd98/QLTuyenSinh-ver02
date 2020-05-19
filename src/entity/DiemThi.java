package entity;

/**
 * Quản lý điểm thi của thí sinh
 * 
 * @author tungdd
 */
public class DiemThi {
    private int id;
    private String thiSinh_id;
    private int monThi_id;
    private String diem;
    private String tenMonThi;

    public DiemThi() {
    }

    public DiemThi(int id, String thiSinh_id, int monThi_id, String diem, String tenMonThi) {
        this.id = id;
        this.thiSinh_id = thiSinh_id;
        this.monThi_id = monThi_id;
        this.diem = diem;
        this.tenMonThi = tenMonThi;
    }

    public String getTenMonThi() {
        return tenMonThi;
    }

    public void setTenMonThi(String tenMonThi) {
        this.tenMonThi = tenMonThi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThiSinh_id() {
        return thiSinh_id;
    }

    public void setThiSinh_id(String thiSinh_id) {
        this.thiSinh_id = thiSinh_id;
    }

    public int getMonThi_id() {
        return monThi_id;
    }

    public void setMonThi_id(int monThi_id) {
        this.monThi_id = monThi_id;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
    
}
