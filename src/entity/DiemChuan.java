package entity;

/**
 *
 * @author tungdd
 */
public class DiemChuan {

    private String maNganh;
    private float diemChuan;
    private int chiTieu;
    private String namThi;
    private String maKhoi;
    private String tenKhoi;

    public DiemChuan() {
    }

    public DiemChuan(String maNganh, float diemChuan, int chiTieu, String namThi, String maKhoi, String tenKhoi) {
        this.maNganh = maNganh;
        this.diemChuan = diemChuan;
        this.chiTieu = chiTieu;
        this.namThi = namThi;
        this.maKhoi = maKhoi;
        this.tenKhoi = tenKhoi;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public float getDiemChuan() {
        return diemChuan;
    }

    public void setDiemChuan(float diemChuan) {
        this.diemChuan = diemChuan;
    }

    public int getChiTieu() {
        return chiTieu;
    }

    public void setChiTieu(int chiTieu) {
        this.chiTieu = chiTieu;
    }

    public String getNamThi() {
        return namThi;
    }

    public void setNamThi(String namThi) {
        this.namThi = namThi;
    }

    public String getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }

}
