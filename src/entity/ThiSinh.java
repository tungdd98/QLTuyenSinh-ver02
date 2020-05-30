package entity;

import java.util.Date;

/**
 * Quản lý thí sinh dự thi
 * 
 * @author tungdd
 */
public class ThiSinh {
    private String maThiSinh;
    private String hoTen;
    private int gioiTinh;
    private String danToc;
    private String soDienThoai;
    private String queQuan;
    private String CMND;
    private Date ngaySinh;

    public ThiSinh() {
    }

    public ThiSinh(String maThiSinh, String hoTen, int gioiTinh, String danToc, String soDienThoai, String queQuan, String CMND, Date ngaySinh) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.danToc = danToc;
        this.soDienThoai = soDienThoai;
        this.queQuan = queQuan;
        this.CMND = CMND;
        this.ngaySinh = ngaySinh;
    }

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
