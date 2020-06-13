package entity;

/**
 * Quản lý điểm thi của thí sinh
 *
 * @author tungdd
 */
public class DiemTuyenSinh {

    private String maThiSinh;
    private String maMon;
    private float diem;
    private String tenMon;

    public DiemTuyenSinh() {
    }

    public DiemTuyenSinh(String maThiSinh, String maMon, float diem) {
        this.maThiSinh = maThiSinh;
        this.maMon = maMon;
        this.diem = diem;
    }

    public DiemTuyenSinh(String maThiSinh, String maMon, float diem, String tenMon) {
        this.maThiSinh = maThiSinh;
        this.maMon = maMon;
        this.diem = diem;
        this.tenMon = tenMon;
    }

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

}
