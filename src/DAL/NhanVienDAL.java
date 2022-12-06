
package DAL;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class NhanVienDAL {
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
    public Vector<NhanVienDTO> getAllNhanVien(){
        Vector<NhanVienDTO> vt = new Vector<NhanVienDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from NHANVIEN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    NhanVienDTO nvdto = new NhanVienDTO();
                    nvdto.setMaNV(rs.getString("MANV"));                   
                    nvdto.setTenNV(rs.getString("TENNV"));
                    nvdto.setDiaChi(rs.getString("DIACHI"));
                    nvdto.setSdt(rs.getString("SDT"));
                    vt.add(nvdto);                
                //System.out.println("MANV: " + rs.getString(1) +" Ho Ten: " + rs.getString(2) + " Nam sinh: "+ rs.getString(3)+"MSSV: " + rs.getInt(4));
            }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    public boolean themNhanVien(NhanVienDTO nv) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Insert into NHANVIEN values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nv.getMaNV());
                stmt.setString(2, nv.getTenNV());
                stmt.setString(3, nv.getDiaChi());
                stmt.setString(4, nv.getSdt());   
                stmt.setString(5, "123");   
                if (stmt.executeUpdate()>=1)
                    result = true;                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    public boolean hasNhanVienManv(String manv){ 
        boolean result = false;
        if (openConnection()) {
        try {
            String sql = "Select * from NHANVIEN where MANV='"+manv+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally { closeConnection(); } }
        return result;
    }
    public boolean xoaNhanVien(String manv) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Delete from NhanVien where MaNV='"+manv+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
                     
                if (stmt.executeUpdate()>=1)
                    result = true;
                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;    
    }
    public boolean suaNhanVien(NhanVienDTO nv) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Update NHANVIEN set TENNV=?, DIACHI=?, SDT=? where MANV='"+nv.getMaNV()+"'";
                PreparedStatement stmt = con.prepareStatement(sql); 
                stmt.setString(1, nv.getTenNV());
                stmt.setString(2, nv.getDiaChi());
                stmt.setString(3, nv.getSdt());                
                if (stmt.executeUpdate()!=0)
                    result = true;
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public Vector<NhanVienDTO> timNhanVien(String manv) { 
        Vector<NhanVienDTO> vt = new Vector<NhanVienDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from NHANVIEN Where MANV like '" + manv+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    NhanVienDTO dg = new NhanVienDTO();
                    dg.setMaNV(rs.getString("MANV"));                   
                    dg.setTenNV(rs.getString("TENNV"));
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
        NhanVienDAL a =new NhanVienDAL();
        a.getAllNhanVien();
    }
}
