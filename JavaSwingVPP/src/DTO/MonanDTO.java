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
public class MonanDTO {
    public String idmon,tenmon,trangthai,cogiamgia,tenloai,loai;
    public int idloai,tonkho,soluongdaban,dongia;

    public MonanDTO(){}
    public MonanDTO(String idmon,String tenmon,int idloai,String tenloai,int dongia,int tonkho,String trangthai,String cogiamgia,int soluongdaban){
        setIdmon(idmon);
        setTenmon(tenmon);
        setIdloai(idloai);
        setDongia(dongia);
        setTenloai(tenloai);
        setTonkho(tonkho);
        setTrangthai(trangthai);
        setCogiamgia(cogiamgia);
        setSoluongdaban(soluongdaban);
    }
    
    public void setSoluongdaban(int soluongdaban) {
        this.soluongdaban = soluongdaban;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public String getCogiamgia() {
        return cogiamgia;
    }

    public int getSoluongdaban() {
        return soluongdaban;
    }
    
    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getDongia() {
        return dongia;
    }
    
    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public void setIdmon(String idmon) {
        this.idmon = idmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public void setIdloai(int idloai) {
        this.idloai = idloai;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void setCogiamgia(String cogiamgia) {
        this.cogiamgia = cogiamgia;
    }

    public String getIdmon() {
        return idmon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public int getIdloai() {
        return idloai;
    }

    public int getTonkho() {
        return tonkho;
    }

    public String isTrangthai() {
        return trangthai;
    }

    public String isCogiamgia() {
        return cogiamgia;
    }
}
