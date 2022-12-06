
package DTO;


public class PhieuNhapDTO {
    private int MaPN;
    private String MaNV;
    private String NgayNhap;
    private int TongSL;
    private Double TongTien;
    private String MaNCC;

    public int getMaPN() {
        return MaPN;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public int getTongSL() {
        return TongSL;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setTongSL(int TongSL) {
        this.TongSL = TongSL;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }
    
}
