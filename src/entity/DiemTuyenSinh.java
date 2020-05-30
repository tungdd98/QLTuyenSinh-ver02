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

    public DiemTuyenSinh(String maNganh, String diemChuan, String chiTieu, String namThi) {
        this.maNganh = maNganh;
        this.diemChuan = diemChuan;
        this.chiTieu = chiTieu;
        this.namThi = namThi;
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
}
