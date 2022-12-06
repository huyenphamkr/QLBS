
package DTO;

public class CT_PhieuNhapDTO {
    private int MaPN;
    private String MaSach;
    private int SoLuong;
    private Double DonGia;
    private Double TongTien;

    public int getMaPN() {
        return MaPN;
    }

    public String getMaSach() {
        return MaSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public Double getDonGia() {
        return DonGia;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setMaPN(int MaPN) {
        this.MaPN = MaPN;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setDonGia(Double DonGia) {
        this.DonGia = DonGia;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }
    
}
