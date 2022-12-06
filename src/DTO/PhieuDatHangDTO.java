/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


public class PhieuDatHangDTO {
    private int MaPHDH;
    private String MaKH;
    private String MaNV;
    private double TongTien;
    private String NgayDH;

    public int getMaPHDH() {
        return MaPHDH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public double getTongTien() {
        return TongTien;
    }

    public String getNgayDH() {
        return NgayDH;
    }

    public void setMaPHDH(int MaPHDH) {
        this.MaPHDH = MaPHDH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public void setNgayDH(String NgayDH) {
        this.NgayDH = NgayDH;
    }
    
}
