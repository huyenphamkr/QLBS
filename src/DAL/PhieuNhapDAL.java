
package DAL;

import DTO.PhieuNhapDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PhieuNhapDAL {
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
    public Vector<PhieuNhapDTO> getAllPhieuNhap(){
        Vector<PhieuNhapDTO> vt = new Vector<PhieuNhapDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from PHIEUNHAP";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    PhieuNhapDTO dto = new PhieuNhapDTO();
                    dto.setMaPN(Integer.parseInt(rs.getString("MAPHN")));
                    dto.setMaNV(rs.getString("MANV"));
                    dto.setNgayNhap(rs.getString("NGAYNHAP"));
                    dto.setTongSL(rs.getInt("TONGSL"));
                    dto.setTongTien(rs.getDouble("TONGTIEN"));
                    dto.setMaNCC(rs.getString("MANCC"));                     
                    vt.add(dto);                
                //System.out.println("MAKH: " + rs.getInt(1) );
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
    public Vector<String> getAllMaNCCcbb() {
        Vector<String> str = new Vector<>();
        if (openConnection()) {
            try {
                String sql = "Select * from NHACUNGCAP";
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
    public boolean themPhieuNhap(PhieuNhapDTO d) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Insert into PHIEUNHAP values(?,?,?,?,?,?)";
                
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, d.getMaPN());
                stmt.setString(2, d.getMaNV());
                stmt.setString(3, d.getNgayNhap());
                stmt.setInt(4, d.getTongSL());
                stmt.setDouble(5, d.getTongTien());      
                stmt.setString(6, d.getMaNCC());      
                if (stmt.executeUpdate()>=1)
                    result = true;                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public boolean hasPhieuNhapMa(int ma){ 
        boolean result = false;
        if (openConnection()) {
        try {
            String sql = "Select * from PHIEUNHAP where MAPHN="+ma;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally { closeConnection(); } }
        return result;
    }
    public boolean xoaPhieuNhap(int ma) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Delete from PHIEUNHAP where MAPHN="+ma;
                PreparedStatement stmt = con.prepareStatement(sql);
                     
                if (stmt.executeUpdate()>=1)
                    result = true;
                
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;    
    }
    public boolean suaPhieuNhap(PhieuNhapDTO d) { 
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "Update PHIEUNHAP set MANV=?, NGAYNHAP=?,TONGSL=?, TONGTIEN=?, MANCC=? where MAPHN="+d.getMaPN();
                PreparedStatement stmt = con.prepareStatement(sql); 
                stmt.setString(1,d.getMaNV() );
                stmt.setString(2, d.getNgayNhap());
                stmt.setInt(3,d.getTongSL() );
                stmt.setDouble(4,d.getTongTien() );
                stmt.setString(5,d.getMaNCC() );
                if (stmt.executeUpdate()!=0)
                    result = true;
            }catch(Exception ex){
            System.out.println(ex);
            }
        }     
        return result;
    }
    
    public Vector<PhieuNhapDTO> timPhieuNhap(int ma) { 
        Vector<PhieuNhapDTO> vt = new Vector<PhieuNhapDTO>();
        if (openConnection()) {
            try {
                String sql = "select* from PHIEUNHAP Where MAPHN like " + ma;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    PhieuNhapDTO d = new PhieuNhapDTO();
                    d.setMaNV(rs.getString("MANV"));
                    d.setNgayNhap(rs.getString("NGAYNHAP"));
                    d.setTongSL(rs.getInt("TONGSL"));
                    d.setTongTien(rs.getDouble("TONGTIEN"));
                    d.setMaNCC(rs.getString("MANCC"));
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
    public static void main(String[]args){
        PhieuNhapDAL a =new PhieuNhapDAL();
        a.getAllPhieuNhap();
    }
}
