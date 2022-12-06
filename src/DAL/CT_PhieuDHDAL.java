/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.CT_PhieuDHDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
public class CT_PhieuDHDAL {
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
    public Vector<CT_PhieuDHDTO> getAllCTPhieuDH(int ma){
        Vector<CT_PhieuDHDTO> vt = new Vector<CT_PhieuDHDTO>();
        if (openConnection()) {
            try {
                String sql = "select * from CT_PHIEUDH where MAPHDH="+ma;
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    CT_PhieuDHDTO dto = new CT_PhieuDHDTO();
                    //dto.setMaPHDH(Integer.parseInt(rs.getString("MAPHDH")));
                    dto.setMasach(rs.getString("MASACH")); 
                    dto.setSoLuong(Integer.parseInt(rs.getString("SOLUONG")));
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
