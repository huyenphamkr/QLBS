
package BLL;

import DAL.ThongKeDAL;
import DTO.KhachHangDTO;
import DTO.SachDTO;
import java.util.Vector;

public class ThongKeBLL {
    ThongKeDAL dgDAL = new ThongKeDAL();
    public Vector<KhachHangDTO> getAllKhachHangVIP(){
        return dgDAL.getAllKhachHangVIP();
    }
    public Vector<SachDTO> getAllSachConLai(){
        return dgDAL.getALLSachConLai();
    }
    public Vector<SachDTO> getAllSachHet(){
        return dgDAL.getALLSachHet();
    }
    
}
