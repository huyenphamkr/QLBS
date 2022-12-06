
package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.util.Vector;

public class KhachHangBLL {
    KhachHangDAL khDAL = new KhachHangDAL();
    public Vector<KhachHangDTO> getAllKhachHang(){
        return khDAL.getAllKhachHang();
    }
    public String themKhachHang(KhachHangDTO kh) {
        if (khDAL.hasKhachHangMakh(kh.getMaKH()))
            return "Mã Khách Hàng đã tồn tại";
        if (khDAL.themKhachHang(kh))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    public String xoaKhachHang(String makh) {
        if (khDAL.hasKhachHangMakh(makh)==false)
            return "Mã Khách Hàng không tồn tại";
        if (khDAL.xoaKhachHang(makh))
            return "Xóa thành công";
        return "Xóa thất bại";
    }   
    public String suaKhachHang(KhachHangDTO kh) {
        if (khDAL.suaKhachHang(kh))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    public Vector<KhachHangDTO> timKhachHang(String makh) {
        KhachHangDAL khDAL = new KhachHangDAL();        
            return khDAL.timKhachHang(makh);
       
    }
    public boolean Tim(String makh){
        if (khDAL.hasKhachHangMakh(makh)==false)
           return false;
        return true;
    }
}

