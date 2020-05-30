package entity;

/**
 *
 * @author tungdd
 */
public class DiemTuyenSinh {

    private String maNganh;
    private String diemChuan;
    private String chiTieu;
    private String namThi;
    private int khoiThi_id;
    private String tenKhoi;

    public DiemTuyenSinh(String maNganh, String diemChuan, String chiTieu, String namThi, int khoiThi_id, String tenKhoi) {
        this.maNganh = maNganh;
        this.diemChuan = diemChuan;
        this.chiTieu = chiTieu;
        this.namThi = namThi;
        this.khoiThi_id = khoiThi_id;
        this.tenKhoi = tenKhoi;
    }

    public DiemTuyenSinh() {
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getDiemChuan() {
        return diemChuan;
    }

    public void setDiemChuan(String diemChuan) {
        this.diemChuan = diemChuan;
    }

    public String getChiTieu() {
        return chiTieu;
    }

    public void setChiTieu(String chiTieu) {
        this.chiTieu = chiTieu;
    }

    public String getNamThi() {
        return namThi;
    }

    public void setNamThi(String namThi) {
        this.namThi = namThi;
    }

    public int getKhoiThi_id() {
        return khoiThi_id;
    }

    public void setKhoiThi_id(int khoiThi_id) {
        this.khoiThi_id = khoiThi_id;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }
}
