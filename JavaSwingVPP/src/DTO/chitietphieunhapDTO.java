/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MY PC
 */
public class chitietphieunhapDTO 
{
    private String idpn;
    private String idmon;
    private int soluong;
    private float gianhap;
    private float thanhtien;
    public static String layIdpn;
        public chitietphieunhapDTO()
    {
        this.idpn = idpn;
        this.idmon = idmon;
        this.soluong = soluong;
        this.gianhap = gianhap;
        this.thanhtien = thanhtien;
        
    }
    
    public chitietphieunhapDTO(String idpn, String idmon, int soluong, float gianhap, float thanhtien)
    {
        this.idpn = idpn;
        this.idmon =idmon;
        this.soluong = soluong;
        this.gianhap = gianhap;
        this.thanhtien = thanhtien;
        
    }


    public String getIdpn() {
        return idpn;
    }

    public void setIdpn(String idpn) {
        this.idpn = idpn;
    }

    public String getIdmon() {
        return idmon;
    }

    public void setIdmon(String idmon) {
        this.idmon = idmon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
