package DTO;

public class NhanVienDTO {
    private String MaNV;
    private String TenNV;
    private String DiaChi;
    private String Sdt;
    private String MatKhau;

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public Object getManv() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
