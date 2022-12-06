
package BLL;
import DAL.DangNhapDAL;
public class DangNhapBLL {
    DangNhapDAL DAL = new DangNhapDAL();    
     public boolean Tim(String user, String pass){
        if (DAL.check(user, pass))
           return true;
        return false;
    }
}
