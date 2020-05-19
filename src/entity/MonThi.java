package entity;

/**
 * Quản lý môn thi
 * 
 * @author tungdd
 */
public class MonThi {
    private int maMon;
    private String tenMon;

    public MonThi() {
    }

    public MonThi(int maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
}
