
package BLL;

import DAL.SachDAL;
import DTO.SachDTO;
import java.util.Vector;

public class SachBLL {
    SachDAL sachDAL = new SachDAL();
    public Vector<SachDTO> getAllSach(){
        return sachDAL.getAllSach();
    }
    public String themSach(SachDTO sach) {
        if (sachDAL.hasSachMasach(sach.getMaSach()))
            return "Mã Sách đã tồn tại";
        if (sachDAL.themSach(sach))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    public String xoaSach(String masach) {
        if (sachDAL.hasSachMasach(masach)==false)
            return "Mã Sách không tồn tại";
        if (sachDAL.xoaSach(masach))
            return "Xóa thành công";
        return "Xóa thất bại";
    }   
    public String suaSach(SachDTO sach) {
        if (sachDAL.suaSach(sach))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    public Vector<SachDTO> timSach(String masach) {
        SachDAL sDAL = new SachDAL();        
            return sDAL.timSach(masach);
       
    }
    public Vector<SachDTO> timtenSach(String ten) {
        SachDAL sDAL = new SachDAL();        
            return sDAL.ten(ten);
       
    }
    public Vector<SachDTO> timsoluongSach(int sl) {
        SachDAL sDAL = new SachDAL();        
            return sDAL.soluong(sl);
       
    }
    public boolean Tim(String masach){
        if (sachDAL.hasSachMasach(masach)==false)
           return false;
        return true;
    }
}

