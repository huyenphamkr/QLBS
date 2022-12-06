/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.CT_PhieuDHDAL;
import DTO.CT_PhieuDHDTO;
import java.util.Vector;


public class CT_PhieuDHBLL {
    CT_PhieuDHDAL DAL = new CT_PhieuDHDAL();
    public Vector<CT_PhieuDHDTO> getAllCT_PhieuDH(int ma){
        return DAL.getAllCTPhieuDH(ma);
    }
}
