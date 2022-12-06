package DAL;
import DTO.KhachHangDTO;
import DTO.SachDTO;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
public class ThongKeDAL {
    private Connection con;
    public boolean openConnection() {
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLBS";
        String username = "sa"; 
        String password= "sa";
        con = DriverManager.getConnection(dbUrl, username, password); 
        return true;
    } catch(Exception ex){
        System.out.println(ex);
        return false;}
    }
    public void closeConnection() {
    try {
        if (con!=null)
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex); }
    }
    public Vector<KhachHangDTO> getAllKhachHangVIP(){
        Vector<KhachHangDTO> vt = new Vector<KhachHangDTO>();
        if (openConnection()) {
            try {
                String sql = "select k.MAKH, k.TENKH, k.DIACHI, k.SDT from PHIEUDH p, KHACHHANG k where p.MAKH=k.MAKH group by k.MAKH, k.TENKH, k.DIACHI, k.SDT Having COUNT(p.MAPHDH)>=2";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    KhachHangDTO dg = new KhachHangDTO();
                    dg.setMaKH(rs.getString("MAKH")); 
                    dg.setTenKH(rs.getString("TENKH"));
                    dg.setSdt(rs.getString("SDT"));
                    dg.setDiaChi(rs.getString("DIACHI"));
                    vt.add(dg);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    
    public Vector<SachDTO> getALLSachHet() {
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from SACH where SOLUONG=0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SachDTO sach = new SachDTO();
                    sach.setMaSach(rs.getString(1));
                    sach.setTenSach(rs.getString(2));
                    sach.setTacGia(rs.getString(3));
                    sach.setTheLoai(rs.getString(4));
                    sach.setGia(rs.getDouble(5));
                    sach.setSoLuong(rs.getInt(7));
                    arr.add(sach);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    public Vector<SachDTO> getALLSachConLai() {
        Vector<SachDTO> arr = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from Sach where SOLUONG>0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SachDTO sach = new SachDTO();
                    sach.setMaSach(rs.getString(1));
                    sach.setTenSach(rs.getString(2));
                    sach.setTacGia(rs.getString(3));
                    sach.setTheLoai(rs.getString(4));
                    sach.setGia(rs.getDouble(5));
                    sach.setSoLuong(rs.getInt(7));
                    arr.add(sach);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                closeConnection();
            }
        }
        return arr;
    }
    
    
}
