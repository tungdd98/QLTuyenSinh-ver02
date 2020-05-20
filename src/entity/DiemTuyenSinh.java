package entity;

import java.util.Date;

/**
 *
 * @author tungdd
 */
public class DiemTuyenSinh {

    private int id;

    private String maNganh;
    private float diemChuan;
    private int chiTieu;
    private String namThi;

    public DiemTuyenSinh(String maNganh, float diemChuan, int chiTieu, String namThi) {
        this.maNganh = maNganh;
        this.diemChuan = diemChuan;
        this.chiTieu = chiTieu;
        this.namThi = namThi;
    }

    public DiemTuyenSinh(int id, String maNganh, float diemChuan, int chiTieu, String namThi) {
        this.id = id;
        this.maNganh = maNganh;
        this.diemChuan = diemChuan;
        this.chiTieu = chiTieu;
        this.namThi = namThi;
    }

    public DiemTuyenSinh(String maNganh, float diemChuan, int chiTieu) {
        this.maNganh = maNganh;
        this.diemChuan = diemChuan;
        this.chiTieu = chiTieu;
    }

    public DiemTuyenSinh() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
