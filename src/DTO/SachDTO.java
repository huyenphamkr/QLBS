package DTO;

public class SachDTO {
    private String MaSach;
    private String TenSach;   
    private String TacGia;   
    private String TheLoai;   
    private Double Gia;   
    private String HinhAnh;

    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public Double getGia() {
        return Gia;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public int getSoLuong() {
        return SoLuong;
    }
    private int SoLuong;

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public void setGia(Double Gia) {
        this.Gia = Gia;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
