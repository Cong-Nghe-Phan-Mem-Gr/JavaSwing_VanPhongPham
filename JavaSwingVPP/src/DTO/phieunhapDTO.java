/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author MY PC
 */
public class phieunhapDTO 
{
    private  String idpn;
    private   String idncc;
    private String idnv;
    private String ngaynhap;
    private Float tongtien;
    private String trangthai;
    private float thanhtien;
    private String idmon;
    private float gianhap;
    private int soluong;

    
    
    public phieunhapDTO()
    {
        this.idpn = idpn;
        this.idncc = idncc;
        this.idnv = idnv;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }
    public phieunhapDTO(String idpn, String idncc, String idnv, String ngaynhap, Float tongtien, String trangthai)
    {
        this.idpn = idpn;
        this.idncc = idncc;
        this.idnv = idnv;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }
    
    public phieunhapDTO(String idpn, String idncc, String idnv, String ngaynhap, float tongtien, String trangthai,String idmon,int soluong,float gianhap,float thanhtien)
    {
        this.idpn = idpn;
        this.idncc = idncc;
        this.idnv = idnv;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
        this.thanhtien = thanhtien;
        this.gianhap = gianhap;
        this.idmon = idmon;
        this.thanhtien = thanhtien;
    }

    public String getIdpn() {
        return idpn;
    }

    public void setIdpn(String idpn) {
        this.idpn = idpn;
    }

    public String getIdncc() {
        return idncc;
    }

    public void setIdncc(String idncc) {
        this.idncc = idncc;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public Float getTongtien() {
        return tongtien;
    }

    public void setTongtien(Float tongtien) {
        this.tongtien = tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void setIdmon(String idmon) {
        this.idmon = idmon;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public String getIdmon() {
        return idmon;
    }

    public float getGianhap() {
        return gianhap;
    }

    public int getSoluong() {
        return soluong;
    }


    
    
}