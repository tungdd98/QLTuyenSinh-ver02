package entity;

/**
 *
 * @author tungdd
 */
public class KhoiThi {
    private int maKhoi;
    private String tenKhoi;

    public int getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(int maKhoi) {
        this.maKhoi = maKhoi;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }

    public KhoiThi(int maKhoi, String tenKhoi) {
        this.maKhoi = maKhoi;
        this.tenKhoi = tenKhoi;
    }

    public KhoiThi() {
    }
}
