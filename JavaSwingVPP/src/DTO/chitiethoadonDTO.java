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
public class chitiethoadonDTO 
{
    private String idhd;
    private String idmon;
    private int soluong;
    private float dongia;
    private float thanhtien;
    
    public static String layIdhoadon;

    public chitiethoadonDTO(String idhd, String idmon, int soluong, float dongia, float thanhtien ) 
    {
        this.idhd = idhd;
        this.idmon = idmon;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }
    public chitiethoadonDTO() 
    {
        this.idhd = idhd;
        this.idmon = idmon;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public String getIdhd() {
        return idhd;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
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

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public static String getLayIdhoadon() {
        return layIdhoadon;
    }

    public static void setLayIdhoadon(String layIdhoadon) {
        chitiethoadonDTO.layIdhoadon = layIdhoadon;
    }
    
    

}
