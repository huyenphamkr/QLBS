/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.CT_PhieuNhapDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
public class CT_PhieuNhapDAL {
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
    public Vector<CT_PhieuNhapDTO> getAllCTPhieuNhap(int ma){
        Vector<CT_PhieuNhapDTO> vt = new Vector<CT_PhieuNhapDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from CT_PHIEUNHAP where MAPHN="+ma;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    CT_PhieuNhapDTO dto = new CT_PhieuNhapDTO();
                    //dto.setMaPHNhap(Integer.parseInt(rs.getString("MAPHNhap")));
                    dto.setMaSach(rs.getString("MASACH")); 
                    dto.setSoLuong(Integer.parseInt(rs.getString("SOLUONG")));
                    dto.setDonGia(Double.parseDouble(rs.getString("DONGIA")));
                    dto.setTongTien(Double.parseDouble(rs.getString("TONGTIEN")));
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
}
