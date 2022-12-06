/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.QuanLyDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DangNhapDAL {
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
    public boolean check(String user, String pass){ 
        boolean result = false;
        String u="";
        String m="";
        if (openConnection()) {
        try {
            String sql = "Select * from QUANLY where TENND='"+user+"' and MATKHAU='"+pass+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                    QuanLyDTO nvdto = new QuanLyDTO();
                    u = rs.getString("TENND");
                    m = rs.getString("MATKHAU");
            }
            if(u.equals(user) && m.equals(pass))
            {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally { closeConnection(); } }
        return result;
    }
}
