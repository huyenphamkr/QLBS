
package DAL;

import DTO.SachDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class SachDAL {
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
    public Vector<SachDTO> getAllSach(){
        Vector<SachDTO> vt = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from SACH";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SachDTO sdto = new SachDTO();
                    sdto.setMaSach(rs.getString("MASACH"));                   
                    sdto.setTenSach(rs.getString("TENSACH"));
                    sdto.setTacGia(rs.getString("TACGIA"));
                    sdto.setTheLoai(rs.getString("THELOAI"));
                    sdto.setGia(rs.getDouble("GIA"));
                    sdto.setHinhAnh(rs.getString("HINHANH"));
                    sdto.setSoLuong(rs.getInt("SOLUONG"));
                    vt.add(sdto);                
                //System.out.println("MASach: " + rs.getString(1) +" Ho Ten: " + rs.getString(2) + " Nam sinh: "+ rs.getString(3));
            }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    public boolean themSach(SachDTO sach) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Insert into SACH values(?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, sach.getMaSach());
                stmt.setString(2, sach.getTenSach());
                stmt.setString(3, sach.getTacGia());
                stmt.setString(4, sach.getTheLoai());   
                stmt.setDouble(5, sach.getGia());   
                stmt.setString(6, sach.getHinhAnh()); 
                stmt.setInt(7, sach.getSoLuong());  
                if (stmt.executeUpdate()>=1)
                    result = true;                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    public boolean hasSachMasach(String mas){ 
        boolean result = false;
        if (openConnection()) {
        try {
            String sql = "Select * from SACH where MASach='"+mas+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally { closeConnection(); } }
        return result;
    }
    public boolean xoaSach(String mas) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Delete from Sach where MaSach='"+mas+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
                     
                if (stmt.executeUpdate()>=1)
                    result = true;
                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;    
    }
    public boolean suaSach(SachDTO s) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Update SACH set TENSACH=?, TACGIA=?, THELOAI=?, GIA=?, HINHANH=?, SOLUONG=? where MASach='"+s.getMaSach()+"'";
                PreparedStatement stmt = con.prepareStatement(sql); 
                stmt.setString(1, s.getTenSach());
                stmt.setString(2, s.getTacGia());
                stmt.setString(3, s.getTheLoai());  
                stmt.setDouble(4, s.getGia());
                stmt.setString(5, s.getHinhAnh());
                stmt.setInt(6, s.getSoLuong());
                if (stmt.executeUpdate()!=0)
                    result = true;
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public Vector<SachDTO> timSach(String mas) { 
        Vector<SachDTO> vt = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from SACH Where MASACH like '" + mas+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SachDTO s = new SachDTO();
                    s.setMaSach(rs.getString("MASach"));                   
                    s.setTenSach(rs.getString("TENSACH"));
                    s.setTacGia(rs.getString("TACGIA"));
                    s.setTheLoai(rs.getString("THELOAI"));
                    s.setGia(rs.getDouble("GIA"));
                    s.setHinhAnh(rs.getString("HINHANH"));
                    s.setSoLuong(rs.getInt("SOLUONG"));
                    vt.add(s);  
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    public Vector<SachDTO> ten(String tens) { 
        Vector<SachDTO> vt = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from SACH Where TENSACH like N'%" + tens+"%'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SachDTO s = new SachDTO();
                    s.setMaSach(rs.getString("MASACH"));                   
                    s.setTenSach(rs.getString("TENSACH"));
                    s.setTacGia(rs.getString("TACGIA"));
                    s.setTheLoai(rs.getString("THELOAI"));
                    s.setGia(rs.getDouble("GIA"));
                    s.setHinhAnh(rs.getString("HINHANH"));
                    s.setSoLuong(rs.getInt("SOLUONG"));
                    vt.add(s);  
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    public Vector<SachDTO> soluong(int sl) { 
        Vector<SachDTO> vt = new Vector<SachDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from SACH Where SOLUONG < " +sl;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    SachDTO s = new SachDTO();
                    s.setMaSach(rs.getString("MASACH"));                   
                    s.setTenSach(rs.getString("TENSACH"));
                    s.setTacGia(rs.getString("TACGIA"));
                    s.setTheLoai(rs.getString("THELOAI"));
                    s.setGia(rs.getDouble("GIA"));
                    s.setHinhAnh(rs.getString("HINHANH"));
                    s.setSoLuong(rs.getInt("SOLUONG"));
                    vt.add(s);  
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;} 
    public static void main(String[]args){
        SachDAL a =new SachDAL();
        a.getAllSach();
    }
}
