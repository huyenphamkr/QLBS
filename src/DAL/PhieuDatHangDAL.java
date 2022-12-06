
package DAL;

import DTO.PhieuDatHangDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PhieuDatHangDAL {
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
    public Vector<PhieuDatHangDTO> getAllPhieuDH(){
        Vector<PhieuDatHangDTO> vt = new Vector<PhieuDatHangDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from PHIEUDH";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    PhieuDatHangDTO dto = new PhieuDatHangDTO();
                    dto.setMaPHDH(Integer.parseInt(rs.getString("MAPHDH")));
                    dto.setMaKH(rs.getString("MAKH"));                   
                    dto.setMaNV(rs.getString("MANV"));
                    dto.setTongTien(Double.parseDouble(rs.getString("TONGTIEN")));
                    dto.setNgayDH(rs.getString("NGAYDH"));
                    vt.add(dto);                
                //System.out.println("MAKH: " + rs.getString(2) );
            }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
    }
    public Vector<String> getAllMaNVcbb() {
        Vector<String> str = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from NHANVIEN";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    str.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            } finally {
                closeConnection();
            }
        }
        return str;
    }
    public Vector<String> getAllMaKHcbb() {
        Vector<String> str = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from KHACHHANG";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    str.add(rs.getString(1));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
                return null;
            } finally {
                closeConnection();
            }
        }
        return str;
    }
    public boolean themPhieuDatHang(PhieuDatHangDTO d) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Insert into PHIEUDH values(?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, d.getMaPHDH());
                stmt.setString(2, d.getMaKH());
                stmt.setString(3, d.getMaNV());
                stmt.setDouble(4, d.getTongTien());      
                stmt.setString(5, d.getNgayDH());      
                if (stmt.executeUpdate()>=1)
                    result = true;                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public boolean hasPhieuDatHangMa(int ma){ 
        boolean result = false;
        if (openConnection()) {
        try {
            String sql = "Select * from PHIEUDH where MAPHDH="+ma;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally { closeConnection(); } }
        return result;
    }
    public boolean xoaPhieuDatHang(int ma) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Delete from PHIEUDH where MAPHDH="+ma;
                PreparedStatement stmt = con.prepareStatement(sql);
                     
                if (stmt.executeUpdate()>=1)
                    result = true;
                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;    
    }
    public boolean suaPhieuDatHang(PhieuDatHangDTO d) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Update PHIEUDH set MAKH=?, MANV=?, TONGTIEN=?, NGAYDH=? where MAPHDH="+d.getMaPHDH();
                PreparedStatement stmt = con.prepareStatement(sql); 
                stmt.setString(1,d.getMaKH() );
                stmt.setString(2, d.getMaNV());
                stmt.setDouble(3,d.getTongTien() );
                stmt.setString(4,d.getNgayDH() );
                if (stmt.executeUpdate()!=0)
                    result = true;
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public Vector<PhieuDatHangDTO> timPhieuDatHang(int ma) { 
        Vector<PhieuDatHangDTO> vt = new Vector<PhieuDatHangDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from PHIEUDH Where MAPHDH like " + ma;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    PhieuDatHangDTO d = new PhieuDatHangDTO();
                    d.setMaKH(rs.getString("MAKH"));
                    d.setMaNV(rs.getString("MANV"));
                    d.setTongTien(rs.getDouble("TONGTIEN"));
                    d.setNgayDH(rs.getString("NGAYDH"));
                    vt.add(d);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return vt;
        
    }
    
}
