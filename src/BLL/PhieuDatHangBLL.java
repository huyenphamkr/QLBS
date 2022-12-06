
package BLL;

import DAL.PhieuDatHangDAL;
import DTO.PhieuDatHangDTO;
import java.util.Vector;

public class PhieuDatHangBLL {
    PhieuDatHangDAL DAL = new PhieuDatHangDAL();
    public Vector<PhieuDatHangDTO> getAllPhieuDatHang(){
        return DAL.getAllPhieuDH();
    }
    public String themPhieuDatHang(PhieuDatHangDTO d) {
        if (DAL.hasPhieuDatHangMa(d.getMaPHDH())==true)
            return "Mã Phiếu đã tồn tại";
        if(DAL.themPhieuDatHang(d))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
     public Vector<String> getAllMaNV(){
        return DAL.getAllMaNVcbb();
    }
     public Vector<String> getAllMaKH(){
        return DAL.getAllMaKHcbb();
    }
     
    public String xoaPhieuDatHang(int ma) {
        if (DAL.hasPhieuDatHangMa(ma)==false)
            return "Mã Phiếu  không tồn tại";
        if (DAL.xoaPhieuDatHang(ma))
            return "Xóa thành công";
        return "Xóa thất bại";
    }   
    public String suaPhieuDatHang(PhieuDatHangDTO nv) {
        if (DAL.suaPhieuDatHang(nv))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    public Vector<PhieuDatHangDTO> timPhieuDatHang(int manv) {
        PhieuDatHangDAL dgDAL = new PhieuDatHangDAL();        
            return dgDAL.timPhieuDatHang(manv);
    }
    public boolean Tim(int ma){
        if (DAL.hasPhieuDatHangMa(ma)==false)
           return false;
        return true;
    }
    
}