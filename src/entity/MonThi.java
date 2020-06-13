package entity;

/**
 * Quản lý môn thi
 * 
 * @author tungdd
 */
public class MonThi {
    private String maMon;
    private String tenMon;

    public MonThi() {
    }

    public MonThi(String maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
}
