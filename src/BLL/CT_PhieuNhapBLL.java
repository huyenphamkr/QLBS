/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CT_PhieuNhapDAL;
import DTO.CT_PhieuNhapDTO;
import java.util.Vector;


public class CT_PhieuNhapBLL {
    CT_PhieuNhapDAL DAL = new CT_PhieuNhapDAL();
    public Vector<CT_PhieuNhapDTO> getAllCT_PhieuNhap(int ma){
        return DAL.getAllCTPhieuNhap(ma);
    }
}
