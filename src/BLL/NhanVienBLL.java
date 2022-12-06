
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.Vector;

public class NhanVienBLL {
    NhanVienDAL nvDAL = new NhanVienDAL();
    public Vector<NhanVienDTO> getAllNhanVien(){
        return nvDAL.getAllNhanVien();
    }
    public String themNhanVien(NhanVienDTO nv) {
        if (nvDAL.hasNhanVienManv(nv.getMaNV()))
            return "Mã Nhân Viên đã tồn tại";
        if (nvDAL.themNhanVien(nv))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    public String xoaNhanVien(String manv) {
        if (nvDAL.hasNhanVienManv(manv)==false)
            return "Mã Nhân Viên không tồn tại";
        if (nvDAL.xoaNhanVien(manv))
            return "Xóa thành công";
        return "Xóa thất bại";
    }   
    public String suaNhanVien(NhanVienDTO nv) {
        if (nvDAL.suaNhanVien(nv))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    public Vector<NhanVienDTO> timNhanVien(String manv) {
        NhanVienDAL dgDAL = new NhanVienDAL();        
            return dgDAL.timNhanVien(manv);
       
    }
    public boolean Tim(String manv){
        if (nvDAL.hasNhanVienManv(manv)==false)
           return false;
        return true;
    }
}

