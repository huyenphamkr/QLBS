
package DAL;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class KhachHangDAL {
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
    public Vector<KhachHangDTO> getAllKhachHang(){
        Vector<KhachHangDTO> vt = new Vector<KhachHangDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from KHACHHANG";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    KhachHangDTO khdto = new KhachHangDTO();
                    khdto.setMaKH(rs.getString("MAKH"));                   
                    khdto.setTenKH(rs.getString("TENKH"));
                    khdto.setDiaChi(rs.getString("DIACHI"));
                    khdto.setSdt(rs.getString("SDT"));
                    vt.add(khdto);                
                //System.out.println("MAKH: " + rs.getString(1) +" Ho Ten: " + rs.getString(2) + " Nam sinh: "+ rs.getString(3)+"MSSV: " + rs.getInt(4));
            }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    public boolean themKhachHang(KhachHangDTO kh) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Insert into KHACHHANG values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, kh.getMaKH());
                stmt.setString(2, kh.getTenKH());
                stmt.setString(3, kh.getDiaChi());
                stmt.setString(4, kh.getSdt());   
                stmt.setString(5, "123");   
                if (stmt.executeUpdate()>=1)
                    result = true;                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    public boolean hasKhachHangMakh(String makh){ 
        boolean result = false;
        if (openConnection()) {
        try {
            String sql = "Select * from KHACHHANG where MAKH='"+makh+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally { closeConnection(); } }
        return result;
    }
    public boolean xoaKhachHang(String makh) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Delete from KhachHang where MaKH='"+makh+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
                     
                if (stmt.executeUpdate()>=1)
                    result = true;
                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;    
    }
    public boolean suaKhachHang(KhachHangDTO kh) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Update KHACHHANG set TENKH=?, DIACHI=?, SDT=? where MAKH='"+kh.getMaKH()+"'";
                PreparedStatement stmt = con.prepareStatement(sql); 
                stmt.setString(1, kh.getTenKH());
                stmt.setString(2, kh.getDiaChi());
                stmt.setString(3, kh.getSdt());                
                if (stmt.executeUpdate()!=0)
                    result = true;
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public Vector<KhachHangDTO> timKhachHang(String makh) { 
        Vector<KhachHangDTO> vt = new Vector<KhachHangDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from KHACHHANG Where MAKH like '" + makh+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    KhachHangDTO dg = new KhachHangDTO();
                    dg.setMaKH(rs.getString("MAKH"));                   
                    dg.setTenKH(rs.getString("TENKH"));
                    dg.setDiaChi(rs.getString("DIACHI"));
                    dg.setSdt(rs.getString("SDT"));
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
    
    public static void main(String[]args){
        KhachHangDAL a =new KhachHangDAL();
        a.getAllKhachHang();
    }
}
