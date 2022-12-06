
package BLL;
import DAL.PhieuNhapDAL;
import DTO.PhieuNhapDTO;
import java.util.Vector;

public class PhieuNhapBLL {
    PhieuNhapDAL DAL = new PhieuNhapDAL();
    public Vector<PhieuNhapDTO> getAllPhieuNhap(){
        return DAL.getAllPhieuNhap();
    }
    public String themPhieuNhap(PhieuNhapDTO d) {
        if (DAL.hasPhieuNhapMa(d.getMaPN())==true)
            return "Mã Phiếu đã tồn tại";
        if(DAL.themPhieuNhap(d))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
     public Vector<String> getAllMaNV(){
        return DAL.getAllMaNVcbb();
    }
     public Vector<String> getAllMaNCC(){
        return DAL.getAllMaNCCcbb();
    }
     
    public String xoaPhieuNhap(int ma) {
        if (DAL.hasPhieuNhapMa(ma)==false)
            return "Mã Phiếu  không tồn tại";
        if (DAL.xoaPhieuNhap(ma))
            return "Xóa thành công";
        return "Xóa thất bại";
    }   
    public String suaPhieuNhap(PhieuNhapDTO nv) {
        if (DAL.suaPhieuNhap(nv))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    public Vector<PhieuNhapDTO> timPhieuNhap(int manv) {
        PhieuNhapDAL dgDAL = new PhieuNhapDAL();        
            return dgDAL.timPhieuNhap(manv);
    }
    public boolean Tim(int ma){
        if (DAL.hasPhieuNhapMa(ma)==false)
           return false;
        return true;
    }
    
}