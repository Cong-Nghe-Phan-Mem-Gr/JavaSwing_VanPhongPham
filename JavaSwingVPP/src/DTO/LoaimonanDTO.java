/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


/**
 *
 * @author USER
 */
public class LoaimonanDTO {
    public String idloai,tenloai;
    
    public LoaimonanDTO(){};
    public LoaimonanDTO(String idloai,String tenloai){
        setIdloai(idloai);
        setLoaimon(tenloai);
    }
    public String getIdloai() {
        return idloai;
    }

    public String getLoaimon() {
        return tenloai;
    }

    public void setIdloai(String idloai) {
        this.idloai = idloai;
    }

    public void setLoaimon(String loaimon) {
        this.tenloai = loaimon;
    }
    
}
